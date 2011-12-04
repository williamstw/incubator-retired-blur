/*
 * Copyright (C) 2011 Near Infinity Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nearinfinity.blur.thrift;

import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_BIND_ADDRESS;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_BIND_PORT;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_CACHE_MAX_QUERYCACHE_ELEMENTS;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_CACHE_MAX_TIMETOLIVE;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_HOSTNAME;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_REMOTE_FETCH_COUNT;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_SERVER_REMOTE_THREAD_COUNT;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_CONTROLLER_SERVER_THRIFT_THREAD_COUNT;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_ZOOKEEPER_CONNECTION;
import static com.nearinfinity.blur.utils.BlurConstants.BLUR_ZOOKEEPER_SYSTEM_TIME_TOLERANCE;
import static com.nearinfinity.blur.utils.BlurConstants.CRAZY;
import static com.nearinfinity.blur.utils.BlurUtil.quietClose;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.hadoop.conf.Configuration;
import org.apache.thrift.transport.TTransportException;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import com.nearinfinity.blur.BlurConfiguration;
import com.nearinfinity.blur.concurrent.SimpleUncaughtExceptionHandler;
import com.nearinfinity.blur.concurrent.ThreadWatcher;
import com.nearinfinity.blur.log.Log;
import com.nearinfinity.blur.log.LogFactory;
import com.nearinfinity.blur.manager.BlurQueryChecker;
import com.nearinfinity.blur.manager.clusterstatus.ZookeeperClusterStatus;
import com.nearinfinity.blur.manager.indexserver.BlurServerShutDown;
import com.nearinfinity.blur.manager.indexserver.BlurServerShutDown.BlurShutdown;
import com.nearinfinity.blur.metrics.BlurMetrics;
import com.nearinfinity.blur.thrift.client.BlurClient;
import com.nearinfinity.blur.thrift.client.BlurClientRemote;
import com.nearinfinity.blur.thrift.generated.BlurException;
import com.nearinfinity.blur.thrift.generated.Blur.Iface;
import com.nearinfinity.blur.utils.BlurUtil;
import com.nearinfinity.blur.zookeeper.ZkUtils;

public class ThriftBlurControllerServer extends ThriftServer {

  private static final Log LOG = LogFactory.getLog(ThriftBlurControllerServer.class);

  public static void main(String[] args) throws TTransportException, IOException, KeeperException, InterruptedException, BlurException {
    LOG.info("Setting up Controller Server");
    Thread.setDefaultUncaughtExceptionHandler(new SimpleUncaughtExceptionHandler());

    BlurConfiguration configuration = new BlurConfiguration();
    
    String bindAddress = configuration.get(BLUR_CONTROLLER_BIND_ADDRESS);
    int bindPort = configuration.getInt(BLUR_CONTROLLER_BIND_PORT,-1);
    
    Configuration config = new Configuration();
    BlurMetrics blurMetrics = new BlurMetrics(config);

    String nodeName = ThriftBlurShardServer.getNodeName(configuration, BLUR_CONTROLLER_HOSTNAME);
    nodeName = nodeName + ":" + bindPort;
    String zkConnectionStr = isEmpty(configuration.get(BLUR_ZOOKEEPER_CONNECTION), BLUR_ZOOKEEPER_CONNECTION);

    BlurQueryChecker queryChecker = new BlurQueryChecker(configuration);

    boolean crazyMode = false;
    if (args.length == 1 && args[1].equals(CRAZY)) {
      crazyMode = true;
    }

    final ZooKeeper zooKeeper = ZkUtils.newZooKeeper(zkConnectionStr);
    ZookeeperSystemTime.checkSystemTime(zooKeeper, configuration.getLong(BLUR_ZOOKEEPER_SYSTEM_TIME_TOLERANCE, 3000));

    final ZookeeperClusterStatus clusterStatus = new ZookeeperClusterStatus(zooKeeper);

    BlurClient client = new BlurClientRemote();
    
    final BlurControllerServer controllerServer = new BlurControllerServer();
    controllerServer.setClient(client);
    controllerServer.setClusterStatus(clusterStatus);
    controllerServer.setZookeeper(zooKeeper);
    controllerServer.setNodeName(nodeName);
    controllerServer.setRemoteFetchCount(configuration.getInt(BLUR_CONTROLLER_REMOTE_FETCH_COUNT, 100));
    controllerServer.setMaxQueryCacheElements(configuration.getInt(BLUR_CONTROLLER_CACHE_MAX_QUERYCACHE_ELEMENTS, 128));
    controllerServer.setMaxTimeToLive(configuration.getLong(BLUR_CONTROLLER_CACHE_MAX_TIMETOLIVE, TimeUnit.MINUTES.toMillis(1)));
    controllerServer.setQueryChecker(queryChecker);
    controllerServer.setThreadCount(configuration.getInt(BLUR_CONTROLLER_SERVER_REMOTE_THREAD_COUNT, 64));
    controllerServer.init();
    
    Iface iface = BlurUtil.recordMethodCallsAndAverageTimes(blurMetrics, controllerServer, Iface.class);

    int threadCount = configuration.getInt(BLUR_CONTROLLER_SERVER_THRIFT_THREAD_COUNT, 32);

    final ThriftBlurControllerServer server = new ThriftBlurControllerServer();
    server.setNodeName(nodeName);
    server.setConfiguration(configuration);
    server.setBindAddress(bindAddress);
    server.setBindPort(bindPort);
    server.setThreadCount(threadCount);
    if (crazyMode) {
      System.err.println("Crazy mode!!!!!");
      server.setIface(ThriftBlurShardServer.crazyMode(iface));
    } else {
      server.setIface(iface);
    }

    // This will shutdown the server when the correct path is set in zk
    new BlurServerShutDown().register(new BlurShutdown() {
      @Override
      public void shutdown() {
        ThreadWatcher threadWatcher = ThreadWatcher.instance();
        quietClose(server, controllerServer, clusterStatus, zooKeeper, threadWatcher);
        System.exit(0);
      }
    }, zooKeeper);

    server.start();
  }
}
