package org.proswiss.wethack.event.listeners;

import cookiedragon.eventsystem.Subscriber;
import org.proswiss.wethack.command.Command;
import org.proswiss.wethack.command.CommandManager;
import org.proswiss.wethack.event.events.ChatEvent;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;

public class CommandListener {

    public static CommandListener INSTANCE = new CommandListener();

    private CommandListener() {}

    /**
     * The Chat Event gets called every time a message gets sent by the player
     * Everytime we get a new Chat Message we check if it starts with the prefix
     * If it does we strip the message of the prefix and then split the message String into a String Array using .split(" "). With this we split at every space
     *
     *
     * @param event Specifies the event we want this to be called at in this case KeyPressEvent
     */
    @Subscriber
    public void onChatEvent(ChatEvent event) {
        if(event.getMessage().startsWith(Command.getPrefix())) {

            // This strips the message of the Prefix and then splits it into a String Array at the spaces. Then we convert the String Array into an ArrayList. The first index of the ArrayList will now be the label of the Command
            ArrayList<String> arguments = new ArrayList<>(Arrays.asList(event.getMessage().substring(Command.getPrefix().length()).split(" ")));

            // Now we loop through all Commands to check if one of the commands labels equals to the first index of the String ArrayList which is the label that just got input by the user.

            for(Command command : CommandManager.getCommands()) {
                if(command.getLabel().equalsIgnoreCase(arguments.get(0))) {
                    // Now we strip the arguments array of the actual label itself so we dont pass it as an argument to the Command
                    arguments.remove(0);

                    command.runCommand(arguments);
                }
            }

        }

    }

}
