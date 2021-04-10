package user11681.reflect.experimental;

import java.lang.invoke.MethodHandle;
import user11681.reflect.Classes;
import user11681.reflect.Invoker;
import user11681.uncheck.Uncheck;

public class Modules {
    private static final MethodHandle implAddOpensToAllUnnamed = Invoker.findVirtual(Module.class, "implAddOpensToAllUnnamed", void.class, String.class);
    private static final MethodHandle implAddExportsToAllUnnamed = Invoker.findVirtual(Module.class, "implAddExportsToAllUnnamed", void.class, String.class);

    public static void open(String klass) {
        Class<?> klas = Classes.load(klass);

        open(klas.getPackageName(), klas.getModule());
    }

    public static void open(String pkg, String klass) {
        open(pkg, Classes.load(pkg + "." + klass).getModule());
    }

    public static void open(String pkg, Module module) {
        Uncheck.handle(() -> implAddOpensToAllUnnamed.invokeExact(module, pkg));
    }

    public static void export(String klass) {
        Class<?> klas = Classes.load(klass);

        export(klas.getPackageName(), klas.getModule());
    }

    public static void export(String pkg, String klass) {
        export(pkg, Classes.load(pkg + "." + klass).getModule());
    }

    public static void export(String pkg, Module module) {
        Uncheck.handle(() -> implAddExportsToAllUnnamed.invokeExact(module, pkg));
    }
}
