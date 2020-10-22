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

    public static MethodHandle bind(final Object receiver, final String name, final Class<?> returnType) {
        try {
            return Unsafe.trustedLookup.bind(receiver, name, MethodType.methodType(returnType));
        } catch (final NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle bind(final Object receiver, final String name, final Class<?> returnType, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.bind(receiver, name, MethodType.methodType(returnType, parameterTypes));
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

    public static MethodHandle findConstructor(final Class<?> refc) {
        try {
            return Unsafe.trustedLookup.findConstructor(refc, MethodType.methodType(void.class));
        } catch (final NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findConstructor(final Class<?> refc, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.findConstructor(refc, MethodType.methodType(void.class, parameterTypes));
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

    public static MethodHandle findSpecial(final Class<?> specialCaller, final Class<?> refc, final String name, final Class<?> returnType) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, MethodType.methodType(returnType), specialCaller);
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSpecial(final Class<?> specialCaller, final Class<?> refc, final String name, final Class<?> returnType, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, MethodType.methodType(returnType, parameterTypes), specialCaller);
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

    public static MethodHandle findStatic(final Class<?> refc, final String name, final Class<?> returnType)  {
        try {
            return Unsafe.trustedLookup.findStatic(refc, name, MethodType.methodType(returnType));
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStatic(final Class<?> refc, final String name, final Class<?> returnType, final Class<?>... parameterTypes)  {
        try {
            return Unsafe.trustedLookup.findStatic(refc, name, MethodType.methodType(returnType, parameterTypes));
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

    public static MethodHandle findVirtual(final Class<?> refc, final String name, final Class<?> returnType) {
        try {
            return Unsafe.trustedLookup.findVirtual(refc, name, MethodType.methodType(returnType));
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findVirtual(final Class<?> refc, final String name, final Class<?> returnType, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.findVirtual(refc, name, MethodType.methodType(returnType, parameterTypes));
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflect(final Method method) {
        try {
            return Unsafe.trustedLookup.unreflect(method);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflect(final Class<?> klass, final String name, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflect(klass.getDeclaredMethod(name, parameterTypes));
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectConstructor(final Constructor<?> constructor) {
        try {
            return Unsafe.trustedLookup.unreflectConstructor(constructor);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectConstructor(final Class<?> klass, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflectConstructor(klass.getDeclaredConstructor(parameterTypes));
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectGetter(final Field field) {
        try {
            return Unsafe.trustedLookup.unreflectGetter(field);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectGetter(final Class<?> klass, final String name) {
        try {
            return Unsafe.trustedLookup.unreflectGetter(Fields.getField(klass, name));
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSetter(final Field field) {
        try {
            return Unsafe.trustedLookup.unreflectSetter(field);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSetter(final Class<?> klass, final String name) {
        try {
            return Unsafe.trustedLookup.unreflectSetter(Fields.getField(klass, name));
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSpecial(final Method method, final Class<?> specialCaller) {
        try {
            return Unsafe.trustedLookup.unreflectSpecial(method, specialCaller);
        } catch (final IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSpecial(final Class<?> klass, final String name, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflectSpecial(klass.getDeclaredMethod(name, parameterTypes), klass);
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSpecial(final Class<?> specialCaller, final Class<?> klass, final String name, final Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflectSpecial(klass.getDeclaredMethod(name, parameterTypes), specialCaller);
        } catch (final IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    static {
        Reflect.disableSecurity();
    }
}
