package user11681.reflect.generator.base.type;

import java.util.stream.Stream;

public record TypeParameter(String name, BoundType boundType, Type bound) implements Type {
    public String declaration() {
        StringBuilder string = new StringBuilder(name);

        if (this.bound != null) {
            string.append(' ').append(this.boundType).append(' ').append(bound.toString());
        }

        return string.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.bound == null ? Stream.empty() : this.bound.referencedTypes();
    }
}
