package user11681.reflect.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import user11681.reflect.Invoker;
import user11681.reflect.util.ClassNode2;

@Testable
public class BytecodeTest implements Opcodes {
    @Test
    void nonVirtual() {
        String object = Type.getInternalName(Object.class);
        String a = Type.getInternalName(A.class);
        String b = Type.getInternalName(B.class);
        String c = Type.getInternalName(BytecodeTest.class) + "$C";
        String invoker = Type.getInternalName(BytecodeTest.class) + "$Invoker";

        ClassNode2 node = new ClassNode2(V1_1, 0, c, null, b, null);

        node.defaultConstructor();

        MethodNode print = node.visitMethod(ACC_STATIC, "print", "(L" + c + ";)V", null, null);
        print.visitVarInsn(ALOAD, 0);
        print.visitMethodInsn(INVOKESPECIAL, a, "print", "()V", false);
        print.visitInsn(RETURN);

        node.define();

        C.print(new C());
    }

    @Test
    void finalFieldMayHaveBeenAssigned() throws Throwable {
        //        class A {final int a;
        //            A() {this.a = 1;}
        //            A(int b) {this(); this.a = b;}}
        ClassNode2 klass = new ClassNode2(V15, ACC_PUBLIC, "A", null, "java/lang/Object", null);
        klass.visitField(ACC_FINAL, "a", "I", null, null);

        MethodNode ctr0 = klass.visitMethod(0, "<init>", "()V", null, null);
        ctr0.visitVarInsn(ALOAD, 0);
        ctr0.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        ctr0.visitVarInsn(ALOAD, 0);
        ctr0.visitInsn(ICONST_1);
        ctr0.visitFieldInsn(PUTFIELD, "A", "a", "I");
        ctr0.visitInsn(RETURN);

        MethodNode ctr1 = klass.visitMethod(ACC_PUBLIC, "<init>", "(I)V", null, null);
        ctr1.visitVarInsn(ALOAD, 0);
        ctr1.visitMethodInsn(INVOKESPECIAL, "A", "<init>", "()V", false);
        ctr1.visitVarInsn(ALOAD, 0);
        ctr1.visitVarInsn(ILOAD, 1);
        ctr1.visitFieldInsn(PUTFIELD, "A", "a", "I");
        ctr1.visitInsn(RETURN);

        Class<?> A = klass.define();
        A.getDeclaredConstructor(int.class).newInstance(2);
    }

    @Test
    void allocate() throws Throwable {
        ClassNode2 node = new ClassNode2(ACC_PUBLIC, "allocate", null, "java/lang/Object", null);

        MethodNode allocate = node.visitMethod(ACC_PUBLIC | ACC_STATIC, "allocate", "()Ljava/lang/Object;", null, null);
        allocate.visitTypeInsn(NEW, "java/lang/Object");
        allocate.visitInsn(ARETURN);

        Class<?> klass = node.define();
        klass.getMethods();
        Object object = Invoker.findStatic(klass, "allocate", Object.class).invokeExact();
    }

    @Test
    void defaultMethod() throws Throwable {
        ClassNode2 node = new ClassNode2(ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE, "defaultMethod", null, "java/lang/Object", null);

        MethodNode defaultMethod = node.visitMethod(ACC_PUBLIC, "defaultMethod", "()V", null, null);
        defaultMethod.visitInsn(RETURN);

        node.define();
    }

    @Test
    void interfaceField() throws Throwable {
        ClassNode2 node = new ClassNode2(ACC_PUBLIC | ACC_INTERFACE | ACC_ABSTRACT, "interfaceField", null, "java/lang/Object", null);

        FieldNode field = node.visitField(ACC_PUBLIC | ACC_ABSTRACT | ACC_STATIC | ACC_FINAL, "field", "I", null, null);

        node.define().getFields();
    }

    static class A {
        void print() {
            System.out.println("A");
        }
    }

    static class B extends A {
        @Override
        void print() {
            System.out.println("B");
        }
    }

    static class C extends B {
        static native void print(C c);
    }
}
