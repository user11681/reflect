package user11681.reflect.generator.base;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import user11681.reflect.generator.base.method.expression.literal.Literal;
import user11681.reflect.generator.base.method.expression.literal.TypeLiteral;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.uncheck.Uncheck;

public class ClassBuilder extends MemberBuilder<ClassBuilder> {
    public final String pakage;

    protected final StringBuilder string = new StringBuilder();
    protected final Map<String, TypeLiteral> unqualifiedNames = new HashMap<>();
    protected final Set<String> imports = new HashSet<>();
    protected final List<FieldBuilder> fields = new ArrayList<>();
    protected final List<MethodBuilder> methods = new ArrayList<>();
    protected final List<MemberBuilder<?>> members = new ArrayList<>();
    protected final List<MethodBuilder> clinit = new ArrayList<>();

    protected String indentation = "";
    protected int depth;

    public ClassBuilder(Class<?> klass) {
        this(klass.getPackageName(), klass.getSimpleName());
    }

    public ClassBuilder(String name) {
        int packageEnd = name.lastIndexOf('.');

        this.pakage = packageEnd == -1 ? "" : name.substring(0, packageEnd);
        this.name = name.substring(packageEnd + 1);
    }

    public ClassBuilder(String pakage, String name) {
        this.pakage = pakage;
        this.name = name;
    }

    public ClassBuilder member(MemberBuilder<?> member) {
        this.members.add(member);

        return this;
    }

    public ClassBuilder field(Consumer<FieldBuilder> generator) {
        FieldBuilder field = new FieldBuilder();
        generator.accept(field);

        this.fields.add(field);

        return this;
    }

    public ClassBuilder method(Consumer<MethodBuilder> generator) {
        MethodBuilder method = new MethodBuilder();
        generator.accept(method);

        this.methods.add(method);

        return this;
    }

    public ClassBuilder clinit(Consumer<MethodBuilder> generator) {
        MethodBuilder clinit = new MethodBuilder();
        generator.accept(clinit);

        this.clinit.add(clinit);

        return this;
    }

    public void write(OutputStream output) {
        Uncheck.handle(() -> output.write(this.toString().getBytes()));
    }

    public void write(String file) {
        Uncheck.handle(() -> this.write(new FileOutputStream(file)));
    }

    protected TypeLiteral imports(ConcreteType type) {
        return this.imports(type.type());
    }

    protected TypeLiteral imports(Class<?> type) {
        if (type.isPrimitive() || type.getPackageName().equals("java.lang")) {
            return Literal.of(type);
        }

        return this.unqualifiedNames.computeIfAbsent(type.getName(), name -> {
            name = name.replace("[", "");

            if (name.charAt(name.length() - 1) == ';') {
                name = name.substring(1, name.length() - 1);
            }

            int nestIndex = name.indexOf('$');
            this.imports.add((nestIndex > 0 ? name.substring(0, nestIndex) : name).replace('$', '.'));

            return Literal.of(type);
        });
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.concat(this.fields.stream(), this.methods.stream()).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        IndentingStringBuilder string = new IndentingStringBuilder();

        if (!this.pakage.isEmpty()) {
            string.append("package ").append(this.pakage).append(';').newline().newline();
        }

        string.append(this.referencedTypes().map(this::imports).map(type -> "import " + type + ";\n").collect(Collectors.joining())).newline();
        string.append(this.offsetAccessString()).append("class ").append(this.name).append(" {").descend().newline();

        string.append(this.fields.stream()
            .map(FieldBuilder::toString)
            .collect(Collectors.joining(string.newlineString()))
        );

        string.append(this.methods.stream()
            .map(MethodBuilder::toString)
            .map(method -> method.lines().collect(Collectors.joining(string.newlineString(), "", "\n")))
            .collect(Collectors.joining(string.newlineString()))
        );

        return string.ascend().newline().append('}').toString();
    }
}
