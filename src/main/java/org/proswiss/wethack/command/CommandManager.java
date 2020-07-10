package org.proswiss.wethack.command;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.proswiss.wethack.module.Module;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Manages Commands
 * This class is very similar to the {@link org.proswiss.wethack.module.ModuleManager} class.
 *
 * @author Darki
 */

public class CommandManager {

    private static ArrayList<Command> commands = new ArrayList<>();

    /**
     * Scans all classes which extend {@link Command} using ClassGraph, and initializes them.
     * You can also do it manually, by manually adding every command to the commands ArrayList using commands.add(ExampleCommand.java);
     * This solution is simpler, especially if this is your first time working with java
     */
    public static void initialize() {
        List<Class<Command>> commandClasses;
        try (ScanResult scanResult = new ClassGraph().acceptPackages("org.proswiss.wethack.command")
                .enableClassInfo().scan()) {
            commandClasses = scanResult
                    .getSubclasses(Command.class.getName())
                    .loadClasses(Command.class);
        }
        commandClasses.forEach(commandClass -> {
            try {
                Command command = (Command) commandClass.getConstructor().newInstance();
                commands.add(command);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Returns a list of the initialized Commands
     * @return ArrayList<Command> List of commands
     */
    public static ArrayList<Command> getCommands() {
        return commands;
    }

}
