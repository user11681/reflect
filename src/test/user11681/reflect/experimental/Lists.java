package user11681.reflect.experimental;

import java.util.ArrayList;
import java.util.Arrays;
import user11681.reflect.Pointer;

public class Lists {
    private static final Pointer elementData = new Pointer().instanceField(ArrayList.class, "elementData");
    private static final Pointer size = new Pointer().instanceField(ArrayList.class, "size");

    public static <T, U extends ArrayList<T>> U wrap(T[] array) {
        return (U) wrap(new ArrayList<>(), array);
    }

    public static <T, U extends ArrayList<T>> U wrap(T[] array, int listSize) {
        return (U) wrap(new ArrayList<>(), array, listSize);
    }

    public static <T, U extends ArrayList<T>> U wrap(U list, T[] array) {
        elementData.putObject(list, array);
        size.putObject(list, array.length);

        return list;
    }

    public static <T, U extends ArrayList<T>> U wrap(U list, T[] array, int listSize) {
        elementData.putObject(list, array);
        size.putObject(list, listSize);

        return list;
    }

    public static <T> void addAll(ArrayList<T> list, T[] elements) {
        int length = elements.length;
        T[] original = elementData.getObject(list);
        T[] newArray = Arrays.copyOf(original, original.length + length);

        elementData.putObject(list, newArray);
        size.putObject(list, list.size() + length);
    }
}
