package user11681.reflect.experimental.instrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class ReflectTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        return classfileBuffer;
    }
}
