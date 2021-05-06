package user11681.reflect.generator.base.method.expression.literal;

public record DoubleLiteral(double value) implements Literal {
    public DoubleLiteral {
        if (Double.isInfinite(value)) {
            throw new IllegalArgumentException("double literal cannot be infinity");
        }

        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("double literal cannot be NaN");
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder().append(this.value);

        if (this.value % 1 != 0) {
            string.append('D');
        }

        return string.toString();
    }
}
