package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.gudenau.lib.unsafe.Unsafe;

public class Invoker {
    public static <T> T apply(MethodHandle handle, Object... arguments) {
        try {
            return (T) handle.invokeWithArguments(arguments);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static void run(MethodHandle handle, Object... arguments) {
        try {
            handle.invokeWithArguments(arguments);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static MethodHandle bind(Object receiver, String name, MethodType type) {
        try {
            return Unsafe.trustedLookup.bind(receiver, name, type);
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle bind(Object receiver, String name, Class<?> returnType) {
        try {
            return Unsafe.trustedLookup.bind(receiver, name, MethodType.methodType(returnType));
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle bind(Object receiver, String name, Class<?> returnType, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.bind(receiver, name, MethodType.methodType(returnType, parameterTypes));
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findConstructor(Class<?> refc, MethodType type) {
        try {
            return Unsafe.trustedLookup.findConstructor(refc, type);
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findConstructor(Class<?> refc) {
        try {
            return Unsafe.trustedLookup.findConstructor(refc, MethodType.methodType(void.class));
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findConstructor(Class<?> refc, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.findConstructor(refc, MethodType.methodType(void.class, parameterTypes));
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findGetter(Class<?> refc, String name, Class<?> type) {
        try {
            return Unsafe.trustedLookup.findGetter(refc, name, type);
        } catch (IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSetter(Class<?> refc, String name, Class<?> type) {
        try {
            return Unsafe.trustedLookup.findSetter(refc, name, type);
        } catch (IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSpecial(Class<?> refc, String name, MethodType type, Class<?> specialCaller) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, type, specialCaller);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }


    public static MethodHandle findSpecial(Class<?> refc, String name, Class<?> returnType) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, MethodType.methodType(returnType), refc);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSpecial(Class<?> refc, String name, Class<?> returnType, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, MethodType.methodType(returnType), refc);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSpecial(Class<?> specialCaller, Class<?> refc, String name, Class<?> returnType) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, MethodType.methodType(returnType), specialCaller);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findSpecial(Class<?> specialCaller, Class<?> refc, String name, Class<?> returnType, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.findSpecial(refc, name, MethodType.methodType(returnType, parameterTypes), specialCaller);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStatic(Class<?> refc, String name, MethodType type)  {
        try {
            return Unsafe.trustedLookup.findStatic(refc, name, type);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStatic(Class<?> refc, String name, Class<?> returnType)  {
        try {
            return Unsafe.trustedLookup.findStatic(refc, name, MethodType.methodType(returnType));
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStatic(Class<?> refc, String name, Class<?> returnType, Class<?>... parameterTypes)  {
        try {
            return Unsafe.trustedLookup.findStatic(refc, name, MethodType.methodType(returnType, parameterTypes));
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStaticGetter(Class<?> refc, String name, Class<?> type) {
        try {
            return Unsafe.trustedLookup.findStaticGetter(refc, name, type);
        } catch (IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findStaticSetter(Class<?> refc, String name, Class<?> type) {
        try {
            return Unsafe.trustedLookup.findStaticSetter(refc, name, type);
        } catch (IllegalAccessException | NoSuchFieldException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findVirtual(Class<?> refc, String name, MethodType type) {
        try {
            return Unsafe.trustedLookup.findVirtual(refc, name, type);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findVirtual(Class<?> refc, String name, Class<?> returnType) {
        try {
            return Unsafe.trustedLookup.findVirtual(refc, name, MethodType.methodType(returnType));
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle findVirtual(Class<?> refc, String name, Class<?> returnType, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.findVirtual(refc, name, MethodType.methodType(returnType, parameterTypes));
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflect(Method method) {
        try {
            return Unsafe.trustedLookup.unreflect(method);
        } catch (IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflect(Class<?> klass, String name, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflect(klass.getDeclaredMethod(name, parameterTypes));
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectConstructor(Constructor<?> constructor) {
        try {
            return Unsafe.trustedLookup.unreflectConstructor(constructor);
        } catch (IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectConstructor(Class<?> klass, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflectConstructor(klass.getDeclaredConstructor(parameterTypes));
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectGetter(Field field) {
        try {
            return Unsafe.trustedLookup.unreflectGetter(field);
        } catch (IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectGetter(Class<?> klass, String name) {
        try {
            return Unsafe.trustedLookup.unreflectGetter(Fields.getField(klass, name));
        } catch (IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSetter(Field field) {
        try {
            return Unsafe.trustedLookup.unreflectSetter(field);
        } catch (IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSetter(Class<?> klass, String name) {
        try {
            return Unsafe.trustedLookup.unreflectSetter(Fields.getField(klass, name));
        } catch (IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSpecial(Method method, Class<?> specialCaller) {
        try {
            return Unsafe.trustedLookup.unreflectSpecial(method, specialCaller);
        } catch (IllegalAccessException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSpecial(Class<?> klass, String name, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflectSpecial(klass.getDeclaredMethod(name, parameterTypes), klass);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static MethodHandle unreflectSpecial(Class<?> specialCaller, Class<?> klass, String name, Class<?>... parameterTypes) {
        try {
            return Unsafe.trustedLookup.unreflectSpecial(klass.getDeclaredMethod(name, parameterTypes), specialCaller);
        } catch (IllegalAccessException | NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }
}
