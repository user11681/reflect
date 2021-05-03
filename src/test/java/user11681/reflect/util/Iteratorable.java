package user11681.reflect.util;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.jetbrains.annotations.NotNull;

public class Iteratorable<T> implements Iterator<T>, Iterable<T> {
    private final Iterator<T> iterator;

    private Iteratorable(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public static <T> Iteratorable<T> of(Iterator<T> iterator) {
        return new Iteratorable<>(iterator);
    }

    public static <T> Iteratorable<T> of(Stream<T> stream) {
        return new Iteratorable<>(stream.iterator());
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return this.iterator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public T next() {
        return this.iterator.next();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.iterator.forEachRemaining(action);
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        this.iterator.forEachRemaining(action);
    }

    public Stream<T> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.iterator, 0), false);
    }
}
