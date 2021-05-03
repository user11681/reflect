package user11681.reflect.generator.base.method;

public record StoreVariable(Variable variable, Expression expression) implements ExpressionStatement {
    @Override
    public String toString() {
        return "%s = %s".formatted(this.variable.name(), this.expression);
    }

    @Override
    public Statement statement() {
        return new Assignment(this);
    }
}
