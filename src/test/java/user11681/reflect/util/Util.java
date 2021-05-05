package user11681.reflect.util;

import java.util.List;
import java.util.stream.Stream;
import net.gudenau.lib.unsafe.Unsafe;
import user11681.uncheck.ThrowingRunnable;

public class Util {
    public static int repetitions = 10000;

    public static <T> T nul() {
        return null;
    }

    public static void bp() {}

    public static <T> T last(List<T> list) {
        return list.get(list.size() - 1);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @SafeVarargs
    public static <T> Stream<T> join(Stream<? extends T>... streams) {
        return (Stream<T>) Stream.of(streams).reduce(Stream::concat).get();
    }

    public static String unqualifiedName(Class<?> type) {
        String name = type.getName();
        int dimensions = name.lastIndexOf('[') + 1;
        name = name.substring(dimensions);

        if (name.charAt(name.length() - 1) == ';') {
            name = name.substring(1, name.length() - 1);
        }

        return name.substring(name.lastIndexOf('.') + 1).replace('$', '.') + "[]".repeat(dimensions);
    }

    public static boolean equals(Object target, Object... objects) {
        for (Object object : objects) {
            if (!target.equals(object)) {
                return false;
            }
        }

        return true;
    }

    public static void repeat(ThrowingRunnable test) {
        repeat(repetitions, test);
    }

    public static void repeat(int repetitions, ThrowingRunnable test) {
        for (int i = 0; i < repetitions; i++) {
            try {
                test.run();
            } catch (Throwable throwable) {
                throw Unsafe.throwException(throwable);
            }
        }
    }
}
