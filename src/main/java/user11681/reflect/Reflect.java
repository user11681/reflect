package user11681.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.gudenau.lib.unsafe.Unsafe;

public class Reflect {
    public static final boolean java9 = System.getProperty("java.version").indexOf('.') != 1;

    public static boolean illegalAccessLoggerDisabled;
    public static boolean securityDisabled;

    /**
     * the default class loader for some operations like loading classes
     */
    public static ClassLoader defaultClassLoader = Reflect.class.getClassLoader();

    public static void disableIllegalAccessLogger() {
        if (!illegalAccessLoggerDisabled) {
            if (java9) {
                try {
                    final Class<?> IllegalAccessLogger = Class.forName("jdk.internal.module.IllegalAccessLogger", false, defaultClassLoader);

                    Unsafe.putObjectVolatile(IllegalAccessLogger, Unsafe.staticFieldOffset(IllegalAccessLogger.getDeclaredField("logger")), null);
                } catch (Throwable throwable) {
                    throw Unsafe.throwException(throwable);
                }
            }

            illegalAccessLoggerDisabled = true;
        }
    }

    public static void disableSecurity() {
        if (!securityDisabled) {
            final Field security = Fields.rawField(System.class, "security");

            if (Modifier.isVolatile(security.getModifiers())) {
                Unsafe.putObject(System.class, Unsafe.staticFieldOffset(security), null);
            } else {
                Unsafe.putObjectVolatile(System.class, Unsafe.staticFieldOffset(security), null);
            }

            securityDisabled = true;
        }
    }
}
