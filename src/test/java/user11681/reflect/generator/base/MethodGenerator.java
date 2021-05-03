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
import user11681.reflect.Invoker;
import user11681.reflect.generator.base.method.Block;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.method.MethodBlock;
import user11681.reflect.generator.base.method.Variable;
import user11681.reflect.generator.base.type.BoundType;
import user11681.reflect.generator.base.type.Type;
import user11681.reflect.generator.base.type.TypeParameter;

public class MethodGenerator extends MemberGenerator<MethodGenerator> {
    protected final Map<String, TypeParameter> typeParameters = new LinkedHashMap<>();
    protected final Map<String, Variable> parameters = new LinkedHashMap<>();

    protected Type returnType = new ConcreteType(void.class);
    protected Block block;

    public MethodGenerator typeParameter(String name) {
        return this.typeParameter(name, null);
    }

    public MethodGenerator typeParameter(String name, Class<?> bound) {
        return this.typeParameter(name, BoundType.EXTENDS, bound);
    }

    public MethodGenerator typeParameter(String name, BoundType boundType, Class<?> bound) {
        if (this.typeParameters.put(name, new TypeParameter(name, boundType, bound)) != null) {
            throw new IllegalStateException("type parameter \"%s\" already exists".formatted(name));
        }

        return this;
    }

    public TypeParameter typeArgument(String name) {
        return this.typeParameters.get(name);
    }

    public MethodGenerator returnType(Type type) {
        this.returnType = Objects.requireNonNull(type);

        return this;
    }

    public MethodGenerator returnType(Class<?> type) {
        return this.returnType(new ConcreteType(type));
    }

    public MethodGenerator returnType(String type) {
        return this.returnType(Objects.requireNonNull(this.typeArgument(type), "type parameter \"%s\" does not exist".formatted(type)));
    }

    public MethodGenerator anyReturnType() {
        String name = "T";

        while (this.typeParameters.containsKey(name)) {
            name = String.valueOf(name.charAt(0) + 1);
        }

        return this.typeParameter(name).returnType(name);
    }

    public MethodGenerator parameter(Class<?> type, String name) {
        return this.parameter(new ConcreteType(type), name);
    }

    public MethodGenerator parameter(String type, String name) {
        return this.parameter(this.typeArgument(type), name);
    }

    public MethodGenerator parameter(Type type, String name) {
        if (this.parameters.put(name, new Variable(type, name)) != null && name != null) {
            throw new IllegalStateException("parameter \"%s\" already exists".formatted(name));
        }

        return this;
    }

    public MethodGenerator parameter(Class<?>... types) {
        for (Class<?> type : types) {
            this.parameter(type, null);
        }

        return this;
    }

    public MethodGenerator inherit(Method method) {
        for (Parameter parameter : method.getParameters()) {
            this.parameter(parameter.getType(), parameter.getName());
        }

        return this.returnType(method.getReturnType()).access(method.getModifiers());
    }

    public MethodGenerator inherit(MethodHandle handle) {
        return this.inherit(Invoker.method(handle));
    }

    public MethodGenerator inherit(MethodType type) {
        return this.returnType(type.returnType()).parameter(type.parameterArray());
    }

    public MethodGenerator body(Consumer<Block> generator) {
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
    public String toString() {
        StringBuilder string = new StringBuilder(Modifier.toString(this.access)).append(' ');

        if (!this.typeParameters.isEmpty()) {
            string.append(this.typeParameters.values().stream().map(TypeParameter::toString).collect(Collectors.joining(", ", "<", "> ")));
        }

        string.append(this.returnType.simpleName())
            .append(' ').append(this.name)
            .append(this.parameters.values().stream().map(Variable::declaration).collect(Collectors.joining(", ", "(", ") ")))
            .append(this.block.toString());

        return string.toString();
    }
}
