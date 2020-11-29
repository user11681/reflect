package user11681.reflect.experimental;

import java.util.ArrayList;
import java.util.Arrays;
import user11681.reflect.Pointer;

public class Lists {
    private static final Pointer elementData = new Pointer().instanceField(ArrayList.class, "elementData");
    private static final Pointer size = new Pointer().instanceField(ArrayList.class, "size");

    public static <T, U extends ArrayList<T>> U wrap(final T[] array) {
        return (U) wrap(new ArrayList<>(), array);
    }

    public static <T, U extends ArrayList<T>> U wrap(final T[] array, final int listSize) {
        return (U) wrap(new ArrayList<>(), array, listSize);
    }

    public static <T, U extends ArrayList<T>> U wrap(final U list, final T[] array) {
        elementData.put(list, array);
        size.put(list, array.length);

        return list;
    }

    public static <T, U extends ArrayList<T>> U wrap(final U list, final T[] array, final int listSize) {
        elementData.put(list, array);
        size.put(list, listSize);

        return list;
    }

    public static <T> void addAll(final ArrayList<T> list, final T[] elements) {
        final int length = elements.length;
        final T[] original = elementData.get(list);
        final T[] newArray = Arrays.copyOf(original, original.length + length);

        elementData.put(list, newArray);
        size.put(list, list.size() + length);
    }
}
