package user11681.reflect.generator.base.type;

import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;

public class TypeArgument implements TypeReferencer {
    public static final TypeArgument wildcard = new TypeArgument();

    protected final Type bound;
    protected final BoundType type;

    private TypeArgument() {
        this.bound = null;
        this.type = null;
    }

    public TypeArgument(Type bound, BoundType type) {
        if (bound == null) {
            throw new IllegalArgumentException("use TypeArgument.wildcard");
        }

        this.bound = bound;
        this.type = type;
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return this.bound == null ? Stream.empty() : this.bound.referencedTypes();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (this.bound == null) {
            return "?";
        }

        if (this.type != null) {
            string.append('?').append(this.type).append(' ');
        }

        string.append(this.bound.toString());

        return string.toString();
    }
}
