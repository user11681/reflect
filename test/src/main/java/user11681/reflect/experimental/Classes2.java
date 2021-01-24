package user11681.reflect.experimental;

import java.lang.reflect.Type;
import net.gudenau.lib.unsafe.Unsafe;
import user11681.reflect.Classes;
import user11681.reflect.Reflect;

public class Classes2 extends Classes {
    public static <T> Class<T> load(Type type) {
        return load(Reflect.defaultClassLoader, true, type);
    }

    public static <T> Class<T> load(boolean initialize, Type type) {
        return load(Reflect.defaultClassLoader, initialize, type);
    }

    public static <T> Class<T> load(ClassLoader loader, Type type) {
        return load(loader, true, type);
    }

    public static <T> Class<T> load(ClassLoader loader, boolean initialize, Type type) {
        return (Class<T>) (type instanceof Class ? type : load(loader, initialize, type.getTypeName()));
    }

    public static void addClass(String to, Class<?> from) {
        addClass((Object) Unsafe.allocateInstance(load(to)), Unsafe.allocateInstance(from));
    }

    public static void addClass(Class<?> to, String from) {
        addClass(Unsafe.allocateInstance(to), (Object) Unsafe.allocateInstance(load(from)));
    }

    public static void addClass(Class<?> to, Class<?> from) {
        addClass(Unsafe.allocateInstance(to), Unsafe.allocateInstance(from));
    }

    public static <T> T addClass(Class<?> to, Object from) {
        return addClass(Unsafe.allocateInstance(to), from);
    }

    public static <T> T addClass(Object to, Class<?> from) {
        return addClass(to, Unsafe.allocateInstance(from));
    }

    public static <T> T addClass(Object to, Object from) {
        if (longClassPointer) {
            Unsafe.putAddress(Unsafe.getLong(to, classOffset) + 36, Unsafe.getLong(from, classOffset));
        } else {
            Unsafe.putAddress(Integer.toUnsignedLong(Unsafe.getInt(to, classOffset)) + 36, Integer.toUnsignedLong(Unsafe.getInt(from, classOffset)));
        }

        return (T) to;
    }
}
