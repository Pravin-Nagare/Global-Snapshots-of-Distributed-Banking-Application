

/**

 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2015-11-12")
public class LocalSnapshot implements org.apache.thrift.TBase<LocalSnapshot, LocalSnapshot._Fields>, java.io.Serializable, Cloneable, Comparable<LocalSnapshot> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LocalSnapshot");

  private static final org.apache.thrift.protocol.TField SNAPSHOT_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("snapshot_num", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField BALANCE_FIELD_DESC = new org.apache.thrift.protocol.TField("balance", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField MESSAGES_FIELD_DESC = new org.apache.thrift.protocol.TField("messages", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LocalSnapshotStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LocalSnapshotTupleSchemeFactory());
  }

  public int snapshot_num; // required
  public int balance; // required
  public List<Integer> messages; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SNAPSHOT_NUM((short)1, "snapshot_num"),
    BALANCE((short)2, "balance"),
    MESSAGES((short)3, "messages");

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
        case 1: // SNAPSHOT_NUM
          return SNAPSHOT_NUM;
        case 2: // BALANCE
          return BALANCE;
        case 3: // MESSAGES
          return MESSAGES;
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
  private static final int __SNAPSHOT_NUM_ISSET_ID = 0;
  private static final int __BALANCE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SNAPSHOT_NUM, new org.apache.thrift.meta_data.FieldMetaData("snapshot_num", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BALANCE, new org.apache.thrift.meta_data.FieldMetaData("balance", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MESSAGES, new org.apache.thrift.meta_data.FieldMetaData("messages", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LocalSnapshot.class, metaDataMap);
  }

  public LocalSnapshot() {
  }

  public LocalSnapshot(
    int snapshot_num,
    int balance,
    List<Integer> messages)
  {
    this();
    this.snapshot_num = snapshot_num;
    setSnapshot_numIsSet(true);
    this.balance = balance;
    setBalanceIsSet(true);
    this.messages = messages;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LocalSnapshot(LocalSnapshot other) {
    __isset_bitfield = other.__isset_bitfield;
    this.snapshot_num = other.snapshot_num;
    this.balance = other.balance;
    if (other.isSetMessages()) {
      List<Integer> __this__messages = new ArrayList<Integer>(other.messages);
      this.messages = __this__messages;
    }
  }

  public LocalSnapshot deepCopy() {
    return new LocalSnapshot(this);
  }

  @Override
  public void clear() {
    setSnapshot_numIsSet(false);
    this.snapshot_num = 0;
    setBalanceIsSet(false);
    this.balance = 0;
    this.messages = null;
  }

  public int getSnapshot_num() {
    return this.snapshot_num;
  }

  public LocalSnapshot setSnapshot_num(int snapshot_num) {
    this.snapshot_num = snapshot_num;
    setSnapshot_numIsSet(true);
    return this;
  }

  public void unsetSnapshot_num() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SNAPSHOT_NUM_ISSET_ID);
  }

  /** Returns true if field snapshot_num is set (has been assigned a value) and false otherwise */
  public boolean isSetSnapshot_num() {
    return EncodingUtils.testBit(__isset_bitfield, __SNAPSHOT_NUM_ISSET_ID);
  }

  public void setSnapshot_numIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SNAPSHOT_NUM_ISSET_ID, value);
  }

  public int getBalance() {
    return this.balance;
  }

  public LocalSnapshot setBalance(int balance) {
    this.balance = balance;
    setBalanceIsSet(true);
    return this;
  }

  public void unsetBalance() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BALANCE_ISSET_ID);
  }

  /** Returns true if field balance is set (has been assigned a value) and false otherwise */
  public boolean isSetBalance() {
    return EncodingUtils.testBit(__isset_bitfield, __BALANCE_ISSET_ID);
  }

  public void setBalanceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BALANCE_ISSET_ID, value);
  }

  public int getMessagesSize() {
    return (this.messages == null) ? 0 : this.messages.size();
  }

  public java.util.Iterator<Integer> getMessagesIterator() {
    return (this.messages == null) ? null : this.messages.iterator();
  }

  public void addToMessages(int elem) {
    if (this.messages == null) {
      this.messages = new ArrayList<Integer>();
    }
    this.messages.add(elem);
  }

  public List<Integer> getMessages() {
    return this.messages;
  }

  public LocalSnapshot setMessages(List<Integer> messages) {
    this.messages = messages;
    return this;
  }

  public void unsetMessages() {
    this.messages = null;
  }

  /** Returns true if field messages is set (has been assigned a value) and false otherwise */
  public boolean isSetMessages() {
    return this.messages != null;
  }

  public void setMessagesIsSet(boolean value) {
    if (!value) {
      this.messages = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SNAPSHOT_NUM:
      if (value == null) {
        unsetSnapshot_num();
      } else {
        setSnapshot_num((Integer)value);
      }
      break;

    case BALANCE:
      if (value == null) {
        unsetBalance();
      } else {
        setBalance((Integer)value);
      }
      break;

    case MESSAGES:
      if (value == null) {
        unsetMessages();
      } else {
        setMessages((List<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SNAPSHOT_NUM:
      return getSnapshot_num();

    case BALANCE:
      return getBalance();

    case MESSAGES:
      return getMessages();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SNAPSHOT_NUM:
      return isSetSnapshot_num();
    case BALANCE:
      return isSetBalance();
    case MESSAGES:
      return isSetMessages();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LocalSnapshot)
      return this.equals((LocalSnapshot)that);
    return false;
  }

  public boolean equals(LocalSnapshot that) {
    if (that == null)
      return false;

    boolean this_present_snapshot_num = true;
    boolean that_present_snapshot_num = true;
    if (this_present_snapshot_num || that_present_snapshot_num) {
      if (!(this_present_snapshot_num && that_present_snapshot_num))
        return false;
      if (this.snapshot_num != that.snapshot_num)
        return false;
    }

    boolean this_present_balance = true;
    boolean that_present_balance = true;
    if (this_present_balance || that_present_balance) {
      if (!(this_present_balance && that_present_balance))
        return false;
      if (this.balance != that.balance)
        return false;
    }

    boolean this_present_messages = true && this.isSetMessages();
    boolean that_present_messages = true && that.isSetMessages();
    if (this_present_messages || that_present_messages) {
      if (!(this_present_messages && that_present_messages))
        return false;
      if (!this.messages.equals(that.messages))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_snapshot_num = true;
    list.add(present_snapshot_num);
    if (present_snapshot_num)
      list.add(snapshot_num);

    boolean present_balance = true;
    list.add(present_balance);
    if (present_balance)
      list.add(balance);

    boolean present_messages = true && (isSetMessages());
    list.add(present_messages);
    if (present_messages)
      list.add(messages);

    return list.hashCode();
  }

  @Override
  public int compareTo(LocalSnapshot other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSnapshot_num()).compareTo(other.isSetSnapshot_num());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSnapshot_num()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.snapshot_num, other.snapshot_num);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBalance()).compareTo(other.isSetBalance());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBalance()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.balance, other.balance);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessages()).compareTo(other.isSetMessages());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessages()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.messages, other.messages);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("LocalSnapshot(");
    boolean first = true;

    sb.append("snapshot_num:");
    sb.append(this.snapshot_num);
    first = false;
    if (!first) sb.append(", ");
    sb.append("balance:");
    sb.append(this.balance);
    first = false;
    if (!first) sb.append(", ");
    sb.append("messages:");
    if (this.messages == null) {
      sb.append("null");
    } else {
      sb.append(this.messages);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LocalSnapshotStandardSchemeFactory implements SchemeFactory {
    public LocalSnapshotStandardScheme getScheme() {
      return new LocalSnapshotStandardScheme();
    }
  }

  private static class LocalSnapshotStandardScheme extends StandardScheme<LocalSnapshot> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LocalSnapshot struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SNAPSHOT_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.snapshot_num = iprot.readI32();
              struct.setSnapshot_numIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BALANCE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.balance = iprot.readI32();
              struct.setBalanceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MESSAGES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.messages = new ArrayList<Integer>(_list0.size);
                int _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readI32();
                  struct.messages.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setMessagesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LocalSnapshot struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SNAPSHOT_NUM_FIELD_DESC);
      oprot.writeI32(struct.snapshot_num);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(BALANCE_FIELD_DESC);
      oprot.writeI32(struct.balance);
      oprot.writeFieldEnd();
      if (struct.messages != null) {
        oprot.writeFieldBegin(MESSAGES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.messages.size()));
          for (int _iter3 : struct.messages)
          {
            oprot.writeI32(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LocalSnapshotTupleSchemeFactory implements SchemeFactory {
    public LocalSnapshotTupleScheme getScheme() {
      return new LocalSnapshotTupleScheme();
    }
  }

  private static class LocalSnapshotTupleScheme extends TupleScheme<LocalSnapshot> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LocalSnapshot struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSnapshot_num()) {
        optionals.set(0);
      }
      if (struct.isSetBalance()) {
        optionals.set(1);
      }
      if (struct.isSetMessages()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSnapshot_num()) {
        oprot.writeI32(struct.snapshot_num);
      }
      if (struct.isSetBalance()) {
        oprot.writeI32(struct.balance);
      }
      if (struct.isSetMessages()) {
        {
          oprot.writeI32(struct.messages.size());
          for (int _iter4 : struct.messages)
          {
            oprot.writeI32(_iter4);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LocalSnapshot struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.snapshot_num = iprot.readI32();
        struct.setSnapshot_numIsSet(true);
      }
      if (incoming.get(1)) {
        struct.balance = iprot.readI32();
        struct.setBalanceIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.messages = new ArrayList<Integer>(_list5.size);
          int _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = iprot.readI32();
            struct.messages.add(_elem6);
          }
        }
        struct.setMessagesIsSet(true);
      }
    }
  }

}

