package user11681.reflect.generator.base;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import user11681.uncheck.Uncheck;

public class ClassGenerator extends MemberGenerator<ClassGenerator> {
    public final String pakage;

    protected final StringBuilder string = new StringBuilder();
    protected final Map<String, String> unqualifiedNames = new HashMap<>();
    protected final Set<String> imports = new HashSet<>();
    protected final List<FieldGenerator> fields = new ArrayList<>();
    protected final List<MethodGenerator> methods = new ArrayList<>();

    protected String indentation = "";
    protected int depth;

    public ClassGenerator(Class<?> klass) {
        this(klass.getPackageName(), klass.getSimpleName());
    }

    public ClassGenerator(String name) {
        this(name.substring(0, name.lastIndexOf('.')), name.substring(name.lastIndexOf('.') + 1));
    }

    public ClassGenerator(String pakage, String name) {
        this.pakage = pakage;
        this.name = name;
    }

    private static String repeat(char character, int times) {
        return String.valueOf(character).repeat(times);
    }

    public ClassGenerator field(Consumer<FieldGenerator> generator) {
        FieldGenerator field = new FieldGenerator();
        generator.accept(field);

        this.fields.add(field);

        return this;
    }

    public ClassGenerator method(Consumer<MethodGenerator> generator) {
        MethodGenerator method = new MethodGenerator();
        generator.accept(method);

        this.methods.add(method);

        return this;
    }

    public ClassGenerator parameters(Method method) {
        Class<?>[] types = method.getParameterTypes();

        for (int i = 0; i < types.length; i++) {
            Class<?> type = types[i];

            this.append(type.getSimpleName()).append(" ").append(repeat('a', i + 1));

            Package pakkage = type.getPackage();

            if (pakkage != null && !pakkage.getName().equals("java.lang")) {
                this.imports(type.getName());
            }

            if (i != types.length - 1) {
                this.append(", ");
            }
        }

        return this;
    }

    public ClassGenerator methodHandle(String klass, Method method) {
        this.append("private static final MethodHandle ").append(method.getName()).append(" = Invoker.find");

        String type;

        if (Modifier.isStatic(method.getModifiers())) {
            type = "Static";
        } else if (Modifier.isPrivate(method.getModifiers())) {
            type = "Special";
        } else {
            type = "Virtual";
        }

        this.append("%s(%s, \"%s\", %s.class", type, klass, method.getName(), this.imports(method.getReturnType()));

        Class<?>[] types = method.getParameterTypes();

        for (int i = 0; i < types.length; i++) {
            this.append(", ").append(this.imports(types[i])).append(".class");
        }

        return this.append(");").newline();
    }

    public String imports(Class<?> klass) {
        return this.imports(klass.getName());
    }

    public String imports(String klass) {
        return this.unqualifiedNames.computeIfAbsent(klass, (String klass2) -> {
            String imbort = klass.replace("[", "");
            int dimensions = imbort.length() - klass.length();
            int nestIndex = imbort.indexOf('$');

            if (nestIndex > 0) {
                imbort = imbort.substring(0, nestIndex);
            }

            this.imports.add(imbort.replace('$', '.'));

            return klass.substring(klass.lastIndexOf('.') + 1).replace('$', '.') + "[]".repeat(dimensions);
        });
    }

    public ClassGenerator newline() {
        return this.append("\n").append(this.indentation.repeat(this.depth));
    }

    public ClassGenerator append(String format, Object... arguments) {
        this.string.append(format.formatted(arguments));

        return this;
    }

    public void write(OutputStream output) {
        Uncheck.handle(() -> output.write(this.toString().getBytes()));
    }

    public void write(String file) {
        Uncheck.handle(() -> this.write(new FileOutputStream(file)));
    }

    @Override
    public String toString() {
        IndentingStringBuilder string = new IndentingStringBuilder();
        string.append("package ").append(this.pakage).append(';').newline().newline();
        string.append(this.imports.stream().map(imbort -> "import " + imbort + ";\n").collect(Collectors.joining())).newline();
        string.append(Modifier.toString(this.access)).append(' ').append("class ").append(this.name).append(" {").descend().newline();

        string.append(this.fields.stream()
            .map(FieldGenerator::toString)
            .collect(Collectors.joining(string.newlineString()))
        );

        string.append(this.methods.stream()
            .map(MethodGenerator::toString)
            .map(method -> method.lines().collect(Collectors.joining(string.newlineString(), "", "\n")))
            .collect(Collectors.joining(string.newlineString()))
        );

        return string.ascend().append('}').toString();
    }
}
