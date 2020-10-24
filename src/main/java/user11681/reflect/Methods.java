package user11681.reflect;

import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import net.gudenau.lib.unsafe.Unsafe;

public class Methods {
    private static final MethodHandle getDeclaredMethods;

    private static final boolean getDeclaredMethodsHasBoolean;

    private static final Reference2ReferenceOpenHashMap<Class<?>, Method[]> methodCache = new Reference2ReferenceOpenHashMap<>();

    private static final Method NOT_FOUND = null;

    public static <T> T getDefaultValue(final Class<? extends Annotation> annotationType, final String elementName) {
        try {
            return (T) annotationType.getDeclaredMethod(elementName).getDefaultValue();
        } catch (final NoSuchMethodException exception) {
            throw Unsafe.throwException(exception);
        }
    }

    public static Method getMethod(final Object object, final String name) {
        Class<?> klass = object.getClass();
        Method method;

        while (klass != null) {
            if ((method = getMethod(klass, name)) != null) {
                return method;
            }

            klass = klass.getSuperclass();
        }

        return NOT_FOUND;
    }

    public static Method getMethod(final Object object, final String name, final Class<?>... parameterTypes) {
        Class<?> klass = object.getClass();
        Method method;

        while (klass != null) {
            if ((method = getMethod(klass, name, parameterTypes)) != null) {
                return method;
            }

            klass = klass.getSuperclass();
        }

        return NOT_FOUND;
    }

    public static Method getMethod(final Class<?> klass, final String name, final Class<?>... parameterTypes) {
        final Method[] methods = getMethods(klass);
        Class<?>[] parameterTypes1;
        Method method;
        int parameterCount;
        int j;

        method:
        for (int i = 0, length = methods.length; i < length; i++) {
            if (methods[i].getName().equals(name)) {
                method = methods[i];

                if ((parameterCount = (parameterTypes1 = method.getParameterTypes()).length) == parameterTypes.length) {
                    for (j = 0; j < parameterCount; j++) {
                        if (parameterTypes1[j] != parameterTypes[j]) {
                            continue method;
                        }
                    }

                    return methods[i];
                }
            }
        }

        return NOT_FOUND;
    }

    public static Method getMethod(final Class<?> klass, final String name) {
        final Method[] methods = getMethods(klass);

        for (int i = 0, length = methods.length; i < length; i++) {
            if (methods[i].getName().equals(name)) {
                return methods[i];
            }
        }

        return NOT_FOUND;
    }

    public static Method[] getMethods(final Class<?> klass) {
        Method[] methods = methodCache.get(klass);

        if (methods == null) {
            methods = getRawMethods(klass);

            for (final Method method : methods) {
                Unsafe.putBoolean(method, Fields.overrideOffset, true);
            }

            methodCache.put(klass, methods);
        }

        return methods;
    }

    public static Method[] getRawMethods(final Class<?> klass) {
        try {
            return getDeclaredMethodsHasBoolean
                ? (Method[]) getDeclaredMethods.invokeExact(klass, false)
                : (Method[]) getDeclaredMethods.invokeExact(klass);
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        Reflect.disableIllegalAccessLogger();

        try {
            MethodHandle tempGetDeclaredMethods = null;
            boolean tempGetDeclaredMethodsHasBoolean = false;

            for (final Method method : Class.class.getDeclaredMethods()) {
                if (Modifier.isNative(method.getModifiers()) && method.getReturnType() == Method[].class) {
                    tempGetDeclaredMethods = Unsafe.trustedLookup.unreflect(method);

                    if (method.getParameterCount() > 0) {
                        tempGetDeclaredMethodsHasBoolean = true;
                    }

                    break;
                }
            }

            getDeclaredMethods = tempGetDeclaredMethods;
            getDeclaredMethodsHasBoolean = tempGetDeclaredMethodsHasBoolean;
        } catch (final Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
