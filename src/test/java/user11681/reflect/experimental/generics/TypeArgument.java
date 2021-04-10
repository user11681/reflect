package user11681.reflect.experimental.generics;

public class TypeArgument {
    public final Class<?> declaringClass;
    public final Class<?> type;
    public final String name;
    public final int index;

    public TypeArgument(Class<?> declaringClass, Class<?> type, String name, int index) {
        this.declaringClass = declaringClass;
        this.type = type;
        this.name = name;
        this.index = index;
    }
}
