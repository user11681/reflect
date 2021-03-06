package user11681.reflect.generator;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import user11681.reflect.Accessor;
import user11681.reflect.Fields;
import user11681.reflect.generator.base.method.Block;
import user11681.reflect.generator.base.method.expression.Expression;
import user11681.reflect.generator.base.method.expression.Invocation;
import user11681.reflect.generator.base.method.expression.literal.Literal;
import user11681.reflect.generator.base.method.statement.EnhancedFor;
import user11681.reflect.generator.base.method.statement.If;
import user11681.reflect.generator.base.type.ConcreteType;
import user11681.reflect.generator.base.type.ParameterizedType;

@Execution(ExecutionMode.SAME_THREAD)
class AccessorBuilder extends TestBuilder {
    static final Class<?>[] fieldTypes = {Field.class, String.class};

    static final Map<Class<?>, String> fieldDiscriminators = map(
        String.class, "fieldName",
        Field.class, "field",
        long.class, "offset"
    );

    static final Map<Class<?>, String> ownerTypes = map(
        Object.class, "objectFieldOffset",
        Class.class, "staticFieldOffset"
    );

    static final String[] suffixes = {"", "Volatile"};

    static final Class<?>[] types = {
        boolean.class,
        byte.class,
        char.class,
        short.class,
        int.class,
        long.class,
        float.class,
        double.class,
        Object.class
    };

    static final Map<Class<?>, Class<?>> typesWithNull = map(
        boolean.class, boolean.class,
        byte.class, byte.class,
        char.class, char.class,
        short.class, short.class,
        int.class, int.class,
        long.class, long.class,
        float.class, float.class,
        double.class, double.class,
        Object.class, Object.class,
        null, Object.class
    );

    public AccessorBuilder() {
        super("user11681.reflect", "Accessor");

        this.pub();
    }

    static <K, V> HashMap<K, V> map(Object... elements) {
        HashMap<K, V> map = new LinkedHashMap<>();

        assert (elements.length & 1) == 0;

        for (int i = 0; i < elements.length; i += 2) {
            map.put((K) elements[i], (V) elements[i + 1]);
        }

        return map;
    }

    static String name(Class<?> type) {
        if (type == null) {
            return "";
        }

        String simpleName = type.getSimpleName();

        return simpleName.substring(0, 1).toUpperCase() + simpleName.substring(1);
    }

    @Override
    @Test
    protected void all() throws Throwable {
        super.all();
    }

    @Test
    void field() {
        for (String suffix : suffixes) {
            for (Class<?> type : typesWithNull.keySet()) {
                Class<?> actualType = typesWithNull.get(type);

                for (Access access : Access.values()) {
                    this.method(method -> {
                        method.pub().statik().name(access + name(type) + suffix).parameter(Field.class, "field");

                        access.get(() -> method.returnType(actualType));
                        access.put(() -> method.parameter(actualType, "value"));

                        method.body(block -> {
                            Invocation unsafeMethod;
                            Invocation offset = new Invocation(Unsafe.class, "staticFieldOffset", block.var("field"));
                            Invocation delcaringClass = block.var("field").invoke("getDeclaringClass");

                            unsafeMethod = type == null
                                ? new Invocation(access.toString(), delcaringClass, block.var("field").invoke("getType"), offset)
                                : new Invocation(Unsafe.class, method.name(), delcaringClass, offset);

                            access.put(() -> unsafeMethod.argument(block.var("value")));

                            block.ret(unsafeMethod);
                        });
                    });
                }
            }
        }
    }

