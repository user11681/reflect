package user11681.reflect.generics;

public abstract class GenericTypeAware<T> {
    public final Class<T> type;

    @SafeVarargs
    protected GenericTypeAware(T... typeArray) {
        this.type = (Class<T>) typeArray.getClass().getComponentType();
    }
}
