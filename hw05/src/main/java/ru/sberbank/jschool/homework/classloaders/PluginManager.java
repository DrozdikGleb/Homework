package ru.sberbank.jschool.homework.classloaders;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class PluginManager {

    // directory that contains plugin folders
    private final String rootDirectory;

    public PluginManager(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    /**
     * method takes as a parameter a folder name in the root plugin directory,
     * loads the plugin .class file from the folder if present,
     * and returns a Plugin object
     *
     * @param pluginName - name of the plugin folder
     * @return Plugin
     * @throws PluginNotFoundException - when folder named 'pluginName' is missing,
     *                                 or it contains no .class files
     */
    public Plugin loadPlugin(String pluginName) throws PluginNotFoundException {
        String path = Paths.get(rootDirectory).resolve(pluginName).toString();
        String className = findClass(path).replaceAll(".class", "");
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader(path);
        try {
            return (Plugin) simpleClassLoader.loadClass(className).newInstance();
        } catch (Exception e) {
            throw new PluginNotFoundException("couldn't locate plugin " + pluginName);
        }
    }

    public Plugin loadPlugin(String pluginName, int offset) throws PluginNotFoundException {
        String path = Paths.get(rootDirectory).resolve(pluginName).toString();
        String className = findClass(path).replaceAll(".class", "");
        EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(getClass().getClassLoader().getParent(),
                path, offset);
        try {
            return (Plugin) encryptedClassLoader.loadClass(className).newInstance();
        } catch (Exception e) {
            throw new PluginNotFoundException("couldn't locate plugin " + pluginName);
        }
    }

    private String findClass(String directory) {
        File dir = new File(directory);
        return Arrays.stream(dir.listFiles())
                .map(File::getName)
                .filter(element -> element.endsWith(".class")).findFirst().orElse(null);
    }
}