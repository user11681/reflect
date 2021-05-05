package user11681.reflect.generator.base;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import user11681.reflect.Invoker;
import user11681.reflect.generator.base.method.Block;
import user11681.reflect.generator.base.method.MethodBlock;
import user11681.reflect.generator.base.method.Variable;
import user11681.reflect.generator.base.type.BoundType;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.type.Type;
import user11681.reflect.generator.base.type.TypeParameter;
import user11681.reflect.util.Util;

public class MethodBuilder extends MemberBuilder<MethodBuilder> {
    protected final Map<String, TypeParameter> typeParameters = new LinkedHashMap<>();
    protected final Map<String, Variable> parameters = new LinkedHashMap<>();

    protected Type returnType = ConcreteType.voidType;
    protected Block block;

    public MethodBuilder typeParameter(String name) {
        return this.typeParameter(name, null);
    }

    public MethodBuilder typeParameter(String name, Type bound) {
        return this.typeParameter(name, BoundType.EXTENDS, bound);
    }

    public MethodBuilder typeParameter(String name, BoundType boundType, Type bound) {
        if (this.typeParameters.put(name, new TypeParameter(name, boundType, bound)) != null) {
            throw new IllegalStateException("type parameter \"%s\" already exists".formatted(name));
        }

        return this;
    }

    public TypeParameter typeArgument(String name) {
        return this.typeParameters.get(name);
    }

    public MethodBuilder returnType(Type type) {
        this.returnType = Objects.requireNonNull(type);

        return this;
    }

    public MethodBuilder returnType(Class<?> type) {
        return this.returnType(new ConcreteType(type));
    }

    public MethodBuilder returnType(String type) {
        return this.returnType(Objects.requireNonNull(this.typeArgument(type), "type parameter \"%s\" does not exist".formatted(type)));
    }

    public MethodBuilder anyReturnType() {
        String name = "T";

        while (this.typeParameters.containsKey(name)) {
            name = String.valueOf(name.charAt(0) + 1);
        }

        return this.typeParameter(name).returnType(name);
    }

    public MethodBuilder parameter(Class<?> type, String name) {
        return this.parameter(new ConcreteType(type), name);
    }

    public MethodBuilder parameter(String type, String name) {
        return this.parameter(this.typeArgument(type), name);
    }

    public MethodBuilder parameter(Type type, String name) {
        if (this.parameters.put(name, new Variable(type, name)) != null && name != null) {
            throw new IllegalStateException("parameter \"%s\" already exists".formatted(name));
        }

        return this;
    }

    public MethodBuilder parameter(Class<?>... types) {
        for (Class<?> type : types) {
            this.parameter(type, null);
        }

        return this;
    }

    public MethodBuilder inherit(Method method) {
        for (Parameter parameter : method.getParameters()) {
            this.parameter(parameter.getType(), parameter.getName());
        }

        return this.returnType(method.getReturnType()).access(method.getModifiers());
    }

    public MethodBuilder inherit(MethodHandle handle) {
        return this.inherit(Invoker.method(handle));
    }

    public MethodBuilder inherit(MethodType type) {
        return this.returnType(type.returnType()).parameter(type.parameterArray());
    }

    public MethodBuilder body(Consumer<Block> generator) {
        Block block = this.block == null ? this.block = new MethodBlock(this) : this.block;
        generator.accept(block);

        return this;
    }

    public Type returnType() {
        return this.returnType;
    }

    public Variable parameter(String name) {
        return this.parameters.get(name);
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Util.join(this.typeParameters.values().stream(), this.parameters.values().stream(), Stream.of(this.returnType, this.block)).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(Modifier.toString(this.access)).append(' ');

        if (!this.typeParameters.isEmpty()) {
            string.append(this.typeParameters.values().stream().map(TypeParameter::declaration).collect(Collectors.joining(", ", "<", "> ")));
        }

        string.append(this.returnType)
            .append(' ').append(this.name)
            .append(this.parameters.values().stream().map(Variable::declaration).collect(Collectors.joining(", ", "(", ") ")))
            .append(this.block.toString());

        return string.toString();
    }
}
