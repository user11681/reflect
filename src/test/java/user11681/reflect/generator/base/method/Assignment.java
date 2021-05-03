package user11681.reflect.generator.base.method;

public record Assignment(StoreVariable variable) implements Statement {
    @Override
    public String toString() {
        return this.variable.toString() + ';';
    }
}
