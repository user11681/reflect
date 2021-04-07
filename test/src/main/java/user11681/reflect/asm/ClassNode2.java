package user11681.reflect.asm;

import net.gudenau.lib.unsafe.Unsafe;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import user11681.reflect.Classes;
import user11681.reflect.Reflect;

public class ClassNode2 extends ClassNode implements BitField, Opcodes {
    public ClassLoader loader = Reflect.defaultClassLoader;

    public ClassNode2() {
        super(ASM9);
    }

    public ClassNode2(int access, String name) {
        this(access, name, "java/lang/Object");
    }

    public ClassNode2(int access, String name, String superName) {
        this(access, name, null, superName, null);
    }

    public ClassNode2(int access, String name, String signature, String superName, String[] interfaces) {
        this(V16, access, name, signature, superName, interfaces);
    }

    public ClassNode2(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this();

        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public int flags() {
        return this.access;
    }

    @Override
    public FieldNode visitField(int access, String name, String descriptor, String signature, Object value) {
        return (FieldNode) super.visitField(access, name, descriptor, signature, value);
    }

    public FieldNode visitField(int access, String name, String descriptor) {
        return this.visitField(access, name, descriptor, null, null);
    }

    @Override
    public MethodNode2 visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodNode2 method = new MethodNode2(this, access, name, descriptor, signature, exceptions);

        this.methods.add(method);

        return method;
    }

    public MethodNode2 visitMethod(int access, String name, String descriptor) {
        return this.visitMethod(access, name, descriptor, null, null);
    }

    public MethodNode2 clinit() {
        return this.visitMethod(ACC_STATIC, "<clinit>", "()V");
    }

    public void defaultConstructor() {
        MethodNode2 init = this.visitMethod(0, "<init>", "()V", null, null);
        init.visitVarInsn(ALOAD, 0);
        init.visitMethodInsn(INVOKESPECIAL, this.superName, "<init>", "()V", false);
        init.visitInsn(RETURN);
    }

    public <T> Class<T> define() {
        byte[] bytecode = this.bytecode();

        return Unsafe.defineClass(this.name, bytecode, 0, bytecode.length, this.loader, ClassNode2.class.getProtectionDomain());
    }

    public <T> Class<T> init() {
        return Classes.load(this.loader, true, this.define().getName());
    }

    public byte[] bytecode() {
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        this.accept(writer);

        return writer.toByteArray();
    }
}
