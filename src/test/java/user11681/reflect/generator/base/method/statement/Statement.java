package user11681.reflect.generator.base.method.statement;

import java.util.stream.Stream;
import user11681.reflect.generator.base.TypeReferencer;

public interface Statement extends TypeReferencer {
    default Stream<String> lines() {
        return this.toString().lines();
    }
}
