package user11681.reflect.asm;

import java.io.PrintStream;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class MethodNode2 extends MethodNode implements BitField, Opcodes {
    public ClassNode2 klass;

    public MethodNode2(ClassNode2 klass, int access, String name, String descriptor, String signature, String[] exceptions) {
        super(ASM9, access, name, descriptor, signature, exceptions);

        this.klass = klass;
    }

    @Override
    public int flags() {
        return this.access;
    }

    public void field(int opcode, String owner, String name, String descriptor) {
        super.visitFieldInsn(opcode, owner, name, descriptor);
    }

    public void field(int opcode, String name) {
        FieldNode field = this.klass.fields.stream().filter(f -> name.equals(f.name)).findFirst().get();

        this.field(opcode, this.klass.name, name, field.desc);
    }

    public void method(int opcodeAndSource, String owner, String name, String descriptor, boolean isInterface) {
        super.visitMethodInsn(opcodeAndSource, owner, name, descriptor, isInterface);
    }

    public void method(int opcodeAndSource, String name) {
        MethodNode method = this.klass.methods.stream().filter(m -> name.equals(m.name)).findFirst().get();

        this.method(opcodeAndSource, this.klass.name, name, method.desc, this.klass.has(ACC_INTERFACE));
    }

    public void print(Runnable arg) {
        this.print("java/lang/Object", arg);
    }

    public void printI(Runnable arg) {
        this.print("I", arg);
    }

    private void print(String type, Runnable arg) {
        String descriptor = Type.getDescriptor(PrintStream.class);

        this.field(GETSTATIC, "java/lang/System", "out", descriptor);
        arg.run();
        this.method(INVOKEVIRTUAL, Type.getInternalName(PrintStream.class), "println", "(" + type + ")V", false);
    }
}
