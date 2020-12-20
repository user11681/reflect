package user11681.reflect;

import java.lang.invoke.MethodHandle;

import net.gudenau.lib.unsafe.Unsafe;

public class JavaLangAccess {
    public static final Object javaLangAccess;

    private static final MethodHandle getConstantPool;

    public static Object getConstantPool(Class<?> klass) {
        try {
            return getConstantPool.invoke(klass);
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    static {
        try {
            javaLangAccess = Invoker.findStatic(Classes.SharedSecrets, "getJavaLangAccess", Classes.JavaLangAccess).invoke();
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }

        getConstantPool = Invoker.bind(javaLangAccess, "getConstantPool", Classes.ConstantPool, Class.class);
    }
}
