package user11681.reflect.util;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class AccessorGenerator {
    static final String[] fieldDiscriminators = {"String", "Field", "long"};
    static final Map<String, String> discriminatorNames = wrap(new String[]{
        "String", "Field", "long"
    }, new String[]{
        "field", "field", "offset"
    });
    static final Map<String, String> ownerTypes = wrap(new String[]{
        "Object", "Class<?>"
    }, new String[]{
        "Unsafe.objectFieldOffset", "Unsafe.staticFieldOffset"
    });
    static final String[] suffixes = {"", "Volatile"};
    static final Map<String, String> accessTypes = wrap(new String[]{
        "get", "put"
    }, new String[]{
        "return ", ""
    });
    static final Map<String, String> types = wrap(
        new String[]{
            "int",
            "Object",
            "boolean",
            "byte",
            "short",
            "char",
            "long",
            "float",
            "double"
        }, new String[]{
            "int",
            "<T> T",
            "boolean",
            "byte",
            "short",
            "char",
            "long",
            "float",
            "double"
        }
    );

    static <K, V> HashMap<K, V> wrap(K[] keys, V[] values) {
        final HashMap<K, V> map = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        return map;
    }

    @Test
    void specifiedClassObject() {
        for (String suffix : suffixes) {
            for (String type : types.keySet()) {
                for (String accessType : accessTypes.keySet()) {
                    final String[] lines;
                    final String methodName = accessType + capitalize(type) + suffix;

                    if (accessType.equals("get")) {
                        lines = new String[]{
                            "",
                            String.format("public static %s %s(Object object, Class<?> klass, String field) {", types.get(type), methodName),
                            String.format("    %sUnsafe.%s(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));", accessTypes.get(accessType) + (type.equals("Object") ? "(T) " : ""), methodName),
                            "}"
                        };
                    } else {
                        lines = new String[]{
                            "",
                            String.format("public static void %s(Object object, Class<?> klass, String field, %s value) {", methodName, type),
                            String.format("    Unsafe.%s(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);", methodName),
                            "}"
                        };
                    }

                    for (String line : lines) {
                        Logger.log(line);
                    }
                }
            }
        }
    }

    @Test
    void copy() {
        for (String suffix : suffixes) {
            for (String type : types.keySet()) {
                for (String ownerType : ownerTypes.keySet()) {
                    final String genericType;
                    final String parameterType;

                    if (ownerType.equals("Object")) {
                        parameterType = "T";
                        genericType = "<T> ";
                    } else {
                        parameterType = ownerType;
                        genericType = "";
                    }

                    for (String discriminator : fieldDiscriminators) {
                        final String methodName = type.toUpperCase().charAt(0) + type.substring(1) + suffix;
                        final String offset;

                        switch (discriminator) {
                            case "String":
                                offset = ownerTypes.get(ownerType) + "(Fields.getField(to, field))";
                                break;
                            case "Field":
                                offset = ownerTypes.get(ownerType) + "(field)";
                                break;
                            default:
                                offset = "offset";
                        }

                        String[] lines = {
                            "",
                            String.format("public static %svoid copy%s(%3$s to, %s from, %s %s) {", genericType, methodName, parameterType, discriminator, discriminatorNames.get(discriminator)),
                            String.format("    Unsafe.put%s(to, offset, Unsafe.get%s(from, offset));", methodName, methodName),
                            "}"
                        };

                        if (!discriminator.equals("long")) {
                            lines = new String[]{
                                lines[0],
                                lines[1],
                                String.format("    final long offset = %s;", offset),
                                "",
                                lines[2],
                                lines[3]
                            };
                        }

                        for (String line : lines) {
                            Logger.log(line);
                        }
                    }
                }
            }
        }
    }

    @Test
    void objectString() {
        for (String suffix : suffixes) {
            for (String type : types.keySet()) {
                final boolean object = type.equals("Object");

                for (String accessType : accessTypes.keySet()) {
                    final boolean put = accessType.equals("put");
                    final String methodName = accessType + type.toUpperCase().charAt(0) + type.substring(1) + suffix;

                    final String[] lines = {
                        "",
                        String.format("public static %s %s(Object object, String field" + (put ? ", " + type + " value" : "") + ") {", put ? "void" : object ? "<T> T" : type, methodName),
                        String.format("    " + (put ? "" : "return " + (object ? "(T) " : "")) + "Unsafe.%s(object, Unsafe.objectFieldOffset(Fields.getField(object, field))" + (put ? ", value" : "") + ");", methodName),
                        "}"
                    };

                    for (String line : lines) {
                        Logger.log(line);
                    }
                }
            }
        }
    }

    static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
