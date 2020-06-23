package org.proswiss.wethack.event;

/**
 * @author Darki
 */
public class CancellableEvent {

    /**
     * The cancelled variable determines whether the Event is cancelled or not.
     */
    boolean cancelled = false;

    /**
     * Sets the cancelled variable to the cancelled parameter
     * @param cancelled The cancelled parameter
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Sets the cancelled variable to true
     */
    public void cancel() {
        this.cancelled = true;
    }

    /**
     * @return Returns whether the Event is cancelled or not.
     */
    public boolean isCancelled() {
        return cancelled;
    }

}
