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
        } catch (CloneNotSupportedException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public Pointer bind(Object object) {
        this.object = object;

        return this;
    }

    public Pointer offset(long offset) {
        this.offset = offset;

        return this;
    }

    public Pointer staticField(Class<?> klass, String name) {
        this.object = klass;
        this.offset = Unsafe.staticFieldOffset(Fields.field(klass, name));

        return this;
    }

    public Pointer staticField(String name) {
        this.offset = Unsafe.staticFieldOffset(Fields.field((Class<?>) this.object, name));

        return this;
    }

    public Pointer staticField(Field field) {
        this.object = field.getDeclaringClass();
        this.offset = Unsafe.staticFieldOffset(field);

        return this;
    }

    public Pointer instanceField(Class<?> klass, String name) {
        this.offset = Unsafe.objectFieldOffset(Fields.field(klass, name));

        return this;
    }

    public Pointer instanceField(String name) {
        this.offset = Unsafe.objectFieldOffset(Fields.field(this.object, name));

        return this;
    }

    public Pointer instanceField(Field field) {
        this.offset = Unsafe.objectFieldOffset(field);

        return this;
    }

    public <T> T getObject() {
        return Unsafe.getObject(this.object, this.offset);
    }

    public <T> T getObject(Object object) {
        return Unsafe.getObject(object, this.offset);
    }

    public void putObject(Object object, Object value) {
        Unsafe.putObject(object, this.offset, value);
    }

    public void putObject(Object value) {
        Unsafe.putObject(this.object, this.offset, value);
    }

    public boolean getBoolean() {
        return Unsafe.getBoolean(this.object, this.offset);
    }

    public boolean getBoolean(Object object) {
        return Unsafe.getBoolean(object, this.offset);
    }

    public void putBoolean(Object object, boolean value) {
        Unsafe.putBoolean(object, this.offset, value);
    }

    public void putBoolean(boolean value) {
        Unsafe.putBoolean(this.object, this.offset, value);
    }

    public byte getByte() {
        return Unsafe.getByte(this.object, this.offset);
    }

    public byte getByte(Object object) {
        return Unsafe.getByte(object, this.offset);
    }

    public void putByte(Object object, byte value) {
        Unsafe.putByte(object, this.offset, value);
    }

    public void putByte(byte value) {
        Unsafe.putByte(this.object, this.offset, value);
    }

    public short getShort() {
        return Unsafe.getShort(this.object, this.offset);
    }

    public short getShort(Object object) {
        return Unsafe.getShort(object, this.offset);
    }

    public void putShort(Object object, short value) {
        Unsafe.putShort(object, this.offset, value);
    }

    public void putShort(short value) {
        Unsafe.putShort(this.object, this.offset, value);
    }

    public char getChar() {
        return Unsafe.getChar(this.object, this.offset);
    }

    public char getChar(Object object) {
        return Unsafe.getChar(object, this.offset);
    }

    public void putChar(Object object, char value) {
        Unsafe.putChar(object, this.offset, value);
    }

    public void putChar(char value) {
        Unsafe.putChar(this.object, this.offset, value);
    }

    public int getInt() {
        return Unsafe.getInt(this.object, this.offset);
    }

    public int getInt(Object object) {
        return Unsafe.getInt(object, this.offset);
    }

    public void putInt(Object object, int value) {
        Unsafe.putInt(object, this.offset, value);
    }

    public void putInt(int value) {
        Unsafe.putInt(this.object, this.offset, value);
    }

    public long getLong() {
        return Unsafe.getLong(this.object, this.offset);
    }

    public long getLong(Object object) {
        return Unsafe.getLong(object, this.offset);
    }

    public void putLong(Object object, long value) {
        Unsafe.putLong(object, this.offset, value);
    }

    public void putLong(long value) {
        Unsafe.putLong(this.object, this.offset, value);
    }

    public float getFloat() {
        return Unsafe.getFloat(this.object, this.offset);
    }

    public float getFloat(Object object) {
        return Unsafe.getFloat(object, this.offset);
    }

    public void putFloat(Object object, float value) {
        Unsafe.putFloat(object, this.offset, value);
    }

    public void putFloat(float value) {
        Unsafe.putFloat(this.object, this.offset, value);
    }

    public double getDouble() {
        return Unsafe.getDouble(this.object, this.offset);
    }

    public double getDouble(Object object) {
        return Unsafe.getDouble(object, this.offset);
    }

    public void putDouble(Object object, double value) {
        Unsafe.putDouble(object, this.offset, value);
    }

    public void putDouble(double value) {
        Unsafe.putDouble(this.object, this.offset, value);
    }

    public <T> T getVolatile() {
        return Unsafe.getObjectVolatile(this.object, this.offset);
    }

    public <T> T getVolatile(Object object) {
        return Unsafe.getObjectVolatile(object, this.offset);
    }

    public void putVolatile(Object object, Object value) {
        Unsafe.putObjectVolatile(object, this.offset, value);
    }

    public void putVolatile(Object value) {
        Unsafe.putObjectVolatile(this.object, this.offset, value);
    }

    public boolean getBooleanVolatile() {
        return Unsafe.getBooleanVolatile(this.object, this.offset);
    }

    public boolean getBooleanVolatile(Object object) {
        return Unsafe.getBooleanVolatile(object, this.offset);
    }

    public void putBooleanVolatile(Object object, boolean value) {
        Unsafe.putBooleanVolatile(object, this.offset, value);
    }

    public void putBooleanVolatile(boolean value) {
        Unsafe.putBooleanVolatile(this.object, this.offset, value);
    }

    public byte getByteVolatile() {
        return Unsafe.getByteVolatile(this.object, this.offset);
    }

    public byte getByteVolatile(Object object) {
        return Unsafe.getByteVolatile(object, this.offset);
    }

    public void putByteVolatile(Object object, byte value) {
        Unsafe.putByteVolatile(object, this.offset, value);
    }

    public void putByteVolatile(byte value) {
        Unsafe.putByteVolatile(this.object, this.offset, value);
    }

    public short getShortVolatile() {
        return Unsafe.getShortVolatile(this.object, this.offset);
    }

    public short getShortVolatile(Object object) {
        return Unsafe.getShortVolatile(object, this.offset);
    }

    public void putShortVolatile(Object object, short value) {
        Unsafe.putShortVolatile(object, this.offset, value);
    }

    public void putShortVolatile(short value) {
        Unsafe.putShortVolatile(this.object, this.offset, value);
    }

    public char getCharVolatile() {
        return Unsafe.getCharVolatile(this.object, this.offset);
    }

    public char getCharVolatile(Object object) {
        return Unsafe.getCharVolatile(object, this.offset);
    }

    public void putCharVolatile(Object object, char value) {
        Unsafe.putCharVolatile(object, this.offset, value);
    }

    public void putCharVolatile(char value) {
        Unsafe.putCharVolatile(this.object, this.offset, value);
    }

    public int getIntVolatile() {
        return Unsafe.getIntVolatile(this.object, this.offset);
    }

    public int getIntVolatile(Object object) {
        return Unsafe.getIntVolatile(object, this.offset);
    }

    public void putIntVolatile(Object object, int value) {
        Unsafe.putIntVolatile(object, this.offset, value);
    }

    public void putIntVolatile(int value) {
        Unsafe.putIntVolatile(this.object, this.offset, value);
    }

    public long getLongVolatile() {
        return Unsafe.getLongVolatile(this.object, this.offset);
    }

    public long getLongVolatile(Object object) {
        return Unsafe.getLongVolatile(object, this.offset);
    }

    public void putLongVolatile(Object object, long value) {
        Unsafe.putLongVolatile(object, this.offset, value);
    }

    public void putLongVolatile(long value) {
        Unsafe.putLongVolatile(this.object, this.offset, value);
    }

    public float getFloatVolatile() {
        return Unsafe.getFloatVolatile(this.object, this.offset);
    }

    public float getFloatVolatile(Object object) {
        return Unsafe.getFloatVolatile(object, this.offset);
    }

    public void putFloatVolatile(Object object, float value) {
        Unsafe.putFloatVolatile(object, this.offset, value);
    }

    public void putFloatVolatile(float value) {
        Unsafe.putFloatVolatile(this.object, this.offset, value);
    }

    public double getDoubleVolatile() {
        return Unsafe.getDoubleVolatile(this.object, this.offset);
    }

    public double getDoubleVolatile(Object object) {
        return Unsafe.getDoubleVolatile(object, this.offset);
    }

    public void putDoubleVolatile(Object object, double value) {
        Unsafe.putDoubleVolatile(object, this.offset, value);
    }

    public void putDoubleVolatile(double value) {
        Unsafe.putDoubleVolatile(this.object, this.offset, value);
    }
}
