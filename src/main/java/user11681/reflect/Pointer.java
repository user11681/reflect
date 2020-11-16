package user11681.reflect;

import java.lang.reflect.Field;
import net.gudenau.lib.unsafe.Unsafe;

public class Pointer implements Cloneable {
    public Object object;
    public long offset;

    @Override
    public Pointer clone() {
        try {
            return (Pointer) super.clone();
        } catch (final CloneNotSupportedException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public Pointer bind(final Object object) {
        this.object = object;

        return this;
    }

    public Pointer offset(final long offset) {
        this.offset = offset;

        return this;
    }

    public Pointer staticField(final Class<?> klass, final String name) {
        this.offset = Unsafe.staticFieldOffset(Fields.getField(klass, name));

        return this;
    }

    public Pointer staticField(final String name) {
        this.offset = Unsafe.staticFieldOffset(Fields.getField((Class<?>) this.object, name));

        return this;
    }

    public Pointer staticField(final Field field) {
        this.offset = Unsafe.staticFieldOffset(field);

        return this;
    }

    public Pointer instanceField(final Class<?> klass, final String name) {
        this.offset = Unsafe.objectFieldOffset(Fields.getField(klass, name));

        return this;
    }

    public Pointer instanceField(final String name) {
        this.offset = Unsafe.objectFieldOffset(Fields.getField(this.object, name));

        return this;
    }

    public Pointer instanceField(final Field field) {
        this.offset = Unsafe.objectFieldOffset(field);

        return this;
    }

    public <T> T get() {
        return (T) Unsafe.getObject(this.object, this.offset);
    }

    public <T> T get(final Object object) {
        return (T) Unsafe.getObject(object, this.offset);
    }

    public void put(final Object object, final Object value) {
        Unsafe.putObject(object, this.offset, value);
    }

    public void put(final Object value) {
        Unsafe.putObject(this.object, this.offset, value);
    }

    public boolean getBoolean() {
        return Unsafe.getBoolean(this.object, this.offset);
    }

    public boolean getBoolean(final Object object) {
        return Unsafe.getBoolean(object, this.offset);
    }

    public void putBoolean(final Object object, final boolean value) {
        Unsafe.putBoolean(object, this.offset, value);
    }

    public void putBoolean(final boolean value) {
        Unsafe.putBoolean(this.object, this.offset, value);
    }

    public byte getByte() {
        return Unsafe.getByte(this.object, this.offset);
    }

    public byte getByte(final Object object) {
        return Unsafe.getByte(object, this.offset);
    }

    public void putByte(final Object object, final byte value) {
        Unsafe.putByte(object, this.offset, value);
    }

    public void putByte(final byte value) {
        Unsafe.putByte(this.object, this.offset, value);
    }

    public short getShort() {
        return Unsafe.getShort(this.object, this.offset);
    }

    public short getShort(final Object object) {
        return Unsafe.getShort(object, this.offset);
    }

    public void putShort(final Object object, final short value) {
        Unsafe.putShort(object, this.offset, value);
    }

    public void putShort(final short value) {
        Unsafe.putShort(this.object, this.offset, value);
    }

    public char getChar() {
        return Unsafe.getChar(this.object, this.offset);
    }

    public char getChar(final Object object) {
        return Unsafe.getChar(object, this.offset);
    }

    public void putChar(final Object object, final char value) {
        Unsafe.putChar(object, this.offset, value);
    }

    public void putChar(final char value) {
        Unsafe.putChar(this.object, this.offset, value);
    }

    public int getInt() {
        return Unsafe.getInt(this.object, this.offset);
    }

    public int getInt(final Object object) {
        return Unsafe.getInt(object, this.offset);
    }

    public void putInt(final Object object, final int value) {
        Unsafe.putInt(object, this.offset, value);
    }

    public void putInt(final int value) {
        Unsafe.putInt(this.object, this.offset, value);
    }

    public long getLong() {
        return Unsafe.getLong(this.object, this.offset);
    }

    public long getLong(final Object object) {
        return Unsafe.getLong(object, this.offset);
    }

    public void putLong(final Object object, final long value) {
        Unsafe.putLong(object, this.offset, value);
    }

    public void putLong(final long value) {
        Unsafe.putLong(this.object, this.offset, value);
    }

    public float getFloat() {
        return Unsafe.getFloat(this.object, this.offset);
    }

    public float getFloat(final Object object) {
        return Unsafe.getFloat(object, this.offset);
    }

    public void putFloat(final Object object, final float value) {
        Unsafe.putFloat(object, this.offset, value);
    }

    public void putFloat(final float value) {
        Unsafe.putFloat(this.object, this.offset, value);
    }

    public double getDouble() {
        return Unsafe.getDouble(this.object, this.offset);
    }

    public double getDouble(final Object object) {
        return Unsafe.getDouble(object, this.offset);
    }

    public void putDouble(final Object object, final double value) {
        Unsafe.putDouble(object, this.offset, value);
    }

    public void putDouble(final double value) {
        Unsafe.putDouble(this.object, this.offset, value);
    }

    public <T> T getVolatile() {
        return (T) Unsafe.getObjectVolatile(this.object, this.offset);
    }

    public <T> T getVolatile(final Object object) {
        return (T) Unsafe.getObjectVolatile(object, this.offset);
    }

    public void putVolatile(final Object object, final Object value) {
        Unsafe.putObjectVolatile(object, this.offset, value);
    }

    public void putVolatile(final Object value) {
        Unsafe.putObjectVolatile(this.object, this.offset, value);
    }

    public boolean getBooleanVolatile() {
        return Unsafe.getBooleanVolatile(this.object, this.offset);
    }

    public boolean getBooleanVolatile(final Object object) {
        return Unsafe.getBooleanVolatile(object, this.offset);
    }

    public void putBooleanVolatile(final Object object, final boolean value) {
        Unsafe.putBooleanVolatile(object, this.offset, value);
    }

    public void putBooleanVolatile(final boolean value) {
        Unsafe.putBooleanVolatile(this.object, this.offset, value);
    }

    public byte getByteVolatile() {
        return Unsafe.getByteVolatile(this.object, this.offset);
    }

    public byte getByteVolatile(final Object object) {
        return Unsafe.getByteVolatile(object, this.offset);
    }

    public void putByteVolatile(final Object object, final byte value) {
        Unsafe.putByteVolatile(object, this.offset, value);
    }

    public void putByteVolatile(final byte value) {
        Unsafe.putByteVolatile(this.object, this.offset, value);
    }

    public short getShortVolatile() {
        return Unsafe.getShortVolatile(this.object, this.offset);
    }

    public short getShortVolatile(final Object object) {
        return Unsafe.getShortVolatile(object, this.offset);
    }

    public void putShortVolatile(final Object object, final short value) {
        Unsafe.putShortVolatile(object, this.offset, value);
    }

    public void putShortVolatile(final short value) {
        Unsafe.putShortVolatile(this.object, this.offset, value);
    }

    public char getCharVolatile() {
        return Unsafe.getCharVolatile(this.object, this.offset);
    }

    public char getCharVolatile(final Object object) {
        return Unsafe.getCharVolatile(object, this.offset);
    }

    public void putCharVolatile(final Object object, final char value) {
        Unsafe.putCharVolatile(object, this.offset, value);
    }

    public void putCharVolatile(final char value) {
        Unsafe.putCharVolatile(this.object, this.offset, value);
    }

    public int getIntVolatile() {
        return Unsafe.getIntVolatile(this.object, this.offset);
    }

    public int getIntVolatile(final Object object) {
        return Unsafe.getIntVolatile(object, this.offset);
    }

    public void putIntVolatile(final Object object, final int value) {
        Unsafe.putIntVolatile(object, this.offset, value);
    }

    public void putIntVolatile(final int value) {
        Unsafe.putIntVolatile(this.object, this.offset, value);
    }

    public long getLongVolatile() {
        return Unsafe.getLongVolatile(this.object, this.offset);
    }

    public long getLongVolatile(final Object object) {
        return Unsafe.getLongVolatile(object, this.offset);
    }

    public void putLongVolatile(final Object object, final long value) {
        Unsafe.putLongVolatile(object, this.offset, value);
    }

    public void putLongVolatile(final long value) {
        Unsafe.putLongVolatile(this.object, this.offset, value);
    }

    public float getFloatVolatile() {
        return Unsafe.getFloatVolatile(this.object, this.offset);
    }

    public float getFloatVolatile(final Object object) {
        return Unsafe.getFloatVolatile(object, this.offset);
    }

    public void putFloatVolatile(final Object object, final float value) {
        Unsafe.putFloatVolatile(object, this.offset, value);
    }

    public void putFloatVolatile(final float value) {
        Unsafe.putFloatVolatile(this.object, this.offset, value);
    }

    public double getDoubleVolatile() {
        return Unsafe.getDoubleVolatile(this.object, this.offset);
    }

    public double getDoubleVolatile(final Object object) {
        return Unsafe.getDoubleVolatile(object, this.offset);
    }

    public void putDoubleVolatile(final Object object, final double value) {
        Unsafe.putDoubleVolatile(object, this.offset, value);
    }

    public void putDoubleVolatile(final double value) {
        Unsafe.putDoubleVolatile(this.object, this.offset, value);
    }
}
