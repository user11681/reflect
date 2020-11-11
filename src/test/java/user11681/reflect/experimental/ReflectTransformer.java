package user11681.reflect.experimental;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class ReflectTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(final ClassLoader loader, final String className, final Class<?> classBeingRedefined, final ProtectionDomain protectionDomain, final byte[] classfileBuffer) {
        return classfileBuffer;
    }
}
