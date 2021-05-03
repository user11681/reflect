package user11681.reflect.generator.base.method.statement;

import java.util.stream.Stream;

public class EmptyStatement implements Statement {
    @Override
    public Stream<String> lines() {
        return Stream.of("");
    }

    @Override
    public String toString() {
        return "";
    }
}
