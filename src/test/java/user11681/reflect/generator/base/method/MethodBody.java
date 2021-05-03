package user11681.reflect.generator.base.method;

import user11681.reflect.generator.base.MethodGenerator;

public class MethodBody extends Body {
    protected final MethodGenerator method;

    public MethodBody(MethodGenerator method) {
        this.method = method;
    }

    @Override
    public Body ret(Expression expression) {
        if (expression instanceof ExpressionStatement && this.method.returnType().equals(ConcreteType.voidType)) {
            return this.statement((ExpressionStatement) expression);
        }

        return super.ret(expression);
    }

    @Override
    public Variable variable(String name) {
        Variable variable = super.variable(name);

        return variable == null ? this.method.parameter(name) : variable;

    }
}
