package user11681.reflect.generator.base.method.expression.literal;

public record LongLiteral(long value) implements Literal {
    @Override
    public String toString() {
        return String.valueOf(this.value) + 'L';
    }
}
