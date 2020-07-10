package org.proswiss.wethack.event.events;

import org.proswiss.wethack.event.CancellableEvent;

/**
 * The Chat Event class. This event will be called every time the player sends a message. {@link org.proswiss.wethack.event.listeners.Adapter}
 * This event is cancellable. If we cancel it, the message wont get sent.
 *
 * @author Darki
 */
public class ChatEvent extends CancellableEvent {

    /**
     * The message variable will hold the message of the ChatEvent. This variable is set in the constructor.
     */
    private String message;

    /**
     * The Constructor of the ChatEvent
     * @param message The message of the Event
     */
    public ChatEvent(String message) {
        this.message = message;
    }

    /**
     * Getters and Setters
     */

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
