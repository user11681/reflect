package user11681.reflect.experimental.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.gudenau.lib.unsafe.Unsafe;

public class Generics {
    public static List<Type> genericSupertypes(Class<?> klass) {
        Type genericSuperclass = klass.getGenericSuperclass();
        List<Type> genericSupertypes = new ArrayList<>(Arrays.asList(klass.getGenericInterfaces()));

        if (genericSuperclass != null) {
            genericSupertypes.add(genericSuperclass);
        }

        return genericSupertypes;
    }

    public static List<TypeArgument> typeArguments(Class<?> klass) {
        ClassLoader loader = klass.getClassLoader();
        List<TypeArgument> types = new ArrayList<>();

        try {
            for (Type genericSupertype : genericSupertypes(klass)) {
                Class<?> supertype = Class.forName(genericSupertype.getTypeName().replaceFirst("<.*>", ""), false, loader);

                if (genericSupertype instanceof ParameterizedType) {
                    TypeVariable<?>[] typeParameters = supertype.getTypeParameters();
                    Type[] typeArguments = ((ParameterizedType) genericSupertype).getActualTypeArguments();

                    assert typeParameters.length == typeArguments.length;

                    for (int i = 0; i < typeParameters.length; i++) {
                        TypeVariable<?> parameter = typeParameters[i];
                        Type argument = typeArguments[i];

                        types.add(new TypeArgument(supertype, argument instanceof Class ? (Class<?>) argument : Class.forName(argument.getTypeName(), false, loader), parameter.getName(), i));
                    }
                }

                types.addAll(typeArguments(supertype));
            }
        } catch (Throwable throwable) {
            throw Unsafe.throwException(throwable);
        }

        return types;
    }
}
