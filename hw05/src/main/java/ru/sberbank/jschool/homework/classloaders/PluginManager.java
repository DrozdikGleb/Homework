package ru.sberbank.jschool.homework.classloaders;

import java.io.File;
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
        return loadPluginWithCondition(pluginName, 0);
    }

    public Plugin loadPlugin(String pluginName, int offset) throws PluginNotFoundException {
        return loadPluginWithCondition(pluginName, offset);
    }

    private Plugin loadPluginWithCondition(String pluginName, int offset) throws PluginNotFoundException {
        String path = rootDirectory + "/" + pluginName;
        ClassLoader currentClassLoader = offset == 0 ? new SimpleClassLoader(path) :
                new EncryptedClassLoader(getClass().getClassLoader().getParent(), path, offset);
        try {
            String className = findClass(path).replaceAll(".class", "");
            System.out.println(className);
            return (Plugin) currentClassLoader.loadClass(className).newInstance();
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
