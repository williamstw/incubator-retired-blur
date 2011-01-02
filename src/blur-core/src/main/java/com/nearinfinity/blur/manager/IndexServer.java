package com.nearinfinity.blur.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Similarity;

public interface IndexServer extends ClusterInfo {
    
    public enum TABLE_STATUS {
        ENABLED,
        DISABLED
    }
    
    /**
     * Gets the similarity object used by lucene for this table.
     * @param table the table name.
     * @return the similarity object.
     */
    Similarity getSimilarity(String table);
    
    /**
     * Gets the status of the table.
     * @param table the table name.
     * @return the status.
     */
    TABLE_STATUS getTableStatus(String table);
    
    /**
     * Gets the analyzer for the table.
     * @param table the table name.
     * @return the analyzer for lucene.
     */
    Analyzer getAnalyzer(String table);

    /**
     * Gets a map of the index readers for current running node.
     * @param table the table name.
     * @return the map of readers.
     * @throws IOException
     */
    Map<String, IndexReader> getIndexReaders(String table) throws IOException;

    /**
     * The table name list.
     * @return the list of tables.
     */
    List<String> getTableList();
    
    /** 
     * The shard list for a given table.
     * @param table the table name.
     * @return the list of shards.
     */
    List<String> getShardList(String table);
    
    /**
     * Closes the index server.
     */
    void close();

}
