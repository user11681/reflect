package user11681.reflect.util;

import java.util.Arrays;

public class Logger {
    public static void log(Object... objects) {
        final String string = Arrays.toString(objects);

        log(string.substring(1, string.length() - 1));
    }

    public static void log(String format, Object... arguments) {
        System.out.printf(format + "\n", arguments);
    }
}
