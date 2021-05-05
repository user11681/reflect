package user11681.reflect.generator.base.method.expression;

public record StringLiteral(String string) implements Expression, Literal {
    @Override
    public String toString() {
        return '"' + this.string + '"';
    }
}
