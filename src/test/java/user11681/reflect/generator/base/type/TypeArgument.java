package user11681.reflect.generator.base.type;

public class TypeArgument {
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
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (this.bound == null) {
            return "?";
        }

        if (this.type != null) {
            string.append('?').append(this.type).append(' ');
        }

        string.append(this.bound.simpleName());

        return string.toString();
    }
}
