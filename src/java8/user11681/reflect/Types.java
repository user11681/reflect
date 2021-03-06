package user11681.reflect;

public class Types {
    public static boolean equals(Class<?> klass, Class<?> other) {
        return klass == other || klass != null && (primitive(klass) == other || primitive(other) == klass);
    }

    public static boolean isWrapper(Class<?> klass) {
        return primitive(klass) != null;
    }

    public static Class<?> primitive(Class<?> klass) {
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

    public static Class<?> wrapper(Class<?> klass) {
        if (klass == void.class) {
            return Void.class;
        } else if (klass == boolean.class) {
            return Boolean.class;
        } else if (klass == byte.class) {
            return Byte.class;
        } else if (klass == char.class) {
            return Character.class;
        } else if (klass == short.class) {
            return Short.class;
        } else if (klass == int.class) {
            return Integer.class;
        } else if (klass == long.class) {
            return Long.class;
        } else if (klass == float.class) {
            return Float.class;
        } else if (klass == double.class) {
            return Double.class;
        }

        return null;
    }
}
