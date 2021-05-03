package user11681.reflect.generator.base.method;

public record ReturnStatement(Expression expression) implements Statement {
    @Override
    public String toString() {
        return "return " + this.expression + ';';
    }
}
