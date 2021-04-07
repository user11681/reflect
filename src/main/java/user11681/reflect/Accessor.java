package user11681.reflect;

import java.lang.reflect.Field;
import net.gudenau.lib.unsafe.Unsafe;

public class Accessor {
    public static int getInt(Field field) {
        return Unsafe.getInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putInt(Field field, int value) {
        Unsafe.putInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getInt(Object object, String field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putInt(Object object, String field, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static int getInt(Object object, Field field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(field));
    }

    public static void putInt(Object object, Field field, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(field), value);
    }

    public static int getInt(Class<?> klass, Field field) {
        return Unsafe.getInt(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putInt(Class<?> klass, Field field, int value) {
        Unsafe.putInt(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static int getInt(Class<?> klass, String name) {
        return Unsafe.getInt(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putInt(Class<?> klass, String name, int value) {
        Unsafe.putInt(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static int getInt(Object object, Class<?> klass, String field) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putInt(Object object, Class<?> klass, String field, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static <T> T getObject(Field field) {
        return (T) Unsafe.getObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObject(Field field, Object value) {
        Unsafe.putObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObject(Object object, String field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putObject(Object object, String field, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static <T> T getObject(Object object, Field field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObject(Object object, Field field, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObject(Class<?> klass, Field field) {
        return (T) Unsafe.getObject(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putObject(Class<?> klass, Field field, Object value) {
        Unsafe.putObject(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObject(Class<?> klass, String name) {
        return (T) Unsafe.getObject(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putObject(Class<?> klass, String name, Object value) {
        Unsafe.putObject(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static <T> T getObject(Object object, Class<?> klass, String field) {
        return (T) Unsafe.getObject(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putObject(Object object, Class<?> klass, String field, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static boolean getBoolean(Field field) {
        return Unsafe.getBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBoolean(Field field, boolean value) {
        Unsafe.putBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBoolean(Object object, String field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putBoolean(Object object, String field, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static boolean getBoolean(Object object, Field field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBoolean(Object object, Field field, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBoolean(Class<?> klass, Field field) {
        return Unsafe.getBoolean(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putBoolean(Class<?> klass, Field field, boolean value) {
        Unsafe.putBoolean(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBoolean(Class<?> klass, String name) {
        return Unsafe.getBoolean(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putBoolean(Class<?> klass, String name, boolean value) {
        Unsafe.putBoolean(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static boolean getBoolean(Object object, Class<?> klass, String field) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putBoolean(Object object, Class<?> klass, String field, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static byte getByte(Field field) {
        return Unsafe.getByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByte(Field field, byte value) {
        Unsafe.putByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByte(Object object, String field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putByte(Object object, String field, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static byte getByte(Object object, Field field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByte(Object object, Field field, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByte(Class<?> klass, Field field) {
        return Unsafe.getByte(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putByte(Class<?> klass, Field field, byte value) {
        Unsafe.putByte(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByte(Class<?> klass, String name) {
        return Unsafe.getByte(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putByte(Class<?> klass, String name, byte value) {
        Unsafe.putByte(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static byte getByte(Object object, Class<?> klass, String field) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putByte(Object object, Class<?> klass, String field, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static short getShort(Field field) {
        return Unsafe.getShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShort(Field field, short value) {
        Unsafe.putShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShort(Object object, String field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putShort(Object object, String field, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static short getShort(Object object, Field field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShort(Object object, Field field, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShort(Class<?> klass, Field field) {
        return Unsafe.getShort(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putShort(Class<?> klass, Field field, short value) {
        Unsafe.putShort(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static short getShort(Class<?> klass, String name) {
        return Unsafe.getShort(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putShort(Class<?> klass, String name, short value) {
        Unsafe.putShort(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static short getShort(Object object, Class<?> klass, String field) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putShort(Object object, Class<?> klass, String field, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static char getChar(Object object, Field field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(field));
    }

    public static void putChar(Field field, char value) {
        Unsafe.putChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getChar(Object object, String field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putChar(Object object, String field, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static char getChar(Field field) {
        return Unsafe.getChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putChar(Object object, Field field, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getChar(Class<?> klass, Field field) {
        return Unsafe.getChar(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putChar(Class<?> klass, Field field, char value) {
        Unsafe.putChar(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static char getChar(Class<?> klass, String name) {
        return Unsafe.getChar(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putChar(Class<?> klass, String name, char value) {
        Unsafe.putChar(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static char getChar(Object object, Class<?> klass, String field) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putChar(Object object, Class<?> klass, String field, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static long getLong(Field field) {
        return Unsafe.getLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLong(Field field, long value) {
        Unsafe.putLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLong(Object object, String field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putLong(Object object, String field, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static long getLong(Object object, Field field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLong(Object object, Field field, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLong(Class<?> klass, Field field) {
        return Unsafe.getLong(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putLong(Class<?> klass, Field field, long value) {
        Unsafe.putLong(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static long getLong(Class<?> klass, String name) {
        return Unsafe.getLong(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putLong(Class<?> klass, String name, long value) {
        Unsafe.putLong(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static long getLong(Object object, Class<?> klass, String field) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putLong(Object object, Class<?> klass, String field, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static float getFloat(Field field) {
        return Unsafe.getFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloat(Field field, float value) {
        Unsafe.putFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloat(Object object, String field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putFloat(Object object, String field, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static float getFloat(Object object, Field field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloat(Object object, Field field, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloat(Class<?> klass, Field field) {
        return Unsafe.getFloat(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putFloat(Class<?> klass, Field field, float value) {
        Unsafe.putFloat(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloat(Class<?> klass, String name) {
        return Unsafe.getFloat(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putFloat(Class<?> klass, String name, float value) {
        Unsafe.putFloat(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static float getFloat(Object object, Class<?> klass, String field) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putFloat(Object object, Class<?> klass, String field, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static double getDouble(Field field) {
        return Unsafe.getDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDouble(Field field, double value) {
        Unsafe.putDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDouble(Object object, String field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putDouble(Object object, String field, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static double getDouble(Object object, Field field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDouble(Object object, Field field, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDouble(Class<?> klass, Field field) {
        return Unsafe.getDouble(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putDouble(Class<?> klass, Field field, double value) {
        Unsafe.putDouble(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static double getDouble(Class<?> klass, String name) {
        return Unsafe.getDouble(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putDouble(Class<?> klass, String name, double value) {
        Unsafe.putDouble(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static double getDouble(Object object, Class<?> klass, String field) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putDouble(Object object, Class<?> klass, String field, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static int getIntVolatile(Field field) {
        return Unsafe.getIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putIntVolatile(Field field, int value) {
        Unsafe.putIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getIntVolatile(Object object, String field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putIntVolatile(Object object, String field, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static int getIntVolatile(Object object, Field field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putIntVolatile(Object object, Field field, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static int getIntVolatile(Class<?> klass, Field field) {
        return Unsafe.getIntVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putIntVolatile(Class<?> klass, Field field, int value) {
        Unsafe.putIntVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static int getIntVolatile(Class<?> klass, String name) {
        return Unsafe.getIntVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putIntVolatile(Class<?> klass, String name, int value) {
        Unsafe.putIntVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static int getIntVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putIntVolatile(Object object, Class<?> klass, String field, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static <T> T getObjectVolatile(Field field) {
        return Unsafe.getObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObjectVolatile(Field field, Object value) {
        Unsafe.putObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(Object object, String field) {
        return Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putObjectVolatile(Object object, String field, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static <T> T getObjectVolatile(Object object, Field field) {
        return Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putObjectVolatile(Object object, Field field, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(Class<?> klass, Field field) {
        return Unsafe.getObjectVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putObjectVolatile(Class<?> klass, Field field, Object value) {
        Unsafe.putObjectVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static <T> T getObjectVolatile(Class<?> klass, String name) {
        return Unsafe.getObjectVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putObjectVolatile(Class<?> klass, String name, Object value) {
        Unsafe.putObjectVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static <T> T getObjectVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putObjectVolatile(Object object, Class<?> klass, String field, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static boolean getBooleanVolatile(Field field) {
        return Unsafe.getBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBooleanVolatile(Field field, boolean value) {
        Unsafe.putBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(Object object, String field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putBooleanVolatile(Object object, String field, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static boolean getBooleanVolatile(Object object, Field field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putBooleanVolatile(Object object, Field field, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(Class<?> klass, Field field) {
        return Unsafe.getBooleanVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putBooleanVolatile(Class<?> klass, Field field, boolean value) {
        Unsafe.putBooleanVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(Class<?> klass, String name) {
        return Unsafe.getBooleanVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putBooleanVolatile(Class<?> klass, String name, boolean value) {
        Unsafe.putBooleanVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static boolean getBooleanVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putBooleanVolatile(Object object, Class<?> klass, String field, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static byte getByteVolatile(Field field) {
        return Unsafe.getByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByteVolatile(Field field, byte value) {
        Unsafe.putByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByteVolatile(Object object, String field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putByteVolatile(Object object, String field, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static byte getByteVolatile(Object object, Field field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putByteVolatile(Object object, Field field, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static byte getByteVolatile(Class<?> klass, Field field) {
        return Unsafe.getByteVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putByteVolatile(Class<?> klass, Field field, byte value) {
        Unsafe.putByteVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByteVolatile(Class<?> klass, String name) {
        return Unsafe.getByteVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putByteVolatile(Class<?> klass, String name, byte value) {
        Unsafe.putByteVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static byte getByteVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putByteVolatile(Object object, Class<?> klass, String field, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static short getShortVolatile(Field field) {
        return Unsafe.getShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShortVolatile(Field field, short value) {
        Unsafe.putShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShortVolatile(Object object, String field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putShortVolatile(Object object, String field, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static short getShortVolatile(Object object, Field field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putShortVolatile(Object object, Field field, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static short getShortVolatile(Class<?> klass, Field field) {
        return Unsafe.getShortVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putShortVolatile(Class<?> klass, Field field, short value) {
        Unsafe.putShortVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static short getShortVolatile(Class<?> klass, String name) {
        return Unsafe.getShortVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putShortVolatile(Class<?> klass, String name, short value) {
        Unsafe.putShortVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static short getShortVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putShortVolatile(Object object, Class<?> klass, String field, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static char getCharVolatile(Field field) {
        return Unsafe.getCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putCharVolatile(Field field, char value) {
        Unsafe.putCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getCharVolatile(Object object, String field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putCharVolatile(Object object, String field, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static char getCharVolatile(Object object, Field field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putCharVolatile(Object object, Field field, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static char getCharVolatile(Class<?> klass, Field field) {
        return Unsafe.getCharVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putCharVolatile(Class<?> klass, Field field, char value) {
        Unsafe.putCharVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static char getCharVolatile(Class<?> klass, String name) {
        return Unsafe.getCharVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putCharVolatile(Class<?> klass, String name, char value) {
        Unsafe.putCharVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static char getCharVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putCharVolatile(Object object, Class<?> klass, String field, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static long getLongVolatile(Field field) {
        return Unsafe.getLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLongVolatile(Field field, long value) {
        Unsafe.putLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLongVolatile(Object object, String field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putLongVolatile(Object object, String field, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static long getLongVolatile(Object object, Field field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putLongVolatile(Object object, Field field, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static long getLongVolatile(Class<?> klass, Field field) {
        return Unsafe.getLongVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putLongVolatile(Class<?> klass, Field field, long value) {
        Unsafe.putLongVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static long getLongVolatile(Class<?> klass, String name) {
        return Unsafe.getLongVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putLongVolatile(Class<?> klass, String name, long value) {
        Unsafe.putLongVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static long getLongVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putLongVolatile(Object object, Class<?> klass, String field, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static float getFloatVolatile(Field field) {
        return Unsafe.getFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloatVolatile(Field field, float value) {
        Unsafe.putFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloatVolatile(Object object, String field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putFloatVolatile(Object object, String field, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static float getFloatVolatile(Object object, Field field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putFloatVolatile(Object object, Field field, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static float getFloatVolatile(Class<?> klass, Field field) {
        return Unsafe.getFloatVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putFloatVolatile(Class<?> klass, Field field, float value) {
        Unsafe.putFloatVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloatVolatile(Class<?> klass, String name) {
        return Unsafe.getFloatVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putFloatVolatile(Class<?> klass, String name, float value) {
        Unsafe.putFloatVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static float getFloatVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putFloatVolatile(Object object, Class<?> klass, String field, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static double getDoubleVolatile(Field field) {
        return Unsafe.getDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDoubleVolatile(Field field, double value) {
        Unsafe.putDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDoubleVolatile(Object object, String field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)));
    }

    public static void putDoubleVolatile(Object object, String field, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, field)), value);
    }

    public static double getDoubleVolatile(Object object, Field field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(field));
    }

    public static void putDoubleVolatile(Object object, Field field, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(field), value);
    }

    public static double getDoubleVolatile(Class<?> klass, Field field) {
        return Unsafe.getDoubleVolatile(klass, Unsafe.staticFieldOffset(field));
    }

    public static void putDoubleVolatile(Class<?> klass, Field field, double value) {
        Unsafe.putDoubleVolatile(klass, Unsafe.staticFieldOffset(field), value);
    }

    public static double getDoubleVolatile(Class<?> klass, String name) {
        return Unsafe.getDoubleVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)));
    }

    public static void putDoubleVolatile(Class<?> klass, String name, double value) {
        Unsafe.putDoubleVolatile(klass, Unsafe.staticFieldOffset(Fields.getField(klass, name)), value);
    }

    public static double getDoubleVolatile(Object object, Class<?> klass, String field) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));
    }

    public static void putDoubleVolatile(Object object, Class<?> klass, String field, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);
    }

    public static long objectFieldOffset(Class<?> klass, String field) {
        return Unsafe.objectFieldOffset(Fields.getField(klass, field));
    }

    public static <T> void copyInt(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyInt(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyInt(T to, T from, long offset) {
        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(Class<?> to, Class<?> from, long offset) {
        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyObject(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyObject(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyObject(T to, T from, long offset) {
        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(Class<?> to, Class<?> from, long offset) {
        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyBoolean(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyBoolean(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyBoolean(T to, T from, long offset) {
        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(Class<?> to, Class<?> from, long offset) {
        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyByte(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyByte(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyByte(T to, T from, long offset) {
        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(Class<?> to, Class<?> from, long offset) {
        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyShort(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyShort(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyShort(T to, T from, long offset) {
        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(Class<?> to, Class<?> from, long offset) {
        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyChar(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyChar(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyChar(T to, T from, long offset) {
        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(Class<?> to, Class<?> from, long offset) {
        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyLong(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyLong(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyLong(T to, T from, long offset) {
        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(Class<?> to, Class<?> from, long offset) {
        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyFloat(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyFloat(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyFloat(T to, T from, long offset) {
        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(Class<?> to, Class<?> from, long offset) {
        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyDouble(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyDouble(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyDouble(T to, T from, long offset) {
        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(Class<?> to, Class<?> from, long offset) {
        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyIntVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyIntVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyIntVolatile(T to, T from, long offset) {
        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(T to, T from, long offset) {
        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(T to, T from, long offset) {
        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(T to, T from, long offset) {
        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(T to, T from, long offset) {
        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(T to, T from, long offset) {
        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(T to, T from, long offset) {
        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(T to, T from, long offset) {
        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(T to, T from, String field) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, field));

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(T to, T from, long offset) {
        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(Class<?> to, Class<?> from, String field) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, field));

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }
/*

    public static <T> void copy(T to, T from) {
        for (Field field : Fields.getInstanceFields(to.getClass())) {
            if ((field.getModifiers() & Modifier.VOLATILE) == 0) {
                copyObject(to, from, field);
            } else {
                copyObjectVolatile(to, from, field);
            }
        }
    }
*/
}
