package user11681.reflect.generator.base.method.expression;

public class NullLiteral implements Expression, Literal {
    public static final NullLiteral instance = new NullLiteral();

    private NullLiteral() {}

    @Override
    public String toString() {
        return "null";
    }
}
