/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package uk.co.dave.fxrate.consumer.avro.fxrateevent;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class FxRateEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1865688681915442814L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FxRateEvent\",\"namespace\":\"uk.co.dave.fxrate.consumer.avro.fxrateevent\",\"fields\":[{\"name\":\"fxRates\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FxRate\",\"fields\":[{\"name\":\"from\",\"type\":\"string\"},{\"name\":\"to\",\"type\":\"string\"},{\"name\":\"rate\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":7,\"scale\":6}}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<FxRateEvent> ENCODER =
      new BinaryMessageEncoder<FxRateEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<FxRateEvent> DECODER =
      new BinaryMessageDecoder<FxRateEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<FxRateEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<FxRateEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<FxRateEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<FxRateEvent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this FxRateEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a FxRateEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a FxRateEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static FxRateEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate> fxRates;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public FxRateEvent() {}

  /**
   * All-args constructor.
   * @param fxRates The new value for fxRates
   */
  public FxRateEvent(java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate> fxRates) {
    this.fxRates = fxRates;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return fxRates;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: fxRates = (java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'fxRates' field.
   * @return The value of the 'fxRates' field.
   */
  public java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate> getFxRates() {
    return fxRates;
  }


  /**
   * Sets the value of the 'fxRates' field.
   * @param value the value to set.
   */
  public void setFxRates(java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate> value) {
    this.fxRates = value;
  }

  /**
   * Creates a new FxRateEvent RecordBuilder.
   * @return A new FxRateEvent RecordBuilder
   */
  public static uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder newBuilder() {
    return new uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder();
  }

  /**
   * Creates a new FxRateEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new FxRateEvent RecordBuilder
   */
  public static uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder newBuilder(uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder other) {
    if (other == null) {
      return new uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder();
    } else {
      return new uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder(other);
    }
  }

  /**
   * Creates a new FxRateEvent RecordBuilder by copying an existing FxRateEvent instance.
   * @param other The existing instance to copy.
   * @return A new FxRateEvent RecordBuilder
   */
  public static uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder newBuilder(uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent other) {
    if (other == null) {
      return new uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder();
    } else {
      return new uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for FxRateEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FxRateEvent>
    implements org.apache.avro.data.RecordBuilder<FxRateEvent> {

    private java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate> fxRates;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.fxRates)) {
        this.fxRates = data().deepCopy(fields()[0].schema(), other.fxRates);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing FxRateEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.fxRates)) {
        this.fxRates = data().deepCopy(fields()[0].schema(), other.fxRates);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'fxRates' field.
      * @return The value.
      */
    public java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate> getFxRates() {
      return fxRates;
    }


    /**
      * Sets the value of the 'fxRates' field.
      * @param value The value of 'fxRates'.
      * @return This builder.
      */
    public uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder setFxRates(java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate> value) {
      validate(fields()[0], value);
      this.fxRates = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'fxRates' field has been set.
      * @return True if the 'fxRates' field has been set, false otherwise.
      */
    public boolean hasFxRates() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'fxRates' field.
      * @return This builder.
      */
    public uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRateEvent.Builder clearFxRates() {
      fxRates = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public FxRateEvent build() {
      try {
        FxRateEvent record = new FxRateEvent();
        record.fxRates = fieldSetFlags()[0] ? this.fxRates : (java.util.List<uk.co.dave.fxrate.consumer.avro.fxrateevent.FxRate>) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<FxRateEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<FxRateEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<FxRateEvent>
    READER$ = (org.apache.avro.io.DatumReader<FxRateEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}









