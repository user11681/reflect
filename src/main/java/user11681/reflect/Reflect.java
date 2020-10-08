package user11681.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class Reflect {
    public static final boolean java9;

    public static boolean initiated;

    public static void disableSecurity() {
        if (!initiated) {
            initiated = true;

            if (java9) {
                final Class<?> IllegalAccessLogger = Classes.load("jdk.internal.module.IllegalAccessLogger");

                try {
                    Accessor.putObjectVolatile(IllegalAccessLogger, IllegalAccessLogger.getDeclaredField("logger"), null);
                } catch (final NoSuchFieldException throwable) {
                    throw new RuntimeException(throwable);
                }
            }

            final Class<?> Reflection = Classes.load(java9 ? "jdk.internal.reflect.Reflection" : "sun.reflect.Reflection");

            Accessor.putObjectVolatile(Reflection, "fieldFilterMap", new HashMap<>());
            Accessor.putObjectVolatile(Reflection, "methodFilterMap", new HashMap<>());

            final Field security = Fields.getField(System.class, "security");

            if ((security.getModifiers() & Modifier.VOLATILE) == 0) {
                Accessor.putObject(security, null);
            } else {
                Accessor.putObjectVolatile(security, null);
            }
        }
    }

    static {
        final String version = System.getProperty("java.version");

        java9 = version.indexOf('.') != 1 || version.indexOf(2) == '9';
    }
}
