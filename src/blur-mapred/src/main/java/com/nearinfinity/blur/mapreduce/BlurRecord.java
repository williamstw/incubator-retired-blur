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

package com.nearinfinity.blur.mapreduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.Writable;

public class BlurRecord implements Writable {
    
    public enum Operation {
        CREATE_ROW(1),
        REPLACE_ROW(2),
        DELETE_ROW(3);
        
        private int intVal;

        Operation(int intVal) {
            this.intVal = intVal;
        }

        public int getIntVal() {
            return intVal;
        }

        public static Operation value(int intVal) {
            switch (intVal) {
            case 1:
                return CREATE_ROW;
            case 2:
                return REPLACE_ROW;
            case 3:
                return DELETE_ROW;
            }
            return null;
        }
    }
    
    private Operation _operation = Operation.CREATE_ROW;
    private String _rowId;
    private String _recordId;
    private String _columnFamily;
    private List<BlurColumn> _columns = new ArrayList<BlurColumn>();

    @Override
    public void readFields(DataInput in) throws IOException {
        Operation.value(IOUtil.readVInt(in));
        _rowId = IOUtil.readString(in);
        _recordId = IOUtil.readString(in);
        _columnFamily = IOUtil.readString(in);
        int size = IOUtil.readVInt(in);
        _columns.clear();
        for (int i = 0; i < size; i++) {
            BlurColumn column = new BlurColumn();
            column.readFields(in);
            _columns.add(column);
        }
    }

    @Override
    public void write(DataOutput out) throws IOException {
        IOUtil.writeVInt(out, _operation.getIntVal());
        IOUtil.writeString(out, _rowId);
        IOUtil.writeString(out, _recordId);
        IOUtil.writeString(out, _columnFamily);
        IOUtil.writeVInt(out, _columns.size());
        for (BlurColumn column : _columns) {
            column.write(out);
        }
    }

    public String getRowId() {
        return _rowId;
    }

    public void setRowId(String rowId) {
        this._rowId = rowId;
    }

    public String getRecordId() {
        return _recordId;
    }

    public void setRecordId(String recordId) {
        this._recordId = recordId;
    }

    public String getColumnFamily() {
        return _columnFamily;
    }

    public void setColumnFamily(String columnFamily) {
        this._columnFamily = columnFamily;
    }

    public List<BlurColumn> getColumns() {
        return _columns;
    }

    public void setColumns(List<BlurColumn> columns) {
        this._columns = columns;
    }
    
    public void clearColumns() {
        _columns.clear();
    }

    public void addColumn(BlurColumn column) {
        _columns.add(column);
    }
    
    public void addColumn(String name, String value) {
        BlurColumn blurColumn = new BlurColumn();
        blurColumn.setName(name);
        blurColumn.setValues(Arrays.asList(value));
        addColumn(blurColumn);
    }

    public void addColumn(String name, List<String> values) {
        BlurColumn blurColumn = new BlurColumn();
        blurColumn.setName(name);
        blurColumn.setValues(values);
        addColumn(blurColumn);
    }

    public Operation getOperation() {
        return _operation;
    }

    public void setOperation(Operation operation) {
        this._operation = operation;
    }
}