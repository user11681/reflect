package user11681.reflect.generator.base.method.expression;

public interface Literal extends Expression {
    static StringLiteral of(String string) {
        return new StringLiteral(string);
    }

    static TypeLiteral of(Class<?> type) {
        return new TypeLiteral(type);
    }

    static NullLiteral nul() {
        return NullLiteral.instance;
    }
}
