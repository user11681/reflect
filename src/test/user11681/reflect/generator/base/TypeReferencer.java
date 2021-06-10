package user11681.reflect.generator.base;

import java.util.stream.Stream;
import user11681.reflect.generator.base.type.ConcreteType;

public interface TypeReferencer {
    default Stream<ConcreteType> referencedTypes() {
        return Stream.empty();
    }
}
