package ru.sberbank.jschool.homework.classloaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gleb on 11.03.2018
 */
public class SimpleClassLoader extends ClassLoader {
    private String rootDirectory;
    private Map<String, Class> cache = new HashMap<>();

    protected SimpleClassLoader(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return findClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class result = cache.get(name);
        if (result != null) {
            return result;
        }
        String path = rootDirectory + "/" + name + ".class";
        File file = new File(path);
        if (file.exists()) {
            try {
                byte[] classBytes = Files.readAllBytes(Paths.get(path));
                result = defineClass(name, classBytes, 0, classBytes.length);
            } catch (IOException | ClassFormatError e) {
                throw new ClassNotFoundException();
            }
        } else {
            return findSystemClass(name);
        }
        cache.put(name, result);
        return result;
    }
}
