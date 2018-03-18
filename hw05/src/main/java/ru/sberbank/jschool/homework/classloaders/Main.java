package ru.sberbank.jschool.homework.classloaders;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Gleb on 14.03.2018
 */
public class Main {
    public static void main(String[] args) throws PluginNotFoundException {
        Path path = Paths.get(System.getProperty("user.dir")).resolve("hw05\\src\\main");
        PluginManager pluginManager = new PluginManager(path.toString());
        pluginManager.loadPlugin("resources");
    }
}
