package user11681.reflect.experimental;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import net.gudenau.lib.unsafe.Unsafe;
import user11681.reflect.Invoker;

public class ReflectionFactory {
    public static final MethodHandle newField = Invoker.unreflectConstructor(Field.class.getDeclaredConstructors()[0]);

    private static final boolean newFieldHasBoolean = newField.type().parameterCount() == 8;

    public static boolean defaultTrustedFinal = false;

    public static Field newField(Class<?> declaringClass,
                                 final String name,
                                 final Class<?> type,
                                 final int modifiers,
                                 final int slot,
                                 final String signature,
                                 final byte[] annotations) {
        try {
            return newFieldHasBoolean
                ? (Field) newField.invokeExact(declaringClass, name, type, modifiers, defaultTrustedFinal, slot, signature, annotations)
                : (Field) newField.invokeExact(declaringClass, name, type, modifiers, slot, signature, annotations);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public static Field newField(Class<?> declaringClass,
                                 final String name,
                                 final Class<?> type,
                                 final int modifiers,
                                 final boolean trustedFinal,
                                 final int slot,
                                 final String signature,
                                 final byte[] annotations) {
        try {
            return newFieldHasBoolean
                ? (Field) newField.invokeExact(declaringClass, name, type, modifiers, trustedFinal, slot, signature, annotations)
                : (Field) newField.invokeExact(declaringClass, name, type, modifiers, slot, signature, annotations);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