    @Test
    void objectStringAndObjectField() {
        for (String suffix : suffixes) {
            for (Class<?> type : typesWithNull.keySet()) {
                Class<?> actualType = typesWithNull.get(type);

                for (Class<?> objectType : ownerTypes.keySet()) {
                    for (Class<?> fieldType : fieldTypes) {
                        if (objectType != Class.class || fieldType != Field.class) {
                            for (Access access : Access.values()) {
                                this.method(method -> {
                                    method.pub().statik().name(access + name(type) + suffix);

                                    access.get(() -> {
                                        if (type == Object.class) {
                                            method.anyReturnType();
                                        } else method.returnType(actualType);
                                    });

                                    String objectName = objectType == Class.class ? "type" : "object";
                                    method.parameter(objectType == Class.class ? ParameterizedType.wildcard(Class.class) : new ConcreteType(objectType), objectName)
                                        .parameter(fieldType, "fieldName");

                                    access.put(() -> method.parameter(actualType, "value"));

                                    method.body(block -> {
                                        Expression field = fieldType == Field.class ? block.var("fieldName") : new Invocation(Fields.class, "field",
                                            block.var(objectName),
                                            block.var("fieldName")
                                        );

                                        if (type == null && fieldType == String.class) {
                                            block.var(Field.class, "field", field).newline();
                                            field = block.var("field");
                                        }

                                        Invocation offset = new Invocation(Unsafe.class, objectType == Class.class ? "staticFieldOffset" : "objectFieldOffset", field);
                                        Invocation unsafeMethod = type == null
                                            ? new Invocation(access.toString(), block.var(objectName), field.invoke("getType"), offset)
                                            : new Invocation(Unsafe.class, method.name(), block.var(objectName), offset);

                                        access.put(() -> unsafeMethod.argument(block.var("value")));

                                        block.ret(unsafeMethod);
                                    });
                                });
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    void objectClassStringAndObjectClassField() {
        for (String suffix : suffixes) {
            for (Class<?> type : typesWithNull.keySet()) {
                Class<?> actualType = typesWithNull.get(type);

                for (Class<?> fieldType : fieldTypes) {
                    for (Access access : Access.values()) {
                        this.method(method -> {
                            method.pub().statik();

                            access.get(() -> {
                                if (type == Object.class) {
                                    method.anyReturnType();
                                } else method.returnType(actualType);
                            });

                            method.name(access + name(type) + suffix)
                                .parameter(Object.class, "object")
                                .parameter(ParameterizedType.wildcard(Class.class), "type")
                                .parameter(fieldType, "fieldName");

                            access.put(() -> method.parameter(actualType, "value"));

                            method.body(block -> {
                                Expression field = fieldType == Field.class ? block.var("fieldName") : new Invocation(Fields.class, "field",
                                    block.var("type"),
                                    block.var("fieldName")
                                );

                                if (type == null && fieldType == String.class) {
                                    block.var(Field.class, "field", field).newline();
                                    field = block.var("field");
                                }

                                Invocation offset = new Invocation(Unsafe.class, "objectFieldOffset", field);
                                Invocation unsafeMethod = type == null
                                    ? new Invocation(access.toString(), block.var("object"), field.invoke("getType"), offset)
                                    : new Invocation(Unsafe.class, method.name(), block.var("object"), offset);

                                if (access.put()) {
                                    unsafeMethod.argument(block.var("value"));
                                }

                                block.ret(unsafeMethod);
                            });
                        });
                    }
                }
            }
        }
    }

    @Test
    void getPut() {
        for (String suffix : suffixes) {
            for (Access access : Access.values()) {
                this.method(method -> {
                    method.pub().statik().name(access.toString() + suffix);

                    if (access.get()) {
                        method.returnType(Object.class);
                    }

                    method.parameter(Object.class, "object").parameter(ParameterizedType.wildcard(Class.class), "type").parameter(long.class, "offset");

                    if (access.put()) {
                        method.parameter(Object.class, "value");
                    }

                    method.body(block -> {
                        If ifStatement = new If();
                        Invocation unsafeMethod = new Invocation(Unsafe.class, block.var("object"), block.var("offset"));

                        block.statement(ifStatement);

                        for (int i = 0; i < types.length; i++) {
                            Class<?> type = types[i];

                            if (type != Object.class) {
                                Invocation put = unsafeMethod.copy().name(access + name(type) + suffix);
                                access.put(() -> put.argument(block.var("value").cast(type)));

                                if (i != 0) {
                                    ifStatement.otherwise(ifStatement = new If());
                                }

                                Block then = new Block();
                                ifStatement.same(block.var("type"), Literal.of(type)).then(access.put() ? then.statement(put) : then.ret(put));
                            }
                        }

                        unsafeMethod.name(access + "Object" + suffix);
                        access.put(ifStatement, if1 -> if1.otherwise(unsafeMethod.argument(block.var("value")).statement())).fail(() -> block.newline().ret(unsafeMethod));
                    });
                });
            }
        }
    }

    @Test
    void copy() {
        for (String suffix : suffixes) {
            for (Class<?> type : typesWithNull.keySet()) {
                Class<?> actualType = typesWithNull.get(type);

                for (Class<?> ownerType : ownerTypes.keySet()) {
                    for (Class<?> discriminator : fieldDiscriminators.keySet()) {
                        if (type != null || discriminator != long.class) {
                            String methodName = name(type) + suffix;

                            this.method(method -> {
                                method.pub().statik().name("copy" + methodName);

                                if (ownerType == Object.class) {
                                    method.typeParameter("T").parameter("T", "to").parameter("T", "from");
                                } else {
                                    ParameterizedType classWildcard = ParameterizedType.wildcard(Class.class);

                                    method.parameter(classWildcard, "to").parameter(classWildcard, "from");
                                }

                                method.parameter(discriminator, fieldDiscriminators.get(discriminator)).body(block -> {
                                    if (discriminator != long.class) {
                                        Invocation offsetMethod = new Invocation(Unsafe.class, ownerType == Class.class ? "staticFieldOffset" : "objectFieldOffset");

                                        block.var(variable -> {
                                            variable.type(long.class).name("offset");

                                            if (discriminator == String.class) {
                                                Expression field = new Invocation(Fields.class, "field",
                                                    block.var("to"),
                                                    block.var("fieldName")
                                                );

                                                if (type == null) {
                                                    block.var(Field.class, "field", field);
                                                    field = block.var("field");
                                                }

                                                variable.initialize(offsetMethod.copy().argument(field));
                                            } else variable.initialize(offsetMethod.argument(block.var("field")));
                                        });

                                        block.newline();
                                    }

                                    Invocation unsafeMethod;

                                    if (type == null) {
                                        unsafeMethod = new Invocation("put" + suffix,
                                            block.var("to"),
                                            block.var("field").invoke("getType"),
                                            block.var("offset"),
                                            new Invocation("get" + suffix,
                                                block.var("from"),
                                                block.var("field").invoke("getType"),
                                                block.var("offset")
                                            )
                                        );
                                    } else unsafeMethod = new Invocation(Unsafe.class, "put" + methodName,
                                        block.var("to"),
                                        block.var("offset"),
                                        new Invocation(Unsafe.class, "get" + methodName,
                                            block.var("from"),
                                            block.var("offset")
                                        )
                                    );

                                    block.statement(unsafeMethod);
                                });
                            });
                        }
                    }
                }
            }
        }
    }

    @Test
    void cone() {
        this.method(method -> method.pub().statik()
            .name("clone")
            .typeParameter("T")
            .returnType("T")
            .parameter("T", "object")
            .body(block -> block.statement(new If().nul(block.var("object")).then(new Block().ret(Literal.nul)))
                .newline()
                .var(method.typeArgument("T"), "clone", new Invocation(Unsafe.class, "allocateInstance", block.var("object").invoke("getClass")).cast(method.typeArgument("T")))
                .newline()
                .statement(new EnhancedFor()
                    .var(Field.class, "field")
                    .iterable(new Invocation(Fields.class, "allInstanceFields", block.var("object")))
                    .action(field -> Block.wrap(new Invocation(Accessor.class, "copy", block.var("clone"), block.var("object"), field))))
                .newline()
                .ret(block.var("clone"))
            )
        );
    }

    @Test
    void offset() {
        for (String methodType : new String[]{"static", "object"}) {
            this.method(method -> method.pub().statik().returnType(long.class).name(methodType + "FieldOffset")
                .parameter(ParameterizedType.wildcard(Class.class), "type")
                .parameter(String.class, "name")
                .body(block -> block.ret(new Invocation(Unsafe.class, method.name(),
                    new Invocation(Fields.class, "field",
                        block.var("type"),
                        block.var("name")
                    )
                )))
            );
        }
    }

    @Override
    @AfterEach
    protected void tearDown() {
        super.tearDown();
    }
}
