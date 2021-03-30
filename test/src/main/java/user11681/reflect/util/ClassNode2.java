package user11681.reflect.util;

import net.gudenau.lib.unsafe.Unsafe;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import user11681.reflect.Reflect;

public class ClassNode2 extends ClassNode implements Opcodes {
    public ClassNode2() {
        super(ASM9);
    }

    public ClassNode2(int access, String name, String signature, String superName, String[] interfaces) {
        this(V16, access, name, signature, superName, interfaces);
    }

    public ClassNode2(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this();

        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodNode visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        return (MethodNode) super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public FieldNode visitField(int access, String name, String descriptor, String signature, Object value) {
        return (FieldNode) super.visitField(access, name, descriptor, signature, value);
    }

    public void defaultConstructor() {
        MethodNode init = this.visitMethod(0, "<init>", "()V", null, null);
        init.visitVarInsn(ALOAD, 0);
        init.visitMethodInsn(INVOKESPECIAL, this.superName, "<init>", "()V", false);
        init.visitInsn(RETURN);
    }

    public <T> Class<T> define() {
        byte[] bytecode = this.bytecode();

        return Unsafe.defineClass(this.name, bytecode, 0, bytecode.length, Reflect.defaultClassLoader, ClassNode2.class.getProtectionDomain());
    }

    public byte[] bytecode() {
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        this.accept(writer);

        return writer.toByteArray();
    }
}
