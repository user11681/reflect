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

    public static int getInt(final Object object, final Field field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(field));
    }

    public static void putInt(final Object object, final Field field, final int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObject(final Field field) {
        return (T) Unsafe.getObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObject(final Field field, final Object value) {
        Unsafe.putObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObject(final Object object, final Field field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObject(final Object object, final Field field, final Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBoolean(final Field field) {
        return Unsafe.getBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBoolean(final Field field, final boolean value) {
        Unsafe.putBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBoolean(final Object object, final Field field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBoolean(final Object object, final Field field, final boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByte(final Field field) {
        return Unsafe.getByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByte(final Field field, final byte value) {
        Unsafe.putByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByte(final Object object, final Field field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByte(final Object object, final Field field, final byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShort(final Field field) {
        return Unsafe.getShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShort(final Field field, final short value) {
        Unsafe.putShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShort(final Object object, final Field field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShort(final Object object, final Field field, final short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getChar(final Object object, final Field field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(field));
    }

    public static void putChar(final Field field, final char value) {
        Unsafe.putChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getChar(final Field field) {
        return Unsafe.getChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putChar(final Object object, final Field field, final char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLong(final Field field) {
        return Unsafe.getLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLong(final Field field, final long value) {
        Unsafe.putLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLong(final Object object, final Field field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLong(final Object object, final Field field, final long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloat(final Field field) {
        return Unsafe.getFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloat(final Field field, final float value) {
        Unsafe.putFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloat(final Object object, final Field field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloat(final Object object, final Field field, final float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDouble(final Field field) {
        return Unsafe.getDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDouble(final Field field, final double value) {
        Unsafe.putDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDouble(final Object object, final Field field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDouble(final Object object, final Field field, final double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(field), value);
    }

    public static int getIntVolatile(final Field field) {
        return Unsafe.getIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putIntVolatile(final Field field, final int value) {
        Unsafe.putIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getIntVolatile(final Object object, final Field field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putIntVolatile(final Object object, final Field field, final int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(final Field field) {
        return (T) Unsafe.getObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObjectVolatile(final Field field, final Object value) {
        Unsafe.putObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(final Object object, final Field field) {
        return (T) Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObjectVolatile(final Object object, final Field field, final Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(final Field field) {
        return Unsafe.getBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBooleanVolatile(final Field field, final boolean value) {
        Unsafe.putBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(final Object object, final Field field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBooleanVolatile(final Object object, final Field field, final boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByteVolatile(final Field field) {
        return Unsafe.getByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByteVolatile(final Field field, final byte value) {
        Unsafe.putByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByteVolatile(final Object object, final Field field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByteVolatile(final Object object, final Field field, final byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShortVolatile(final Field field) {
        return Unsafe.getShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShortVolatile(final Field field, final short value) {
        Unsafe.putShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShortVolatile(final Object object, final Field field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShortVolatile(final Object object, final Field field, final short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getCharVolatile(final Field field) {
        return Unsafe.getCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putCharVolatile(final Field field, final char value) {
        Unsafe.putCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getCharVolatile(final Object object, final Field field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putCharVolatile(final Object object, final Field field, final char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLongVolatile(final Field field) {
        return Unsafe.getLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLongVolatile(final Field field, final long value) {
        Unsafe.putLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLongVolatile(final Object object, final Field field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLongVolatile(final Object object, final Field field, final long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloatVolatile(final Field field) {
        return Unsafe.getFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloatVolatile(final Field field, final float value) {
        Unsafe.putFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloatVolatile(final Object object, final Field field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloatVolatile(final Object object, final Field field, final float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDoubleVolatile(final Field field) {
        return Unsafe.getDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDoubleVolatile(final Field field, final double value) {
        Unsafe.putDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDoubleVolatile(final Object object, final Field field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDoubleVolatile(final Object object, final Field field, final double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(field), value);
    }
}
