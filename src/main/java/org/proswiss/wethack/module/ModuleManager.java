package org.proswiss.wethack.module;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

/**
 * Manages Modules
 *
 * @author zyktex
 */
public class ModuleManager {
    private static ArrayList<Module> modules = new ArrayList<>();

    /**
     * Scans all classes which extend {@link Module} using ClassGraph, and initializes them.
     */
    public static void initialize() {
        List<Class<Module>> moduleClasses;
        try (ScanResult scanResult = new ClassGraph().acceptPackages("org.proswiss.wethack.module")
                .enableClassInfo().scan()) {
            moduleClasses = scanResult
                    .getSubclasses(Module.class.getName())
                    .loadClasses(Module.class);
        }
        moduleClasses.forEach(moduleClass -> {
            try {
                Module module = (Module) moduleClass.getConstructor().newInstance();
                modules.add(module);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }
}
