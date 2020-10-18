package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.gudenau.lib.unsafe.Unsafe;

public class Invoker {
    public static MethodHandle bind(final Object receiver, final String name, final MethodType type) {
        try {
            return Unsafe.trustedLookup.bind(receiver, name, type);
        } catch (final NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findConstructor(final Class<?> refc, final MethodType type) {
        try {
            return Unsafe.trustedLookup.findConstructor(refc, type);
        } catch (final NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findGetter(final Class<?> refc, final String name, final Class<?> type) {
        try {
            return Unsafe.trustedLookup.findGetter(refc, name, type);
        } catch (final IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSetter(final Class<?> refc, final String name, final Class<?> type) {
        try {
            return Unsafe.trustedLookup.findSetter(refc, name, type);
        } catch (final IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSpecial(final Class<?> refc, final String name, final MethodType type, final Class<?> specialCaller) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, type, specialCaller);
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStatic(final Class<?> refc, final String name, final MethodType type)  {
        try {
            return Unsafe.trustedLookup.findStatic(refc, name, type);
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStaticGetter(final Class<?> refc, final String name, final Class<?> type) {
        try {
            return Unsafe.trustedLookup.findStaticGetter(refc, name, type);
        } catch (final IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStaticSetter(final Class<?> refc, final String name, final Class<?> type) {
        try {
            return Unsafe.trustedLookup.findStaticSetter(refc, name, type);
        } catch (final IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findVirtual(final Class<?> refc, final String name, final MethodType type) {
        try {
            return Unsafe.trustedLookup.findVirtual(refc, name, type);
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflect(final Method m) {
        try {
            return Unsafe.trustedLookup.unreflect(m);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectConstructor(final Constructor<?> c) {
        try {
            return Unsafe.trustedLookup.unreflectConstructor(c);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectGetter(final Field f) {
        try {
            return Unsafe.trustedLookup.unreflectGetter(f);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSetter(final Field f) {
        try {
            return Unsafe.trustedLookup.unreflectSetter(f);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSpecial(final Method m, final Class<?> specialCaller) {
        try {
            return Unsafe.trustedLookup.unreflectSpecial(m, specialCaller);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    static {
        Reflect.disableSecurity();
    }
}
