package user11681.reflect.util;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class AccessorGenerator {
    static final String[] fieldDiscriminators = {"String", "Field", "long"};
    static final Object2ObjectLinkedOpenHashMap<String, String> discriminatorNames = new Object2ObjectLinkedOpenHashMap<>(new String[]{
        "String", "Field", "long"
    }, new String[]{
        "field", "field", "offset"
    });
    static final Object2ObjectLinkedOpenHashMap<String, String> ownerTypes = new Object2ObjectLinkedOpenHashMap<>(new String[]{
        "Object", "Class<?>"
    }, new String[]{
        "Unsafe.objectFieldOffset", "Unsafe.staticFieldOffset"
    });
    static final String[] suffixes = {"", "Volatile"};
    static final Object2ObjectLinkedOpenHashMap<String, String> accessTypes = new Object2ObjectLinkedOpenHashMap<>(new String[]{
        "get", "put"
    }, new String[]{
        "return ", ""
    });
    static final Object2ObjectLinkedOpenHashMap<String, String> types = new Object2ObjectLinkedOpenHashMap<>(new String[]{
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
    });

    @Test
    void specifiedClassObject() {
        for (final String suffix : suffixes) {
            for (final String type : types.keySet()) {
                for (final String accessType : accessTypes.keySet()) {
                    final String[] lines;
                    final String methodName = accessType + capitalize(type) + suffix;

                    if (accessType.equals("get")) {
                        lines = new String[]{
                            "",
                            String.format("public static %s %s(final Object object, final Class<?> klass, final String field) {", types.get(type), methodName),
                            String.format("    %sUnsafe.%s(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)));", accessTypes.get(accessType) + (type.equals("Object") ? "(T) " : ""), methodName),
                            "}"
                        };
                    } else {
                        lines = new String[]{
                            "",
                            String.format("public static void %s(final Object object, final Class<?> klass, final String field, final %s value) {", methodName, type),
                            String.format("    Unsafe.%s(object, Unsafe.objectFieldOffset(Fields.getField(klass, field)), value);", methodName),
                            "}"
                        };
                    }

                    for (final String line : lines) {
                        Logger.log(line);
                    }
                }
            }
        }
    }

    @Test
    void copy() {
        for (final String suffix : suffixes) {
            for (final String type : types.keySet()) {
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

                    for (final String discriminator : fieldDiscriminators) {
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
                            String.format("public static %svoid copy%s(final %3$s to, final %s from, final %s %s) {", genericType, methodName, parameterType, discriminator, discriminatorNames.get(discriminator)),
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

                        for (final String line : lines) {
                            Logger.log(line);
                        }
                    }
                }
            }
        }
    }

    @Test
    void objectString() {
        for (final String suffix : suffixes) {
            for (final String type : types.keySet()) {
                final boolean object = type.equals("Object");

                for (final String accessType : accessTypes.keySet()) {
                    final boolean put = accessType.equals("put");
                    final String methodName = accessType + type.toUpperCase().charAt(0) + type.substring(1) + suffix;

                    final String[] lines = {
                        "",
                        String.format("public static %s %s(final Object object, final String field" + (put ? ", " + type + " value" : "") + ") {", put ? "void" : object ? "<T> T" : type, methodName),
                        String.format("    " + (put ? "" : "return " + (object ? "(T) " : "")) + "Unsafe.%s(object, Unsafe.objectFieldOffset(Fields.getField(object, field))" + (put ? ", value" : "") + ");", methodName),
                        "}"
                    };

                    for (final String line : lines) {
                        Logger.log(line);
                    }
                }
            }
        }
    }

    static String capitalize(final String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
