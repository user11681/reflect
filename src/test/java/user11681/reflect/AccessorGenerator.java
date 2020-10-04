package user11681.reflect;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class AccessorGenerator {
    static final String[] suffixes = {
        "",
        "Volatile"
    };
    static final String[] accessTypes = {
        "get",
        "put"
    };
    static final String[] types = {
        "int",
        "Object",
        "boolean",
        "byte",
        "short",
        "char",
        "long",
        "float",
        "double"
    };

    @Test
    void test() {
        for (final String suffix : suffixes) {
            for (final String type : types) {
                final boolean object = type.equals("Object");

                for (final String accessType : accessTypes) {
                    final boolean put = accessType.equals("put");
                    final String methodName = accessType + type.toUpperCase().charAt(0) + type.substring(1) + suffix;

                    final String[] lines = {
                        "",
                        String.format("public static %s %s(final Object object, final String field" + (put ? ", " + type + " value" : "") + ") {", put ? "void" : object ? "<T> T" : type, methodName),
                        String.format("    " + (put ? "" : "return " + (object ? "(T) " : "")) + "Unsafe.%s(object, Unsafe.objectFieldOffset(Reflect.getField(object, field))" + (put ? ", value" : "") + ");", methodName),
                        "}"
                    };

                    for (final String line : lines) {
                        log(line);
                    }
                }
            }
        }
    }

    static void log(final Object format, final Object... arguments) {
        log(String.valueOf(format), arguments);
    }

    static void log(final String format, final Object... arguments) {
        System.out.printf(format + "\n", arguments);
    }
}
