package user11681.reflect;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import net.gudenau.lib.unsafe.Unsafe;

public abstract class ClassGenerator {
    public final StringBuilder pakkage = new StringBuilder();
    public final StringBuilder klass = new StringBuilder();
    public final List<String> imports = new ArrayList<>();
    public final String outputFile;

    private String indentation = "";

    public ClassGenerator(String outputFile, String pakkage, String klass) {
        this.outputFile = outputFile;

        this.pakkage.append("package ").append(pakkage).append(";");
        this.klass("public class ").klass(klass).klass(" {");

        this.setIndentation(4).newLine();
    }

    public static String repeat(char character, int times) {
        return repeat(String.valueOf(character), times);
    }

    public static String repeat(String string, int times) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i != times; i++) {
            builder.append(string);
        }

        return builder.toString();
    }

    public ClassGenerator parameters(Method method) {
        Class<?>[] types = method.getParameterTypes();

        for (int i = 0; i < types.length; i++) {
            Class<?> type = types[i];

            this.klass(type.getSimpleName()).klass(" ").klass(repeat('a', i + 1));

            Package pakkage = type.getPackage();

            if (pakkage != null && !pakkage.getName().equals("java.lang")) {
                this.imports(type.getName());
            }

            if (i != types.length - 1) {
                this.klass(", ");
            }
        }

        return this;
    }

    public ClassGenerator methodHandle(String klass, Method method) {
        this.klass("private static final MethodHandle ").klass(method.getName()).klass(" = Invoker.find");

        String type;

        if (Modifier.isStatic(method.getModifiers())) {
            type = "Static";
        } else if (Modifier.isPrivate(method.getModifiers())) {
            type = "Special";
        } else {
            type = "Virtual";
        }

        this.klass(type).klass("(").klass(klass).klass(", \"").klass(method.getName()).klass("\", ").klass(this.imports(method.getReturnType())).klass(".class");

        Class<?>[] types = method.getParameterTypes();

        for (int i = 0; i < types.length; i++) {
            this.klass(", ").klass(this.imports(types[i].getName())).klass(".class");
        }

        return this.klass(");").newLine();
    }

    @Override
    public String toString() {
        StringBuilder imports = new StringBuilder();

        for (String imbort : this.imports) {
            imports.append("import ").append(imbort).append(";\n");
        }

        return String.format("%s\n\n%s%s\n}", this.pakkage, imports, this.klass);
    }

    public void write() {
        try {
            new FileOutputStream(this.outputFile).write(this.toString().getBytes());
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }
    }

    public ClassGenerator newLine() {
        return this.klass("\n").klass(this.indentation);
    }

    public String imports(Class<?> klass) {
        return this.imports(klass.getName());
    }

    public String imports(String klass) {
        klass = klass.replace(";", "");

        int index = klass.indexOf('$');
        int end = index < 0 ? klass.length() : index;

        String imbort = klass.substring(0, end);

        if (imbort.contains("[")) {
            String newName = imbort.replace("[", "");

            imbort = newName + repeat("[]", imbort.length() - newName.length());
        }

        int lastDot = klass.lastIndexOf('.');

        return klass.substring(lastDot + 1);
    }

    public ClassGenerator klass(String string) {
        this.klass.append(string);

        return this;
    }

    public String getIndentation() {
        return this.indentation;
    }

    public ClassGenerator setIndentation(int indentation) {
        this.indentation = repeat(' ', indentation);

        return this;
    }
}
