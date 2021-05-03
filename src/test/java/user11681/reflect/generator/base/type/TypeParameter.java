package user11681.reflect.generator.base.type;

public record TypeParameter(String name, BoundType boundType, Class<?> bound) implements Type {
    @Override
    public String simpleName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(name);

        if (this.bound != null) {
            string.append(' ').append(this.boundType).append(' ').append(bound.getSimpleName());
        }

        return string.toString();
    }
}
