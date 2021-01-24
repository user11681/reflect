package user11681.reflect;

public class Types {
    public static boolean equals(Class<?> klass, Class<?> other) {
        return klass == other || klass != null && (getPrimitive(klass) == other || getPrimitive(other) == klass);
    }

    public static boolean isWrapper(Class<?> klass) {
        return getPrimitive(klass) != null;
    }

    public static Class<?> getPrimitive(Class<?> klass) {
        if (klass == Void.class) {
            return void.class;
        } else if (klass == Boolean.class) {
            return boolean.class;
        } else if (klass == Byte.class) {
            return byte.class;
        } else if (klass == Character.class) {
            return char.class;
        } else if (klass == Short.class) {
            return short.class;
        } else if (klass == Integer.class) {
            return int.class;
        } else if (klass == Long.class) {
            return long.class;
        } else if (klass == Float.class) {
            return float.class;
        } else if (klass == Double.class) {
            return double.class;
        }

        return null;
    }
}
