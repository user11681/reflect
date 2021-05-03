package user11681.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class ConstantPool {
    private static final MethodHandle getSize = Invoker.findVirtual(Classes.ConstantPool, "getSize", int.class);
    private static final MethodHandle getClassAt = Invoker.findVirtual(Classes.ConstantPool, "getClassAt", Class.class, int.class);
    private static final MethodHandle getClassAtIfLoaded = Invoker.findVirtual(Classes.ConstantPool, "getClassAtIfLoaded", Class.class, int.class);
    private static final MethodHandle getMethodAt = Invoker.findVirtual(Classes.ConstantPool, "getMethodAt", Member.class, int.class);
    private static final MethodHandle getMethodAtIfLoaded = Invoker.findVirtual(Classes.ConstantPool, "getMethodAtIfLoaded", Member.class, int.class);
    private static final MethodHandle getFieldAt = Invoker.findVirtual(Classes.ConstantPool, "getFieldAt", Field.class, int.class);
    private static final MethodHandle getFieldAtIfLoaded = Invoker.findVirtual(Classes.ConstantPool, "getFieldAtIfLoaded", Field.class, int.class);
    private static final MethodHandle getMemberRefInfoAt = Invoker.findVirtual(Classes.ConstantPool, "getMemberRefInfoAt", String[].class, int.class);
    private static final MethodHandle getIntAt = Invoker.findVirtual(Classes.ConstantPool, "getIntAt", int.class, int.class);
    private static final MethodHandle getLongAt = Invoker.findVirtual(Classes.ConstantPool, "getLongAt", long.class, int.class);
    private static final MethodHandle getFloatAt = Invoker.findVirtual(Classes.ConstantPool, "getFloatAt", float.class, int.class);
    private static final MethodHandle getDoubleAt = Invoker.findVirtual(Classes.ConstantPool, "getDoubleAt", double.class, int.class);
    private static final MethodHandle getStringAt = Invoker.findVirtual(Classes.ConstantPool, "getStringAt", String.class, int.class);
    private static final MethodHandle getUTF8At = Invoker.findVirtual(Classes.ConstantPool, "getUTF8At", String.class, int.class);

    private static final Object notFound = null;

    private final Object constantPool;

    public ConstantPool(Class<?> klass) {
        this.constantPool = JavaLangAccess.getConstantPool(klass);
    }

    public Integer getSize() {
        try {
            return (Integer) getSize.invoke(this.constantPool);
        } catch (Throwable throwable) {
            return (Integer) notFound;
        }
    }

    public Class<?> getClassAt(int index) {
        try {
            return (Class<?>) getClassAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Class<?>) notFound;
        }
    }

    public Class<?> getClassAtIfLoaded(int index) {
        try {
            return (Class<?>) getClassAtIfLoaded.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Class<?>) notFound;
        }
    }

    public Member getMethodAt(int index) {
        try {
            return (Member) getMethodAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Member) notFound;
        }
    }

    public Member getMethodAtIfLoaded(int index) {
        try {
            return (Member) getMethodAtIfLoaded.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Member) notFound;
        }
    }

    public Field getFieldAt(int index) {
        try {
            return (Field) getFieldAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Field) notFound;
        }
    }

    public Field getFieldAtIfLoaded(int index) {
        try {
            return (Field) getFieldAtIfLoaded.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Field) notFound;
        }
    }

    public String getMemberRefInfoAt(int index) {
        try {
            return (String) getMemberRefInfoAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (String) notFound;
        }
    }

    public Integer getIntAt(int index) {
        try {
            return (Integer) getIntAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Integer) notFound;
        }
    }

    public Long getLongAt(int index) {
        try {
            return (Long) getLongAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Long) notFound;
        }
    }

    public Float getFloatAt(int index) {
        try {
            return (Float) getFloatAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Float) notFound;
        }
    }

    public Double getDoubleAt(int index) {
        try {
            return (Double) getDoubleAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (Double) notFound;
        }
    }

    public String getStringAt(int index) {
        try {
            return (String) getStringAt.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (String) notFound;
        }
    }

    public String getUTF8At(int index) {
        try {
            return (String) getUTF8At.invoke(this.constantPool, index);
        } catch (Throwable throwable) {
            return (String) notFound;
        }
    }
}
