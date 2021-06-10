package user11681.reflect.generator.base.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.expression.StatementExpression;
import user11681.reflect.generator.base.method.statement.EmptyStatement;
import user11681.reflect.generator.base.method.statement.Return;
import user11681.reflect.generator.base.method.statement.Statement;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.type.Type;

public class Block implements Statement {
    protected List<Statement> statements = new ArrayList<>();
    protected Map<String, Variable> variables = new HashMap<>();

    public static Block wrap(Statement statement) {
        return new Block().statement(statement);
    }

    public static Block wrap(StatementExpression statement) {
        return new Block().statement(statement);
    }

    public Block statement(Statement statement) {
        this.statements.add(statement);

        return this;
    }

    public Block statement(StatementExpression statement) {
        return this.statement(statement.statement());
    }

    public Block ret(Expression expression) {
        return this.statement(new Return(expression));
    }

    public Block newline() {
        this.statements.add(new EmptyStatement());

        return this;
    }

    public Block var(Class<?> type, String name, Expression initializer) {
        return this.var(new ConcreteType(type), name, initializer);
    }

    public Block var(Type type, String name, Expression initializer) {
        return this.var(variable -> variable.type(type).name(name).initialize(initializer));
    }

    public Block var(Consumer<VariableDeclaration> consumer) {
        VariableDeclaration declaration = new VariableDeclaration();
        consumer.accept(declaration);

        if (this.var(declaration.name) != null) {
            throw new IllegalStateException("variable \"%s\" already exists".formatted(declaration.name));
        }

        this.variables.put(declaration.name, declaration.variable());
        this.statements.add(declaration);

        return this;
    }

    public Variable var(String name) {
        return this.variables.get(name);
    }

    @Override
    public Stream<ConcreteType> referencedTypes() {
        return Stream.concat(this.statements.stream(), this.variables.values().stream()).flatMap(TypeReferencer::referencedTypes);
    }

    @Override
    public String toString() {
        if (this.statements.isEmpty()) {
            return "{}";
        }

        return this.statements.stream().flatMap(Statement::lines).map(line -> "\n    " + line).collect(Collectors.joining("", "{", "\n}"));
    }
}
