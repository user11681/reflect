package user11681.reflect;

public class Primitives {
    public static boolean equals(final Class<?> klass, final Class<?> other) {
        if (klass == other) {
            return true;
        }

        if (klass == null) {
            return false;
        }

        if (getPrimitive(klass) == other) {
            return true;
        }

        return getPrimitive(other) == klass;
    }

    public static boolean isWrapper(final Class<?> klass) {
        return getPrimitive(klass) != null;
    }

    public static Class<?> getPrimitive(final Class<?> klass) {
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
