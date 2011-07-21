/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.nearinfinity.blur.thrift.generated;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Selector implements org.apache.thrift.TBase<Selector, Selector._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Selector");

  private static final org.apache.thrift.protocol.TField RECORD_ONLY_FIELD_DESC = new org.apache.thrift.protocol.TField("recordOnly", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField LOCATION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("locationId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ROW_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("rowId", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField RECORD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("recordId", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField COLUMN_FAMILIES_TO_FETCH_FIELD_DESC = new org.apache.thrift.protocol.TField("columnFamiliesToFetch", org.apache.thrift.protocol.TType.SET, (short)5);
  private static final org.apache.thrift.protocol.TField COLUMNS_TO_FETCH_FIELD_DESC = new org.apache.thrift.protocol.TField("columnsToFetch", org.apache.thrift.protocol.TType.MAP, (short)6);
  private static final org.apache.thrift.protocol.TField TRANSACTION_FIELD_DESC = new org.apache.thrift.protocol.TField("transaction", org.apache.thrift.protocol.TType.STRUCT, (short)7);

  public boolean recordOnly;
  public String locationId;
  public String rowId;
  public String recordId;
  public Set<String> columnFamiliesToFetch;
  public Map<String,Set<String>> columnsToFetch;
  public Transaction transaction;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RECORD_ONLY((short)1, "recordOnly"),
    LOCATION_ID((short)2, "locationId"),
    ROW_ID((short)3, "rowId"),
    RECORD_ID((short)4, "recordId"),
    COLUMN_FAMILIES_TO_FETCH((short)5, "columnFamiliesToFetch"),
    COLUMNS_TO_FETCH((short)6, "columnsToFetch"),
    TRANSACTION((short)7, "transaction");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RECORD_ONLY
          return RECORD_ONLY;
        case 2: // LOCATION_ID
          return LOCATION_ID;
        case 3: // ROW_ID
          return ROW_ID;
        case 4: // RECORD_ID
          return RECORD_ID;
        case 5: // COLUMN_FAMILIES_TO_FETCH
          return COLUMN_FAMILIES_TO_FETCH;
        case 6: // COLUMNS_TO_FETCH
          return COLUMNS_TO_FETCH;
        case 7: // TRANSACTION
          return TRANSACTION;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __RECORDONLY_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RECORD_ONLY, new org.apache.thrift.meta_data.FieldMetaData("recordOnly", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.LOCATION_ID, new org.apache.thrift.meta_data.FieldMetaData("locationId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ROW_ID, new org.apache.thrift.meta_data.FieldMetaData("rowId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RECORD_ID, new org.apache.thrift.meta_data.FieldMetaData("recordId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COLUMN_FAMILIES_TO_FETCH, new org.apache.thrift.meta_data.FieldMetaData("columnFamiliesToFetch", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.COLUMNS_TO_FETCH, new org.apache.thrift.meta_data.FieldMetaData("columnsToFetch", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)))));
    tmpMap.put(_Fields.TRANSACTION, new org.apache.thrift.meta_data.FieldMetaData("transaction", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Transaction.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Selector.class, metaDataMap);
  }

  public Selector() {
  }

  public Selector(
    boolean recordOnly,
    String locationId,
    String rowId,
    String recordId,
    Set<String> columnFamiliesToFetch,
    Map<String,Set<String>> columnsToFetch,
    Transaction transaction)
  {
    this();
    this.recordOnly = recordOnly;
    setRecordOnlyIsSet(true);
    this.locationId = locationId;
    this.rowId = rowId;
    this.recordId = recordId;
    this.columnFamiliesToFetch = columnFamiliesToFetch;
    this.columnsToFetch = columnsToFetch;
    this.transaction = transaction;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Selector(Selector other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.recordOnly = other.recordOnly;
    if (other.isSetLocationId()) {
      this.locationId = other.locationId;
    }
    if (other.isSetRowId()) {
      this.rowId = other.rowId;
    }
    if (other.isSetRecordId()) {
      this.recordId = other.recordId;
    }
    if (other.isSetColumnFamiliesToFetch()) {
      Set<String> __this__columnFamiliesToFetch = new HashSet<String>();
      for (String other_element : other.columnFamiliesToFetch) {
        __this__columnFamiliesToFetch.add(other_element);
      }
      this.columnFamiliesToFetch = __this__columnFamiliesToFetch;
    }
    if (other.isSetColumnsToFetch()) {
      Map<String,Set<String>> __this__columnsToFetch = new HashMap<String,Set<String>>();
      for (Map.Entry<String, Set<String>> other_element : other.columnsToFetch.entrySet()) {

        String other_element_key = other_element.getKey();
        Set<String> other_element_value = other_element.getValue();

        String __this__columnsToFetch_copy_key = other_element_key;

        Set<String> __this__columnsToFetch_copy_value = new HashSet<String>();
        for (String other_element_value_element : other_element_value) {
          __this__columnsToFetch_copy_value.add(other_element_value_element);
        }

        __this__columnsToFetch.put(__this__columnsToFetch_copy_key, __this__columnsToFetch_copy_value);
      }
      this.columnsToFetch = __this__columnsToFetch;
    }
    if (other.isSetTransaction()) {
      this.transaction = new Transaction(other.transaction);
    }
  }

  public Selector deepCopy() {
    return new Selector(this);
  }

  @Override
  public void clear() {
    setRecordOnlyIsSet(false);
    this.recordOnly = false;
    this.locationId = null;
    this.rowId = null;
    this.recordId = null;
    this.columnFamiliesToFetch = null;
    this.columnsToFetch = null;
    this.transaction = null;
  }

  public boolean isRecordOnly() {
    return this.recordOnly;
  }

  public Selector setRecordOnly(boolean recordOnly) {
    this.recordOnly = recordOnly;
    setRecordOnlyIsSet(true);
    return this;
  }

  public void unsetRecordOnly() {
    __isset_bit_vector.clear(__RECORDONLY_ISSET_ID);
  }

  /** Returns true if field recordOnly is set (has been assigned a value) and false otherwise */
  public boolean isSetRecordOnly() {
    return __isset_bit_vector.get(__RECORDONLY_ISSET_ID);
  }

  public void setRecordOnlyIsSet(boolean value) {
    __isset_bit_vector.set(__RECORDONLY_ISSET_ID, value);
  }

  public String getLocationId() {
    return this.locationId;
  }

  public Selector setLocationId(String locationId) {
    this.locationId = locationId;
    return this;
  }

  public void unsetLocationId() {
    this.locationId = null;
  }

  /** Returns true if field locationId is set (has been assigned a value) and false otherwise */
  public boolean isSetLocationId() {
    return this.locationId != null;
  }

  public void setLocationIdIsSet(boolean value) {
    if (!value) {
      this.locationId = null;
    }
  }

  public String getRowId() {
    return this.rowId;
  }

  public Selector setRowId(String rowId) {
    this.rowId = rowId;
    return this;
  }

  public void unsetRowId() {
    this.rowId = null;
  }

  /** Returns true if field rowId is set (has been assigned a value) and false otherwise */
  public boolean isSetRowId() {
    return this.rowId != null;
  }

  public void setRowIdIsSet(boolean value) {
    if (!value) {
      this.rowId = null;
    }
  }

  public String getRecordId() {
    return this.recordId;
  }

  public Selector setRecordId(String recordId) {
    this.recordId = recordId;
    return this;
  }

  public void unsetRecordId() {
    this.recordId = null;
  }

  /** Returns true if field recordId is set (has been assigned a value) and false otherwise */
  public boolean isSetRecordId() {
    return this.recordId != null;
  }

  public void setRecordIdIsSet(boolean value) {
    if (!value) {
      this.recordId = null;
    }
  }

  public int getColumnFamiliesToFetchSize() {
    return (this.columnFamiliesToFetch == null) ? 0 : this.columnFamiliesToFetch.size();
  }

  public java.util.Iterator<String> getColumnFamiliesToFetchIterator() {
    return (this.columnFamiliesToFetch == null) ? null : this.columnFamiliesToFetch.iterator();
  }

  public void addToColumnFamiliesToFetch(String elem) {
    if (this.columnFamiliesToFetch == null) {
      this.columnFamiliesToFetch = new HashSet<String>();
    }
    this.columnFamiliesToFetch.add(elem);
  }

  public Set<String> getColumnFamiliesToFetch() {
    return this.columnFamiliesToFetch;
  }

  public Selector setColumnFamiliesToFetch(Set<String> columnFamiliesToFetch) {
    this.columnFamiliesToFetch = columnFamiliesToFetch;
    return this;
  }

  public void unsetColumnFamiliesToFetch() {
    this.columnFamiliesToFetch = null;
  }

  /** Returns true if field columnFamiliesToFetch is set (has been assigned a value) and false otherwise */
  public boolean isSetColumnFamiliesToFetch() {
    return this.columnFamiliesToFetch != null;
  }

  public void setColumnFamiliesToFetchIsSet(boolean value) {
    if (!value) {
      this.columnFamiliesToFetch = null;
    }
  }

  public int getColumnsToFetchSize() {
    return (this.columnsToFetch == null) ? 0 : this.columnsToFetch.size();
  }

  public void putToColumnsToFetch(String key, Set<String> val) {
    if (this.columnsToFetch == null) {
      this.columnsToFetch = new HashMap<String,Set<String>>();
    }
    this.columnsToFetch.put(key, val);
  }

  public Map<String,Set<String>> getColumnsToFetch() {
    return this.columnsToFetch;
  }

  public Selector setColumnsToFetch(Map<String,Set<String>> columnsToFetch) {
    this.columnsToFetch = columnsToFetch;
    return this;
  }

  public void unsetColumnsToFetch() {
    this.columnsToFetch = null;
  }

  /** Returns true if field columnsToFetch is set (has been assigned a value) and false otherwise */
  public boolean isSetColumnsToFetch() {
    return this.columnsToFetch != null;
  }

  public void setColumnsToFetchIsSet(boolean value) {
    if (!value) {
      this.columnsToFetch = null;
    }
  }

  public Transaction getTransaction() {
    return this.transaction;
  }

  public Selector setTransaction(Transaction transaction) {
    this.transaction = transaction;
    return this;
  }

  public void unsetTransaction() {
    this.transaction = null;
  }

  /** Returns true if field transaction is set (has been assigned a value) and false otherwise */
  public boolean isSetTransaction() {
    return this.transaction != null;
  }

  public void setTransactionIsSet(boolean value) {
    if (!value) {
      this.transaction = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RECORD_ONLY:
      if (value == null) {
        unsetRecordOnly();
      } else {
        setRecordOnly((Boolean)value);
      }
      break;

    case LOCATION_ID:
      if (value == null) {
        unsetLocationId();
      } else {
        setLocationId((String)value);
      }
      break;

    case ROW_ID:
      if (value == null) {
        unsetRowId();
      } else {
        setRowId((String)value);
      }
      break;

    case RECORD_ID:
      if (value == null) {
        unsetRecordId();
      } else {
        setRecordId((String)value);
      }
      break;

    case COLUMN_FAMILIES_TO_FETCH:
      if (value == null) {
        unsetColumnFamiliesToFetch();
      } else {
        setColumnFamiliesToFetch((Set<String>)value);
      }
      break;

    case COLUMNS_TO_FETCH:
      if (value == null) {
        unsetColumnsToFetch();
      } else {
        setColumnsToFetch((Map<String,Set<String>>)value);
      }
      break;

    case TRANSACTION:
      if (value == null) {
        unsetTransaction();
      } else {
        setTransaction((Transaction)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RECORD_ONLY:
      return new Boolean(isRecordOnly());

    case LOCATION_ID:
      return getLocationId();

    case ROW_ID:
      return getRowId();

    case RECORD_ID:
      return getRecordId();

    case COLUMN_FAMILIES_TO_FETCH:
      return getColumnFamiliesToFetch();

    case COLUMNS_TO_FETCH:
      return getColumnsToFetch();

    case TRANSACTION:
      return getTransaction();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RECORD_ONLY:
      return isSetRecordOnly();
    case LOCATION_ID:
      return isSetLocationId();
    case ROW_ID:
      return isSetRowId();
    case RECORD_ID:
      return isSetRecordId();
    case COLUMN_FAMILIES_TO_FETCH:
      return isSetColumnFamiliesToFetch();
    case COLUMNS_TO_FETCH:
      return isSetColumnsToFetch();
    case TRANSACTION:
      return isSetTransaction();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Selector)
      return this.equals((Selector)that);
    return false;
  }

  public boolean equals(Selector that) {
    if (that == null)
      return false;

    boolean this_present_recordOnly = true;
    boolean that_present_recordOnly = true;
    if (this_present_recordOnly || that_present_recordOnly) {
      if (!(this_present_recordOnly && that_present_recordOnly))
        return false;
      if (this.recordOnly != that.recordOnly)
        return false;
    }

    boolean this_present_locationId = true && this.isSetLocationId();
    boolean that_present_locationId = true && that.isSetLocationId();
    if (this_present_locationId || that_present_locationId) {
      if (!(this_present_locationId && that_present_locationId))
        return false;
      if (!this.locationId.equals(that.locationId))
        return false;
    }

    boolean this_present_rowId = true && this.isSetRowId();
    boolean that_present_rowId = true && that.isSetRowId();
    if (this_present_rowId || that_present_rowId) {
      if (!(this_present_rowId && that_present_rowId))
        return false;
      if (!this.rowId.equals(that.rowId))
        return false;
    }

    boolean this_present_recordId = true && this.isSetRecordId();
    boolean that_present_recordId = true && that.isSetRecordId();
    if (this_present_recordId || that_present_recordId) {
      if (!(this_present_recordId && that_present_recordId))
        return false;
      if (!this.recordId.equals(that.recordId))
        return false;
    }

    boolean this_present_columnFamiliesToFetch = true && this.isSetColumnFamiliesToFetch();
    boolean that_present_columnFamiliesToFetch = true && that.isSetColumnFamiliesToFetch();
    if (this_present_columnFamiliesToFetch || that_present_columnFamiliesToFetch) {
      if (!(this_present_columnFamiliesToFetch && that_present_columnFamiliesToFetch))
        return false;
      if (!this.columnFamiliesToFetch.equals(that.columnFamiliesToFetch))
        return false;
    }

    boolean this_present_columnsToFetch = true && this.isSetColumnsToFetch();
    boolean that_present_columnsToFetch = true && that.isSetColumnsToFetch();
    if (this_present_columnsToFetch || that_present_columnsToFetch) {
      if (!(this_present_columnsToFetch && that_present_columnsToFetch))
        return false;
      if (!this.columnsToFetch.equals(that.columnsToFetch))
        return false;
    }

    boolean this_present_transaction = true && this.isSetTransaction();
    boolean that_present_transaction = true && that.isSetTransaction();
    if (this_present_transaction || that_present_transaction) {
      if (!(this_present_transaction && that_present_transaction))
        return false;
      if (!this.transaction.equals(that.transaction))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Selector other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Selector typedOther = (Selector)other;

    lastComparison = Boolean.valueOf(isSetRecordOnly()).compareTo(typedOther.isSetRecordOnly());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecordOnly()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recordOnly, typedOther.recordOnly);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLocationId()).compareTo(typedOther.isSetLocationId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLocationId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.locationId, typedOther.locationId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRowId()).compareTo(typedOther.isSetRowId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRowId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rowId, typedOther.rowId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRecordId()).compareTo(typedOther.isSetRecordId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecordId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recordId, typedOther.recordId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumnFamiliesToFetch()).compareTo(typedOther.isSetColumnFamiliesToFetch());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumnFamiliesToFetch()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columnFamiliesToFetch, typedOther.columnFamiliesToFetch);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumnsToFetch()).compareTo(typedOther.isSetColumnsToFetch());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumnsToFetch()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columnsToFetch, typedOther.columnsToFetch);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTransaction()).compareTo(typedOther.isSetTransaction());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTransaction()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.transaction, typedOther.transaction);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // RECORD_ONLY
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.recordOnly = iprot.readBool();
            setRecordOnlyIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // LOCATION_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.locationId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // ROW_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.rowId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // RECORD_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.recordId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // COLUMN_FAMILIES_TO_FETCH
          if (field.type == org.apache.thrift.protocol.TType.SET) {
            {
              org.apache.thrift.protocol.TSet _set15 = iprot.readSetBegin();
              this.columnFamiliesToFetch = new HashSet<String>(2*_set15.size);
              for (int _i16 = 0; _i16 < _set15.size; ++_i16)
              {
                String _elem17;
                _elem17 = iprot.readString();
                this.columnFamiliesToFetch.add(_elem17);
              }
              iprot.readSetEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // COLUMNS_TO_FETCH
          if (field.type == org.apache.thrift.protocol.TType.MAP) {
            {
              org.apache.thrift.protocol.TMap _map18 = iprot.readMapBegin();
              this.columnsToFetch = new HashMap<String,Set<String>>(2*_map18.size);
              for (int _i19 = 0; _i19 < _map18.size; ++_i19)
              {
                String _key20;
                Set<String> _val21;
                _key20 = iprot.readString();
                {
                  org.apache.thrift.protocol.TSet _set22 = iprot.readSetBegin();
                  _val21 = new HashSet<String>(2*_set22.size);
                  for (int _i23 = 0; _i23 < _set22.size; ++_i23)
                  {
                    String _elem24;
                    _elem24 = iprot.readString();
                    _val21.add(_elem24);
                  }
                  iprot.readSetEnd();
                }
                this.columnsToFetch.put(_key20, _val21);
              }
              iprot.readMapEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // TRANSACTION
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.transaction = new Transaction();
            this.transaction.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(RECORD_ONLY_FIELD_DESC);
    oprot.writeBool(this.recordOnly);
    oprot.writeFieldEnd();
    if (this.locationId != null) {
      oprot.writeFieldBegin(LOCATION_ID_FIELD_DESC);
      oprot.writeString(this.locationId);
      oprot.writeFieldEnd();
    }
    if (this.rowId != null) {
      oprot.writeFieldBegin(ROW_ID_FIELD_DESC);
      oprot.writeString(this.rowId);
      oprot.writeFieldEnd();
    }
    if (this.recordId != null) {
      oprot.writeFieldBegin(RECORD_ID_FIELD_DESC);
      oprot.writeString(this.recordId);
      oprot.writeFieldEnd();
    }
    if (this.columnFamiliesToFetch != null) {
      oprot.writeFieldBegin(COLUMN_FAMILIES_TO_FETCH_FIELD_DESC);
      {
        oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, this.columnFamiliesToFetch.size()));
        for (String _iter25 : this.columnFamiliesToFetch)
        {
          oprot.writeString(_iter25);
        }
        oprot.writeSetEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.columnsToFetch != null) {
      oprot.writeFieldBegin(COLUMNS_TO_FETCH_FIELD_DESC);
      {
        oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.SET, this.columnsToFetch.size()));
        for (Map.Entry<String, Set<String>> _iter26 : this.columnsToFetch.entrySet())
        {
          oprot.writeString(_iter26.getKey());
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, _iter26.getValue().size()));
            for (String _iter27 : _iter26.getValue())
            {
              oprot.writeString(_iter27);
            }
            oprot.writeSetEnd();
          }
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.transaction != null) {
      oprot.writeFieldBegin(TRANSACTION_FIELD_DESC);
      this.transaction.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Selector(");
    boolean first = true;

    sb.append("recordOnly:");
    sb.append(this.recordOnly);
    first = false;
    if (!first) sb.append(", ");
    sb.append("locationId:");
    if (this.locationId == null) {
      sb.append("null");
    } else {
      sb.append(this.locationId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("rowId:");
    if (this.rowId == null) {
      sb.append("null");
    } else {
      sb.append(this.rowId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("recordId:");
    if (this.recordId == null) {
      sb.append("null");
    } else {
      sb.append(this.recordId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("columnFamiliesToFetch:");
    if (this.columnFamiliesToFetch == null) {
      sb.append("null");
    } else {
      sb.append(this.columnFamiliesToFetch);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("columnsToFetch:");
    if (this.columnsToFetch == null) {
      sb.append("null");
    } else {
      sb.append(this.columnsToFetch);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("transaction:");
    if (this.transaction == null) {
      sb.append("null");
    } else {
      sb.append(this.transaction);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}
