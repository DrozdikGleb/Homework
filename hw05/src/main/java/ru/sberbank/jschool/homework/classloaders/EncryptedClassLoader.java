package ru.sberbank.jschool.homework.classloaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Gleb on 11.03.2018
 */
public class EncryptedClassLoader extends ClassLoader {
    private String rootDirectory;
    private int offset;

    EncryptedClassLoader(ClassLoader parent, String rootDirectory, int offset) {
        super(parent);
        this.rootDirectory = rootDirectory;
        this.offset = offset;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String path = Paths.get(rootDirectory).resolve(name + ".class").toString();
        File file = new File(path);
        if (file.exists()) {
            try {
                byte[] classBytes = decodeClass(Files.readAllBytes(Paths.get(path)));
                return defineClass(name, classBytes, 0, classBytes.length);
            } catch (IOException | ClassFormatError e) {
                throw new ClassNotFoundException();
            }
        } else {
            return findSystemClass(name);
        }
    }

    private byte[] decodeClass(byte[] array) {
        byte[] result = new byte[array.length];
        int i = 0;
        for (byte elem : array) {
            result[i++] = (byte) (elem - offset);
        }
        return result;
    }
}
