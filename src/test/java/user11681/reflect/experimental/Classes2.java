package user11681.reflect.experimental;

import net.gudenau.lib.unsafe.Unsafe;
import user11681.reflect.Accessor;
import user11681.reflect.Classes;

public class Classes2 extends Classes {
    public static void addClass(final String to, final Class<?> from) {
        addClass((Object) Unsafe.allocateInstance(load(to)), Unsafe.allocateInstance(from));
    }

    public static void addClass(final Class<?> to, final String from) {
        addClass(Unsafe.allocateInstance(to), (Object) Unsafe.allocateInstance(load(from)));
    }

    public static void addClass(final Class<?> to, final Class<?> from) {
        addClass(Unsafe.allocateInstance(to), Unsafe.allocateInstance(from));
    }

    public static <T> T addClass(final Class<?> to, final Object from) {
        return addClass(Unsafe.allocateInstance(to), from);
    }

    public static <T> T addClass(final Object to, final Class<?> from) {
        return addClass(to, Unsafe.allocateInstance(from));
    }

    public static <T> T addClass(final Object to, final Object from) {
        if (longClassPointer) {
            Unsafe.putAddress(Accessor.addressOf(Unsafe.getLong(to, classOffset)) + 36, Accessor.addressOf(Unsafe.getLong(from, classOffset)));
        } else {
            Unsafe.putAddress(Accessor.addressOf(Unsafe.getInt(to, classOffset)) + 36, Accessor.addressOf(Unsafe.getInt(from, classOffset)));
        }

        return (T) to;
    }
}
