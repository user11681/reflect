package user11681.reflect.generator.base.method.expression.literal;

public record FloatLiteral(float value) implements Literal {
    public FloatLiteral {
        if (Float.isInfinite(value)) {
            throw new IllegalArgumentException("float literal cannot be infinity");
        }

        if (Float.isNaN(value)) {
            throw new IllegalArgumentException("float literal cannot be NaN");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.value) + 'F';
    }
}
