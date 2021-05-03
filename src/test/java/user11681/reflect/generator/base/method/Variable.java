package user11681.reflect.generator.base.method;

import java.util.Objects;
import user11681.reflect.generator.base.type.Type;

public record Variable(Type type, String name) implements Expression {
    public LoadVariable load() {
        return new LoadVariable(this);
    }

    public StoreVariable store(Expression expression) {
        return new StoreVariable(this, expression);
    }

    public String declaration() {
        return "%s %s".formatted(this.type.simpleName(), this.name);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Variable variable) {
            return Objects.equals(this.type, variable.type) && Objects.equals(this.name, variable.name);
        }

        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
