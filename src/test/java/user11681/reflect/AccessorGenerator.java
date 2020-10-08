package user11681.reflect;

import it.unimi.dsi.fastutil.objects.Object2ReferenceLinkedOpenHashMap;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class AccessorGenerator {
    static final String[] fieldDiscriminators = {"String", "Field", "long"};
    static final Object2ReferenceLinkedOpenHashMap<String, String> discriminatorNames = new Object2ReferenceLinkedOpenHashMap<>(new String[]{
        "String", "Field", "long"
    }, new String[]{
        "field", "field", "offset"
    });
    static final Object2ReferenceLinkedOpenHashMap<String, String> ownerTypes = new Object2ReferenceLinkedOpenHashMap<>(new String[]{
        "Object", "Class<?>"
    }, new String[]{
        "Unsafe.objectFieldOffset", "Unsafe.staticFieldOffset"
    });
    static final String[] suffixes = {"", "Volatile"};
    static final String[] accessTypes = {"get", "put"};
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
    void copy() {
        for (final String suffix : suffixes) {
            for (final String type : types) {
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
                                offset = ownerTypes.get(ownerType) + "(Fields.getField(to, field))"; break;
                            case "Field":
                                offset = ownerTypes.get(ownerType) + "(field)"; break;
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
            for (final String type : types) {
                final boolean object = type.equals("Object");

                for (final String accessType : accessTypes) {
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
}
