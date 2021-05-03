package user11681.reflect;

import java.lang.reflect.Field;
import net.gudenau.lib.unsafe.Unsafe;

public class Accessor {
    public static long staticFieldOffset(Class<?> type, String name) {
        return Unsafe.staticFieldOffset(Fields.getField(type, name));
    }

    public static long objectFieldOffset(Class<?> type, String name) {
        return Unsafe.objectFieldOffset(Fields.getField(type, name));
    }

    public static boolean getBoolean(Field field) {
        return Unsafe.getBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBoolean(Field field, boolean value) {
        Unsafe.putBoolean(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByte(Field field) {
        return Unsafe.getByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByte(Field field, byte value) {
        Unsafe.putByte(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getChar(Field field) {
        return Unsafe.getChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putChar(Field field, char value) {
        Unsafe.putChar(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShort(Field field) {
        return Unsafe.getShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShort(Field field, short value) {
        Unsafe.putShort(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getInt(Field field) {
        return Unsafe.getInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putInt(Field field, int value) {
        Unsafe.putInt(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLong(Field field) {
        return Unsafe.getLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLong(Field field, long value) {
        Unsafe.putLong(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloat(Field field) {
        return Unsafe.getFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloat(Field field, float value) {
        Unsafe.putFloat(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDouble(Field field) {
        return Unsafe.getDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDouble(Field field, double value) {
        Unsafe.putDouble(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static Object getObject(Field field) {
        return Unsafe.getObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObject(Field field, Object value) {
        Unsafe.putObject(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static Object get(Field field) {
        return get(field.getDeclaringClass(), field.getType(), Unsafe.staticFieldOffset(field));
    }

    public static void put(Field field, Object value) {
        put(field.getDeclaringClass(), field.getType(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(Field field) {
        return Unsafe.getBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putBooleanVolatile(Field field, boolean value) {
        Unsafe.putBooleanVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static byte getByteVolatile(Field field) {
        return Unsafe.getByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putByteVolatile(Field field, byte value) {
        Unsafe.putByteVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static char getCharVolatile(Field field) {
        return Unsafe.getCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putCharVolatile(Field field, char value) {
        Unsafe.putCharVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static short getShortVolatile(Field field) {
        return Unsafe.getShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putShortVolatile(Field field, short value) {
        Unsafe.putShortVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static int getIntVolatile(Field field) {
        return Unsafe.getIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putIntVolatile(Field field, int value) {
        Unsafe.putIntVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static long getLongVolatile(Field field) {
        return Unsafe.getLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putLongVolatile(Field field, long value) {
        Unsafe.putLongVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static float getFloatVolatile(Field field) {
        return Unsafe.getFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putFloatVolatile(Field field, float value) {
        Unsafe.putFloatVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static double getDoubleVolatile(Field field) {
        return Unsafe.getDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putDoubleVolatile(Field field, double value) {
        Unsafe.putDoubleVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static Object getObjectVolatile(Field field) {
        return Unsafe.getObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field));
    }

    public static void putObjectVolatile(Field field, Object value) {
        Unsafe.putObjectVolatile(field.getDeclaringClass(), Unsafe.staticFieldOffset(field), value);
    }

    public static Object getVolatile(Field field) {
        return get(field.getDeclaringClass(), field.getType(), Unsafe.staticFieldOffset(field));
    }

    public static void putVolatile(Field field, Object value) {
        put(field.getDeclaringClass(), field.getType(), Unsafe.staticFieldOffset(field), value);
    }

    public static <T> void copyBoolean(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyBoolean(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyBoolean(T to, T from, long offset) {
        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static void copyBoolean(Class<?> to, Class<?> from, long offset) {
        Unsafe.putBoolean(to, offset, Unsafe.getBoolean(from, offset));
    }

    public static <T> void copyByte(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyByte(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyByte(T to, T from, long offset) {
        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static void copyByte(Class<?> to, Class<?> from, long offset) {
        Unsafe.putByte(to, offset, Unsafe.getByte(from, offset));
    }

    public static <T> void copyChar(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyChar(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyChar(T to, T from, long offset) {
        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static void copyChar(Class<?> to, Class<?> from, long offset) {
        Unsafe.putChar(to, offset, Unsafe.getChar(from, offset));
    }

    public static <T> void copyShort(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyShort(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyShort(T to, T from, long offset) {
        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static void copyShort(Class<?> to, Class<?> from, long offset) {
        Unsafe.putShort(to, offset, Unsafe.getShort(from, offset));
    }

    public static <T> void copyInt(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyInt(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyInt(T to, T from, long offset) {
        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static void copyInt(Class<?> to, Class<?> from, long offset) {
        Unsafe.putInt(to, offset, Unsafe.getInt(from, offset));
    }

    public static <T> void copyLong(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyLong(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyLong(T to, T from, long offset) {
        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static void copyLong(Class<?> to, Class<?> from, long offset) {
        Unsafe.putLong(to, offset, Unsafe.getLong(from, offset));
    }

    public static <T> void copyFloat(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyFloat(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyFloat(T to, T from, long offset) {
        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static void copyFloat(Class<?> to, Class<?> from, long offset) {
        Unsafe.putFloat(to, offset, Unsafe.getFloat(from, offset));
    }

    public static <T> void copyDouble(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyDouble(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyDouble(T to, T from, long offset) {
        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static void copyDouble(Class<?> to, Class<?> from, long offset) {
        Unsafe.putDouble(to, offset, Unsafe.getDouble(from, offset));
    }

    public static <T> void copyObject(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyObject(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copyObject(T to, T from, long offset) {
        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static void copyObject(Class<?> to, Class<?> from, long offset) {
        Unsafe.putObject(to, offset, Unsafe.getObject(from, offset));
    }

    public static <T> void copy(T to, T from, String fieldName) {
        Field field = Fields.getField(to, fieldName);
        long offset = Unsafe.objectFieldOffset(field);

        put(to, field.getType(), offset, get(from, field.getType(), offset));
    }

    public static <T> void copy(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        put(to, field.getType(), offset, get(from, field.getType(), offset));
    }

    public static void copy(Class<?> to, Class<?> from, String fieldName) {
        Field field = Fields.getField(to, fieldName);
        long offset = Unsafe.staticFieldOffset(field);

        put(to, field.getType(), offset, get(from, field.getType(), offset));
    }

    public static void copy(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        put(to, field.getType(), offset, get(from, field.getType(), offset));
    }

    public static <T> void copyBooleanVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyBooleanVolatile(T to, T from, long offset) {
        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static void copyBooleanVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putBooleanVolatile(to, offset, Unsafe.getBooleanVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyByteVolatile(T to, T from, long offset) {
        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static void copyByteVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putByteVolatile(to, offset, Unsafe.getByteVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyCharVolatile(T to, T from, long offset) {
        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static void copyCharVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putCharVolatile(to, offset, Unsafe.getCharVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyShortVolatile(T to, T from, long offset) {
        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static void copyShortVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putShortVolatile(to, offset, Unsafe.getShortVolatile(from, offset));
    }

    public static <T> void copyIntVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyIntVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyIntVolatile(T to, T from, long offset) {
        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static void copyIntVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putIntVolatile(to, offset, Unsafe.getIntVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyLongVolatile(T to, T from, long offset) {
        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static void copyLongVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putLongVolatile(to, offset, Unsafe.getLongVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyFloatVolatile(T to, T from, long offset) {
        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static void copyFloatVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putFloatVolatile(to, offset, Unsafe.getFloatVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static <T> void copyDoubleVolatile(T to, T from, long offset) {
        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static void copyDoubleVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putDoubleVolatile(to, offset, Unsafe.getDoubleVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(T to, T from, String fieldName) {
        long offset = Unsafe.objectFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyObjectVolatile(T to, T from, long offset) {
        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(Class<?> to, Class<?> from, String fieldName) {
        long offset = Unsafe.staticFieldOffset(Fields.getField(to, fieldName));

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static void copyObjectVolatile(Class<?> to, Class<?> from, long offset) {
        Unsafe.putObjectVolatile(to, offset, Unsafe.getObjectVolatile(from, offset));
    }

    public static <T> void copyVolatile(T to, T from, String fieldName) {
        Field field = Fields.getField(to, fieldName);
        long offset = Unsafe.objectFieldOffset(field);

        putVolatile(to, field.getType(), offset, getVolatile(from, field.getType(), offset));
    }

    public static <T> void copyVolatile(T to, T from, Field field) {
        long offset = Unsafe.objectFieldOffset(field);

        putVolatile(to, field.getType(), offset, getVolatile(from, field.getType(), offset));
    }

    public static void copyVolatile(Class<?> to, Class<?> from, String fieldName) {
        Field field = Fields.getField(to, fieldName);
        long offset = Unsafe.staticFieldOffset(field);

        putVolatile(to, field.getType(), offset, getVolatile(from, field.getType(), offset));
    }

    public static void copyVolatile(Class<?> to, Class<?> from, Field field) {
        long offset = Unsafe.staticFieldOffset(field);

        putVolatile(to, field.getType(), offset, getVolatile(from, field.getType(), offset));
    }

    public static boolean getBoolean(Object object, Field fieldName) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putBoolean(Object object, Field fieldName, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static boolean getBoolean(Object object, String fieldName) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putBoolean(Object object, String fieldName, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static boolean getBoolean(Class<?> type, String fieldName) {
        return Unsafe.getBoolean(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putBoolean(Class<?> type, String fieldName, boolean value) {
        Unsafe.putBoolean(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static byte getByte(Object object, Field fieldName) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putByte(Object object, Field fieldName, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static byte getByte(Object object, String fieldName) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putByte(Object object, String fieldName, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static byte getByte(Class<?> type, String fieldName) {
        return Unsafe.getByte(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putByte(Class<?> type, String fieldName, byte value) {
        Unsafe.putByte(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static char getChar(Object object, Field fieldName) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putChar(Object object, Field fieldName, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static char getChar(Object object, String fieldName) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putChar(Object object, String fieldName, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static char getChar(Class<?> type, String fieldName) {
        return Unsafe.getChar(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putChar(Class<?> type, String fieldName, char value) {
        Unsafe.putChar(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static short getShort(Object object, Field fieldName) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putShort(Object object, Field fieldName, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static short getShort(Object object, String fieldName) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putShort(Object object, String fieldName, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static short getShort(Class<?> type, String fieldName) {
        return Unsafe.getShort(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putShort(Class<?> type, String fieldName, short value) {
        Unsafe.putShort(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static int getInt(Object object, Field fieldName) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putInt(Object object, Field fieldName, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static int getInt(Object object, String fieldName) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putInt(Object object, String fieldName, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static int getInt(Class<?> type, String fieldName) {
        return Unsafe.getInt(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putInt(Class<?> type, String fieldName, int value) {
        Unsafe.putInt(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static long getLong(Object object, Field fieldName) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putLong(Object object, Field fieldName, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static long getLong(Object object, String fieldName) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putLong(Object object, String fieldName, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static long getLong(Class<?> type, String fieldName) {
        return Unsafe.getLong(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putLong(Class<?> type, String fieldName, long value) {
        Unsafe.putLong(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static float getFloat(Object object, Field fieldName) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putFloat(Object object, Field fieldName, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static float getFloat(Object object, String fieldName) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putFloat(Object object, String fieldName, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static float getFloat(Class<?> type, String fieldName) {
        return Unsafe.getFloat(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putFloat(Class<?> type, String fieldName, float value) {
        Unsafe.putFloat(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static double getDouble(Object object, Field fieldName) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putDouble(Object object, Field fieldName, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static double getDouble(Object object, String fieldName) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putDouble(Object object, String fieldName, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static double getDouble(Class<?> type, String fieldName) {
        return Unsafe.getDouble(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putDouble(Class<?> type, String fieldName, double value) {
        Unsafe.putDouble(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static <T> T getObject(Object object, Field fieldName) {
        return Unsafe.getObject(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putObject(Object object, Field fieldName, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static <T> T getObject(Object object, String fieldName) {
        return Unsafe.getObject(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putObject(Object object, String fieldName, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static <T> T getObject(Class<?> type, String fieldName) {
        return Unsafe.getObject(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putObject(Class<?> type, String fieldName, Object value) {
        Unsafe.putObject(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static Object get(Object object, Field fieldName) {
        return get(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName));
    }

    public static void put(Object object, Field fieldName, Object value) {
        put(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName), value);
    }

    public static Object get(Object object, String fieldName) {
        Field field = Fields.getField(object, fieldName);

        return get(object, field.getType(), Unsafe.objectFieldOffset(field));
    }

    public static void put(Object object, String fieldName, Object value) {
        Field field = Fields.getField(object, fieldName);

        put(object, field.getType(), Unsafe.objectFieldOffset(field), value);
    }

    public static Object get(Class<?> type, String fieldName) {
        Field field = Fields.getField(type, fieldName);

        return get(type, field.getType(), Unsafe.staticFieldOffset(field));
    }

    public static void put(Class<?> type, String fieldName, Object value) {
        Field field = Fields.getField(type, fieldName);

        put(type, field.getType(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(Object object, Field fieldName) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putBooleanVolatile(Object object, Field fieldName, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static boolean getBooleanVolatile(Object object, String fieldName) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putBooleanVolatile(Object object, String fieldName, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static boolean getBooleanVolatile(Class<?> type, String fieldName) {
        return Unsafe.getBooleanVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putBooleanVolatile(Class<?> type, String fieldName, boolean value) {
        Unsafe.putBooleanVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static byte getByteVolatile(Object object, Field fieldName) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putByteVolatile(Object object, Field fieldName, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static byte getByteVolatile(Object object, String fieldName) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putByteVolatile(Object object, String fieldName, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static byte getByteVolatile(Class<?> type, String fieldName) {
        return Unsafe.getByteVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putByteVolatile(Class<?> type, String fieldName, byte value) {
        Unsafe.putByteVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static char getCharVolatile(Object object, Field fieldName) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putCharVolatile(Object object, Field fieldName, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static char getCharVolatile(Object object, String fieldName) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putCharVolatile(Object object, String fieldName, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static char getCharVolatile(Class<?> type, String fieldName) {
        return Unsafe.getCharVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putCharVolatile(Class<?> type, String fieldName, char value) {
        Unsafe.putCharVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static short getShortVolatile(Object object, Field fieldName) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putShortVolatile(Object object, Field fieldName, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static short getShortVolatile(Object object, String fieldName) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putShortVolatile(Object object, String fieldName, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static short getShortVolatile(Class<?> type, String fieldName) {
        return Unsafe.getShortVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putShortVolatile(Class<?> type, String fieldName, short value) {
        Unsafe.putShortVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static int getIntVolatile(Object object, Field fieldName) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putIntVolatile(Object object, Field fieldName, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static int getIntVolatile(Object object, String fieldName) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putIntVolatile(Object object, String fieldName, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static int getIntVolatile(Class<?> type, String fieldName) {
        return Unsafe.getIntVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putIntVolatile(Class<?> type, String fieldName, int value) {
        Unsafe.putIntVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static long getLongVolatile(Object object, Field fieldName) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putLongVolatile(Object object, Field fieldName, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static long getLongVolatile(Object object, String fieldName) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putLongVolatile(Object object, String fieldName, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static long getLongVolatile(Class<?> type, String fieldName) {
        return Unsafe.getLongVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putLongVolatile(Class<?> type, String fieldName, long value) {
        Unsafe.putLongVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static float getFloatVolatile(Object object, Field fieldName) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putFloatVolatile(Object object, Field fieldName, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static float getFloatVolatile(Object object, String fieldName) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putFloatVolatile(Object object, String fieldName, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static float getFloatVolatile(Class<?> type, String fieldName) {
        return Unsafe.getFloatVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putFloatVolatile(Class<?> type, String fieldName, float value) {
        Unsafe.putFloatVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static double getDoubleVolatile(Object object, Field fieldName) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putDoubleVolatile(Object object, Field fieldName, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static double getDoubleVolatile(Object object, String fieldName) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putDoubleVolatile(Object object, String fieldName, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static double getDoubleVolatile(Class<?> type, String fieldName) {
        return Unsafe.getDoubleVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putDoubleVolatile(Class<?> type, String fieldName, double value) {
        Unsafe.putDoubleVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static <T> T getObjectVolatile(Object object, Field fieldName) {
        return Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putObjectVolatile(Object object, Field fieldName, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static <T> T getObjectVolatile(Object object, String fieldName) {
        return Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)));
    }

    public static void putObjectVolatile(Object object, String fieldName, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(object, fieldName)), value);
    }

    public static <T> T getObjectVolatile(Class<?> type, String fieldName) {
        return Unsafe.getObjectVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putObjectVolatile(Class<?> type, String fieldName, Object value) {
        Unsafe.putObjectVolatile(type, Unsafe.staticFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static Object getVolatile(Object object, Field fieldName) {
        return get(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName));
    }

    public static void putVolatile(Object object, Field fieldName, Object value) {
        put(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName), value);
    }

    public static Object getVolatile(Object object, String fieldName) {
        Field field = Fields.getField(object, fieldName);

        return get(object, field.getType(), Unsafe.objectFieldOffset(field));
    }

    public static void putVolatile(Object object, String fieldName, Object value) {
        Field field = Fields.getField(object, fieldName);

        put(object, field.getType(), Unsafe.objectFieldOffset(field), value);
    }

    public static Object getVolatile(Class<?> type, String fieldName) {
        Field field = Fields.getField(type, fieldName);

        return get(type, field.getType(), Unsafe.staticFieldOffset(field));
    }

    public static void putVolatile(Class<?> type, String fieldName, Object value) {
        Field field = Fields.getField(type, fieldName);

        put(type, field.getType(), Unsafe.staticFieldOffset(field), value);
    }

    public static boolean getBoolean(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putBoolean(Object object, Class<?> type, Field fieldName, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static boolean getBoolean(Object object, Class<?> type, String fieldName) {
        return Unsafe.getBoolean(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putBoolean(Object object, Class<?> type, String fieldName, boolean value) {
        Unsafe.putBoolean(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static byte getByte(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putByte(Object object, Class<?> type, Field fieldName, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static byte getByte(Object object, Class<?> type, String fieldName) {
        return Unsafe.getByte(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putByte(Object object, Class<?> type, String fieldName, byte value) {
        Unsafe.putByte(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static char getChar(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putChar(Object object, Class<?> type, Field fieldName, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static char getChar(Object object, Class<?> type, String fieldName) {
        return Unsafe.getChar(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putChar(Object object, Class<?> type, String fieldName, char value) {
        Unsafe.putChar(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static short getShort(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putShort(Object object, Class<?> type, Field fieldName, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static short getShort(Object object, Class<?> type, String fieldName) {
        return Unsafe.getShort(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putShort(Object object, Class<?> type, String fieldName, short value) {
        Unsafe.putShort(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static int getInt(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putInt(Object object, Class<?> type, Field fieldName, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static int getInt(Object object, Class<?> type, String fieldName) {
        return Unsafe.getInt(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putInt(Object object, Class<?> type, String fieldName, int value) {
        Unsafe.putInt(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static long getLong(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putLong(Object object, Class<?> type, Field fieldName, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static long getLong(Object object, Class<?> type, String fieldName) {
        return Unsafe.getLong(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putLong(Object object, Class<?> type, String fieldName, long value) {
        Unsafe.putLong(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static float getFloat(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putFloat(Object object, Class<?> type, Field fieldName, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static float getFloat(Object object, Class<?> type, String fieldName) {
        return Unsafe.getFloat(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putFloat(Object object, Class<?> type, String fieldName, float value) {
        Unsafe.putFloat(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static double getDouble(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putDouble(Object object, Class<?> type, Field fieldName, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static double getDouble(Object object, Class<?> type, String fieldName) {
        return Unsafe.getDouble(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putDouble(Object object, Class<?> type, String fieldName, double value) {
        Unsafe.putDouble(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static <T> T getObject(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getObject(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putObject(Object object, Class<?> type, Field fieldName, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static <T> T getObject(Object object, Class<?> type, String fieldName) {
        return Unsafe.getObject(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putObject(Object object, Class<?> type, String fieldName, Object value) {
        Unsafe.putObject(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static Object get(Object object, Class<?> type, Field fieldName) {
        return get(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName));
    }

    public static void put(Object object, Class<?> type, Field fieldName, Object value) {
        put(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName), value);
    }

    public static Object get(Object object, Class<?> type, String fieldName) {
        Field field = Fields.getField(type, fieldName);

        return get(object, field.getType(), Unsafe.objectFieldOffset(field));
    }

    public static void put(Object object, Class<?> type, String fieldName, Object value) {
        Field field = Fields.getField(type, fieldName);

        put(object, field.getType(), Unsafe.objectFieldOffset(field), value);
    }

    public static boolean getBooleanVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putBooleanVolatile(Object object, Class<?> type, Field fieldName, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static boolean getBooleanVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putBooleanVolatile(Object object, Class<?> type, String fieldName, boolean value) {
        Unsafe.putBooleanVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static byte getByteVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putByteVolatile(Object object, Class<?> type, Field fieldName, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static byte getByteVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putByteVolatile(Object object, Class<?> type, String fieldName, byte value) {
        Unsafe.putByteVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static char getCharVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putCharVolatile(Object object, Class<?> type, Field fieldName, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static char getCharVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putCharVolatile(Object object, Class<?> type, String fieldName, char value) {
        Unsafe.putCharVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static short getShortVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putShortVolatile(Object object, Class<?> type, Field fieldName, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static short getShortVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putShortVolatile(Object object, Class<?> type, String fieldName, short value) {
        Unsafe.putShortVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static int getIntVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putIntVolatile(Object object, Class<?> type, Field fieldName, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static int getIntVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putIntVolatile(Object object, Class<?> type, String fieldName, int value) {
        Unsafe.putIntVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static long getLongVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putLongVolatile(Object object, Class<?> type, Field fieldName, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static long getLongVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putLongVolatile(Object object, Class<?> type, String fieldName, long value) {
        Unsafe.putLongVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static float getFloatVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putFloatVolatile(Object object, Class<?> type, Field fieldName, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static float getFloatVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putFloatVolatile(Object object, Class<?> type, String fieldName, float value) {
        Unsafe.putFloatVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static double getDoubleVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putDoubleVolatile(Object object, Class<?> type, Field fieldName, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static double getDoubleVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putDoubleVolatile(Object object, Class<?> type, String fieldName, double value) {
        Unsafe.putDoubleVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static <T> T getObjectVolatile(Object object, Class<?> type, Field fieldName) {
        return Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(fieldName));
    }

    public static void putObjectVolatile(Object object, Class<?> type, Field fieldName, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(fieldName), value);
    }

    public static <T> T getObjectVolatile(Object object, Class<?> type, String fieldName) {
        return Unsafe.getObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)));
    }

    public static void putObjectVolatile(Object object, Class<?> type, String fieldName, Object value) {
        Unsafe.putObjectVolatile(object, Unsafe.objectFieldOffset(Fields.getField(type, fieldName)), value);
    }

    public static Object getVolatile(Object object, Class<?> type, Field fieldName) {
        return get(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName));
    }

    public static void putVolatile(Object object, Class<?> type, Field fieldName, Object value) {
        put(object, fieldName.getType(), Unsafe.objectFieldOffset(fieldName), value);
    }

    public static Object getVolatile(Object object, Class<?> type, String fieldName) {
        Field field = Fields.getField(type, fieldName);

        return get(object, field.getType(), Unsafe.objectFieldOffset(field));
    }

    public static void putVolatile(Object object, Class<?> type, String fieldName, Object value) {
        Field field = Fields.getField(type, fieldName);

        put(object, field.getType(), Unsafe.objectFieldOffset(field), value);
    }

    public static Object get(Object object, Class<?> type, long offset) {
        if (type == boolean.class) {
            return Unsafe.getBoolean(object, offset);
        } else if (type == byte.class) {
            return Unsafe.getByte(object, offset);
        } else if (type == char.class) {
            return Unsafe.getChar(object, offset);
        } else if (type == short.class) {
            return Unsafe.getShort(object, offset);
        } else if (type == int.class) {
            return Unsafe.getInt(object, offset);
        } else if (type == long.class) {
            return Unsafe.getLong(object, offset);
        } else if (type == float.class) {
            return Unsafe.getFloat(object, offset);
        } else if (type == double.class) {
            return Unsafe.getDouble(object, offset);
        }

        return Unsafe.getObject(object, offset);
    }

    public static void put(Object object, Class<?> type, long offset, Object value) {
        if (type == boolean.class) {
            Unsafe.putBoolean(object, offset, (boolean) value);
        } else if (type == byte.class) {
            Unsafe.putByte(object, offset, (byte) value);
        } else if (type == char.class) {
            Unsafe.putChar(object, offset, (char) value);
        } else if (type == short.class) {
            Unsafe.putShort(object, offset, (short) value);
        } else if (type == int.class) {
            Unsafe.putInt(object, offset, (int) value);
        } else if (type == long.class) {
            Unsafe.putLong(object, offset, (long) value);
        } else if (type == float.class) {
            Unsafe.putFloat(object, offset, (float) value);
        } else if (type == double.class) {
            Unsafe.putDouble(object, offset, (double) value);
        }

        Unsafe.putObject(object, offset, value);
    }

    public static Object getVolatile(Object object, Class<?> type, long offset) {
        if (type == boolean.class) {
            return Unsafe.getBooleanVolatile(object, offset);
        } else if (type == byte.class) {
            return Unsafe.getByteVolatile(object, offset);
        } else if (type == char.class) {
            return Unsafe.getCharVolatile(object, offset);
        } else if (type == short.class) {
            return Unsafe.getShortVolatile(object, offset);
        } else if (type == int.class) {
            return Unsafe.getIntVolatile(object, offset);
        } else if (type == long.class) {
            return Unsafe.getLongVolatile(object, offset);
        } else if (type == float.class) {
            return Unsafe.getFloatVolatile(object, offset);
        } else if (type == double.class) {
            return Unsafe.getDoubleVolatile(object, offset);
        }

        return Unsafe.getObjectVolatile(object, offset);
    }

    public static void putVolatile(Object object, Class<?> type, long offset, Object value) {
        if (type == boolean.class) {
            Unsafe.putBooleanVolatile(object, offset, (boolean) value);
        } else if (type == byte.class) {
            Unsafe.putByteVolatile(object, offset, (byte) value);
        } else if (type == char.class) {
            Unsafe.putCharVolatile(object, offset, (char) value);
        } else if (type == short.class) {
            Unsafe.putShortVolatile(object, offset, (short) value);
        } else if (type == int.class) {
            Unsafe.putIntVolatile(object, offset, (int) value);
        } else if (type == long.class) {
            Unsafe.putLongVolatile(object, offset, (long) value);
        } else if (type == float.class) {
            Unsafe.putFloatVolatile(object, offset, (float) value);
        } else if (type == double.class) {
            Unsafe.putDoubleVolatile(object, offset, (double) value);
        }

        Unsafe.putObjectVolatile(object, offset, value);
    }
}
