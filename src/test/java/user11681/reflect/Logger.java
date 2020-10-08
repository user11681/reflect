package user11681.reflect;

public class Logger {
    public static void log(final Object format, final Object... arguments) {
        log(String.valueOf(format), arguments);
    }

    public static void log(final String format, final Object... arguments) {
        System.out.printf(format + "\n", arguments);
    }
}
