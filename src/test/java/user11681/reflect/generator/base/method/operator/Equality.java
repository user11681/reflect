package user11681.reflect.generator.base.method.operator;

import user11681.reflect.generator.base.method.Expression;

public class Equality implements Expression {
    protected Expression left;
    protected Expression right;

    public Equality() {}

    public Equality(Expression left, Expression right) {
        this.left(left).right(right);
    }

    public Equality left(Expression left) {
        this.left = left;

        return this;
    }

    public Equality right(Expression right) {
        this.right = right;

        return this;
    }

    @Override
    public String toString() {
        return "%s == %s".formatted(this.left, this.right);
    }
}
