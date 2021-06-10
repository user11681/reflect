package user11681.reflect.generator.base.type;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;

public record ParameterizedType(ConcreteType type, TypeArgument... typeArguments) implements Type {
    public ParameterizedType {
        if (typeArguments.length == 0) {
            throw new IllegalArgumentException("parameterized type must have type arguments");
        }
    }

    public ParameterizedType(Class<?> type, TypeArgument... typeArguments) {
        this(new ConcreteType(type), typeArguments);
    }

    public ParameterizedType(Class<?> type, Type... typeArguments) {
        this(type, Stream.of(typeArguments).map(arg -> new TypeArgument(arg, null)).toArray(TypeArgument[]::new));
    }

    public static ParameterizedType wildcard(Class<?> type) {
        TypeArgument[] arguments = new TypeArgument[type.getTypeParameters().length];
        Arrays.fill(arguments, TypeArgument.wildcard);

        return new ParameterizedType(type, arguments);
    }

    @Override
    public String toString() {
        return this.type + Stream.of(this.typeArguments).map(TypeArgument::toString).collect(Collectors.joining(", ", "<", ">"));
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.concat(Stream.of(this.type), Stream.of(this.typeArguments).flatMap(TypeReferencer::referencedTypes));
    }
}
