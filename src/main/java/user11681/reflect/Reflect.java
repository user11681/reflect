package user11681.reflect;

import net.gudenau.lib.unsafe.Unsafe;

public class Reflect {
    public static final boolean java9;

    public static boolean initiated;

    /**
     * the default class loader for some operations like loading classes
     */
    public static ClassLoader defaultClassLoader = Classes.class.getClassLoader();

    public static void disableSecurity() {
        if (!initiated) {
            initiated = true;

            if (java9) {
                final Class<?> IllegalAccessLogger = Classes.load(Reflect.class.getClassLoader(), "jdk.internal.module.IllegalAccessLogger");

                try {
                    Accessor.putObjectVolatile(IllegalAccessLogger, IllegalAccessLogger.getDeclaredField("logger"), null);
                } catch (final NoSuchFieldException throwable) {
                    throw Unsafe.throwException(throwable);
                }
            }
        }
    }

    static {
        final String version = System.getProperty("java.version");

        java9 = version.indexOf('.') != 1 || version.indexOf(2) == '9';
    }
}
