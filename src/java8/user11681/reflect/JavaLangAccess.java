package user11681.reflect;

import java.lang.invoke.MethodHandle;

import net.gudenau.lib.unsafe.Unsafe;

public class JavaLangAccess {
    public static final Object javaLangAccess = Invoker.invoke(Invoker.findStatic(Classes.SharedSecrets, "getJavaLangAccess", Classes.JavaLangAccess));

    private static final MethodHandle getConstantPool = Invoker.bind(javaLangAccess, "getConstantPool", Classes.ConstantPool, Class.class);

    public static Object getConstantPool(Class<?> klass) {
        try {
            return getConstantPool.invoke(klass);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }
}
