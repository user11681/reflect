package user11681.reflect.generator.base.method;

import user11681.reflect.generator.base.MethodGenerator;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.expression.StatementExpression;
import user11681.reflect.generator.base.type.ConcreteType;

public class MethodBlock extends Block {
    protected final MethodGenerator method;

    public MethodBlock(MethodGenerator method) {
        this.method = method;
    }

    @Override
    public Block ret(Expression expression) {
        if (expression instanceof StatementExpression && this.method.returnType().equals(ConcreteType.voidType)) {
            return this.statement((StatementExpression) expression);
        }

        return super.ret(expression);
    }

    @Override
    public Variable variable(String name) {
        Variable variable = super.variable(name);

        return variable == null ? this.method.parameter(name) : variable;

    }
}
