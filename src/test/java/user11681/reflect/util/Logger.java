package user11681.reflect.util;

import java.util.Arrays;

public class Logger {
    public static void log(final Object... objects) {
        final String string = Arrays.toString(objects);

        log(string.substring(1, string.length() - 1));
    }

    public static void log(final String format, final Object... arguments) {
        System.out.printf(format + "\n", arguments);
    }
}
