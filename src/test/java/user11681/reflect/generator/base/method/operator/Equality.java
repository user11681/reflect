package user11681.reflect.generator.base.method.operator;

import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.expression.literal.Literal;
import user11681.reflect.generator.base.type.ConcreteType;

public class Equality implements Expression {
    protected Expression left;
    protected Expression right;

    public Equality() {}

    public Equality(Expression left, Expression right) {
        this.left(left).right(right);
    }

    public static Equality nul(Expression expression) {
        return new Equality().left(expression).right(Literal.nul);
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
    public Stream<ConcreteType> referencedTypes() {
        return Stream.of(this.left, this.right).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        return "%s == %s".formatted(this.left, this.right);
    }
}
