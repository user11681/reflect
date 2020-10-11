package user11681.reflect;

public class Reflect {
    public static final boolean java9;

    public static boolean initiated;

    public static void disableSecurity() {
        if (!initiated) {
            initiated = true;

            if (java9) {
                final Class<?> IllegalAccessLogger = Classes.load(Reflect.class.getClassLoader(), "jdk.internal.module.IllegalAccessLogger");

                try {
                    Accessor.putObjectVolatile(IllegalAccessLogger, IllegalAccessLogger.getDeclaredField("logger"), null);
                } catch (final NoSuchFieldException throwable) {
                    throw new RuntimeException(throwable);
                }
            }
        }
    }

    static {
        final String version = System.getProperty("java.version");

        java9 = version.indexOf('.') != 1 || version.indexOf(2) == '9';
    }
}
