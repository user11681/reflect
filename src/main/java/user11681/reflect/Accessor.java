package user11681.reflect;

import java.lang.reflect.Field;
import net.gudenau.lib.unsafe.Unsafe;

public class Accessor {
    public static int getInt(final Field field) {
        return Unsafe.getInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putInt(final Field field, final int value) {
        Unsafe.putInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getInt(final Object object, final String field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putInt(final Object object, final String field, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static int getInt(final Object object, final Field field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(field));
    }

    public static void putInt(final Object object, final Field field, final int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(field), value);
    }

    public static int getInt(final Class<?> klass, final Field field) {
        return Unsafe.getInt(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putInt(final Class<?> klass, final Field field, final int value) {
        Unsafe.putInt(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static int getInt(final Class<?> klass, final String name) {
        return Unsafe.getInt(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putInt(final Class<?> klass, final String name, final int value) {
        Unsafe.putInt(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static int getInt(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putInt(final Object object, final Class<?> klass, final String field, final int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static <T> T getObject(final Field field) {
        return (T) Unsafe.getObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObject(final Field field, final Object value) {
        Unsafe.putObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObject(final Object object, final String field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putObject(final Object object, final String field, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static <T> T getObject(final Object object, final Field field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObject(final Object object, final Field field, final Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObject(final Class<?> klass, final Field field) {
        return (T) Unsafe.getObject(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putObject(final Class<?> klass, final Field field, final Object value) {
        Unsafe.putObject(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObject(final Class<?> klass, final String name) {
        return (T) Unsafe.getObject(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putObject(final Class<?> klass, final String name, final Object value) {
        Unsafe.putObject(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static <T> T getObject(final Object object, final Class<?> klass, final String field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putObject(final Object object, final Class<?> klass, final String field, final Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static boolean getBoolean(final Field field) {
        return Unsafe.getBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBoolean(final Field field, final boolean value) {
        Unsafe.putBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBoolean(final Object object, final String field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putBoolean(final Object object, final String field, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static boolean getBoolean(final Object object, final Field field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBoolean(final Object object, final Field field, final boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBoolean(final Class<?> klass, final Field field) {
        return Unsafe.getBoolean(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putBoolean(final Class<?> klass, final Field field, final boolean value) {
        Unsafe.putBoolean(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBoolean(final Class<?> klass, final String name) {
        return Unsafe.getBoolean(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putBoolean(final Class<?> klass, final String name, final boolean value) {
        Unsafe.putBoolean(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static boolean getBoolean(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putBoolean(final Object object, final Class<?> klass, final String field, final boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static byte getByte(final Field field) {
        return Unsafe.getByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByte(final Field field, final byte value) {
        Unsafe.putByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByte(final Object object, final String field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putByte(final Object object, final String field, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static byte getByte(final Object object, final Field field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByte(final Object object, final Field field, final byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByte(final Class<?> klass, final Field field) {
        return Unsafe.getByte(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putByte(final Class<?> klass, final Field field, final byte value) {
        Unsafe.putByte(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByte(final Class<?> klass, final String name) {
        return Unsafe.getByte(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putByte(final Class<?> klass, final String name, final byte value) {
        Unsafe.putByte(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static byte getByte(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putByte(final Object object, final Class<?> klass, final String field, final byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static short getShort(final Field field) {
        return Unsafe.getShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShort(final Field field, final short value) {
        Unsafe.putShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShort(final Object object, final String field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putShort(final Object object, final String field, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static short getShort(final Object object, final Field field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShort(final Object object, final Field field, final short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShort(final Class<?> klass, final Field field) {
        return Unsafe.getShort(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putShort(final Class<?> klass, final Field field, final short value) {
        Unsafe.putShort(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static short getShort(final Class<?> klass, final String name) {
        return Unsafe.getShort(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putShort(final Class<?> klass, final String name, final short value) {
        Unsafe.putShort(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static short getShort(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putShort(final Object object, final Class<?> klass, final String field, final short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static char getChar(final Object object, final Field field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(field));
    }

    public static void putChar(final Field field, final char value) {
        Unsafe.putChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getChar(final Object object, final String field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putChar(final Object object, final String field, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static char getChar(final Field field) {
        return Unsafe.getChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putChar(final Object object, final Field field, final char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getChar(final Class<?> klass, final Field field) {
        return Unsafe.getChar(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putChar(final Class<?> klass, final Field field, final char value) {
        Unsafe.putChar(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static char getChar(final Class<?> klass, final String name) {
        return Unsafe.getChar(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putChar(final Class<?> klass, final String name, final char value) {
        Unsafe.putChar(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static char getChar(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putChar(final Object object, final Class<?> klass, final String field, final char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static long getLong(final Field field) {
        return Unsafe.getLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLong(final Field field, final long value) {
        Unsafe.putLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLong(final Object object, final String field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putLong(final Object object, final String field, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static long getLong(final Object object, final Field field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLong(final Object object, final Field field, final long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLong(final Class<?> klass, final Field field) {
        return Unsafe.getLong(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putLong(final Class<?> klass, final Field field, final long value) {
        Unsafe.putLong(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static long getLong(final Class<?> klass, final String name) {
        return Unsafe.getLong(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putLong(final Class<?> klass, final String name, final long value) {
        Unsafe.putLong(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static long getLong(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putLong(final Object object, final Class<?> klass, final String field, final long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static float getFloat(final Field field) {
        return Unsafe.getFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloat(final Field field, final float value) {
        Unsafe.putFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloat(final Object object, final String field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putFloat(final Object object, final String field, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static float getFloat(final Object object, final Field field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloat(final Object object, final Field field, final float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloat(final Class<?> klass, final Field field) {
        return Unsafe.getFloat(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putFloat(final Class<?> klass, final Field field, final float value) {
        Unsafe.putFloat(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloat(final Class<?> klass, final String name) {
        return Unsafe.getFloat(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putFloat(final Class<?> klass, final String name, final float value) {
        Unsafe.putFloat(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static float getFloat(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putFloat(final Object object, final Class<?> klass, final String field, final float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static double getDouble(final Field field) {
        return Unsafe.getDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDouble(final Field field, final double value) {
        Unsafe.putDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDouble(final Object object, final String field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putDouble(final Object object, final String field, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static double getDouble(final Object object, final Field field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDouble(final Object object, final Field field, final double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDouble(final Class<?> klass, final Field field) {
        return Unsafe.getDouble(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putDouble(final Class<?> klass, final Field field, final double value) {
        Unsafe.putDouble(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static double getDouble(final Class<?> klass, final String name) {
        return Unsafe.getDouble(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putDouble(final Class<?> klass, final String name, final double value) {
        Unsafe.putDouble(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static double getDouble(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putDouble(final Object object, final Class<?> klass, final String field, final double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static int getIntVolatile(final Field field) {
        return Unsafe.getIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putIntVolatile(final Field field, final int value) {
        Unsafe.putIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getIntVolatile(final Object object, final String field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putIntVolatile(final Object object, final String field, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static int getIntVolatile(final Object object, final Field field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putIntVolatile(final Object object, final Field field, final int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static int getIntVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getIntVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putIntVolatile(final Class<?> klass, final Field field, final int value) {
        Unsafe.putIntVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static int getIntVolatile(final Class<?> klass, final String name) {
        return Unsafe.getIntVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putIntVolatile(final Class<?> klass, final String name, final int value) {
        Unsafe.putIntVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static int getIntVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putIntVolatile(final Object object, final Class<?> klass, final String field, final int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static <T> T getObjectVolatile(final Field field) {
        return (T) Unsafe.getObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObjectVolatile(final Field field, final Object value) {
        Unsafe.putObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(final Object object, final String field) {
        return (T) Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putObjectVolatile(final Object object, final String field, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static <T> T getObjectVolatile(final Object object, final Field field) {
        return (T) Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObjectVolatile(final Object object, final Field field, final Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(final Class<?> klass, final Field field) {
        return (T) Unsafe.getObjectVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putObjectVolatile(final Class<?> klass, final Field field, final Object value) {
        Unsafe.putObjectVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(final Class<?> klass, final String name) {
        return (T) Unsafe.getObjectVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putObjectVolatile(final Class<?> klass, final String name, final Object value) {
        Unsafe.putObjectVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static <T> T getObjectVolatile(final Object object, final Class<?> klass, final String field) {
        return (T) Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putObjectVolatile(final Object object, final Class<?> klass, final String field, final Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static boolean getBooleanVolatile(final Field field) {
        return Unsafe.getBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBooleanVolatile(final Field field, final boolean value) {
        Unsafe.putBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(final Object object, final String field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putBooleanVolatile(final Object object, final String field, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static boolean getBooleanVolatile(final Object object, final Field field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBooleanVolatile(final Object object, final Field field, final boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getBooleanVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putBooleanVolatile(final Class<?> klass, final Field field, final boolean value) {
        Unsafe.putBooleanVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(final Class<?> klass, final String name) {
        return Unsafe.getBooleanVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putBooleanVolatile(final Class<?> klass, final String name, final boolean value) {
        Unsafe.putBooleanVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static boolean getBooleanVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putBooleanVolatile(final Object object, final Class<?> klass, final String field, final boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static byte getByteVolatile(final Field field) {
        return Unsafe.getByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByteVolatile(final Field field, final byte value) {
        Unsafe.putByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByteVolatile(final Object object, final String field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putByteVolatile(final Object object, final String field, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static byte getByteVolatile(final Object object, final Field field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByteVolatile(final Object object, final Field field, final byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByteVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getByteVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putByteVolatile(final Class<?> klass, final Field field, final byte value) {
        Unsafe.putByteVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByteVolatile(final Class<?> klass, final String name) {
        return Unsafe.getByteVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putByteVolatile(final Class<?> klass, final String name, final byte value) {
        Unsafe.putByteVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static byte getByteVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putByteVolatile(final Object object, final Class<?> klass, final String field, final byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static short getShortVolatile(final Field field) {
        return Unsafe.getShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShortVolatile(final Field field, final short value) {
        Unsafe.putShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShortVolatile(final Object object, final String field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putShortVolatile(final Object object, final String field, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static short getShortVolatile(final Object object, final Field field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShortVolatile(final Object object, final Field field, final short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShortVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getShortVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putShortVolatile(final Class<?> klass, final Field field, final short value) {
        Unsafe.putShortVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static short getShortVolatile(final Class<?> klass, final String name) {
        return Unsafe.getShortVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putShortVolatile(final Class<?> klass, final String name, final short value) {
        Unsafe.putShortVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static short getShortVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putShortVolatile(final Object object, final Class<?> klass, final String field, final short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static char getCharVolatile(final Field field) {
        return Unsafe.getCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putCharVolatile(final Field field, final char value) {
        Unsafe.putCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getCharVolatile(final Object object, final String field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putCharVolatile(final Object object, final String field, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static char getCharVolatile(final Object object, final Field field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putCharVolatile(final Object object, final Field field, final char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getCharVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getCharVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putCharVolatile(final Class<?> klass, final Field field, final char value) {
        Unsafe.putCharVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static char getCharVolatile(final Class<?> klass, final String name) {
        return Unsafe.getCharVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putCharVolatile(final Class<?> klass, final String name, final char value) {
        Unsafe.putCharVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static char getCharVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putCharVolatile(final Object object, final Class<?> klass, final String field, final char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static long getLongVolatile(final Field field) {
        return Unsafe.getLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLongVolatile(final Field field, final long value) {
        Unsafe.putLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLongVolatile(final Object object, final String field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putLongVolatile(final Object object, final String field, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static long getLongVolatile(final Object object, final Field field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLongVolatile(final Object object, final Field field, final long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLongVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getLongVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putLongVolatile(final Class<?> klass, final Field field, final long value) {
        Unsafe.putLongVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static long getLongVolatile(final Class<?> klass, final String name) {
        return Unsafe.getLongVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putLongVolatile(final Class<?> klass, final String name, final long value) {
        Unsafe.putLongVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static long getLongVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putLongVolatile(final Object object, final Class<?> klass, final String field, final long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static float getFloatVolatile(final Field field) {
        return Unsafe.getFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloatVolatile(final Field field, final float value) {
        Unsafe.putFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloatVolatile(final Object object, final String field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putFloatVolatile(final Object object, final String field, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static float getFloatVolatile(final Object object, final Field field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloatVolatile(final Object object, final Field field, final float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloatVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getFloatVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putFloatVolatile(final Class<?> klass, final Field field, final float value) {
        Unsafe.putFloatVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloatVolatile(final Class<?> klass, final String name) {
        return Unsafe.getFloatVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putFloatVolatile(final Class<?> klass, final String name, final float value) {
        Unsafe.putFloatVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static float getFloatVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putFloatVolatile(final Object object, final Class<?> klass, final String field, final float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static double getDoubleVolatile(final Field field) {
        return Unsafe.getDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDoubleVolatile(final Field field, final double value) {
        Unsafe.putDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDoubleVolatile(final Object object, final String field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putDoubleVolatile(final Object object, final String field, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static double getDoubleVolatile(final Object object, final Field field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDoubleVolatile(final Object object, final Field field, final double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDoubleVolatile(final Class<?> klass, final Field field) {
        return Unsafe.getDoubleVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putDoubleVolatile(final Class<?> klass, final Field field, final double value) {
        Unsafe.putDoubleVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static double getDoubleVolatile(final Class<?> klass, final String name) {
        return Unsafe.getDoubleVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putDoubleVolatile(final Class<?> klass, final String name, final double value) {
        Unsafe.putDoubleVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static double getDoubleVolatile(final Object object, final Class<?> klass, final String field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putDoubleVolatile(final Object object, final Class<?> klass, final String field, final double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static long objectFieldOffset(final Class<?> klass, final String field) {
        return Unsafe.objectFieldOffset(Fields.getField(klass, field));
    }

    public static <T> void copyInt(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyInt(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyInt(final T to, final T from, final long offset) {
        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyObject(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyObject(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyObject(final T to, final T from, final long offset) {
        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyBoolean(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyBoolean(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyBoolean(final T to, final T from, final long offset) {
        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyByte(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyByte(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyByte(final T to, final T from, final long offset) {
        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyShort(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyShort(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyShort(final T to, final T from, final long offset) {
        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyChar(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyChar(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyChar(final T to, final T from, final long offset) {
        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyLong(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyLong(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyLong(final T to, final T from, final long offset) {
        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyFloat(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyFloat(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyFloat(final T to, final T from, final long offset) {
        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyDouble(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyDouble(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyDouble(final T to, final T from, final long offset) {
        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyIntVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyIntVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyIntVolatile(final T to, final T from, final long offset) {
        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(final T to, final T from, final long offset) {
        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(final T to, final T from, final long offset) {
        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(final T to, final T from, final long offset) {
        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(final T to, final T from, final long offset) {
        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(final T to, final T from, final long offset) {
        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(final T to, final T from, final long offset) {
        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(final T to, final T from, final long offset) {
        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(final T to, final T from, final String field) {
        final long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(final T to, final T from, final Field field) {
        final long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(final T to, final T from, final long offset) {
        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(final Class<?> to, final Class<?> from, final String field) {
        final long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(final Class<?> to, final Class<?> from, final Field field) {
        final long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(final Class<?> to, final Class<?> from, final long offset) {
        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }
/*

    public static <T> void copy(final T to, final T from) {
        for (final Field field : Fields.getInstanceFields(to.getClass())) {
            if ((field.getModifiers() & Modifier.VOLATILE) == 0) {
                copyObject(to, from, field);
            } else {
                copyObjectVolatile(to, from, field);
            }
        }
    }
*/

    public static long addressOf(final long pointer) {
        return pointer & 0xFFFFFFFFL;
    }

    static {
        Reflect.disableSecurity();
    }
}
