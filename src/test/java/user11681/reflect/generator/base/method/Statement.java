package user11681.reflect.generator.base.method;

import java.util.stream.Stream;

public interface Statement {
    default Stream<String> lines() {
        return this.toString().lines();
    }
}
