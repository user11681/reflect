package user11681.reflect.generator.base.method;

public record InvocationStatement(Invocation invocation) implements Statement {
    @Override
    public String toString() {
        return this.invocation.toString() + ';';
    }
}
