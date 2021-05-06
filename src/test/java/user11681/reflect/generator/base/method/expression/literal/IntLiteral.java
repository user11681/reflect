package user11681.reflect.generator.base.method.expression.literal;

public record IntLiteral(int value) implements Literal {
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
