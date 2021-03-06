package org.proswiss.wethack.module;

import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.Subscriber;
import org.proswiss.wethack.event.events.UpdateEvent;
import org.proswiss.wethack.setting.Setting;

/**
 * Abstract base class for modules. Contains essential methods such as onTick.
 *
 * @author zyktex
 */
public abstract class Module {

    /**
     * General settings for module
     */
    private Setting<String> name;
    private Setting<Boolean> enabled;
    private Setting<Integer> bind;

    /**
     * The Category variable of module
     */
    private Category category;

    /**
     * Constructor for the Module Class
     * Also puts the Module on the EventDispatcher Bus
     *
     * @param name     The Name of the Module
     * @param category The Category of the Module
     */
    public Module(String name, Category category) {
        this.name.setValue(name);
        this.category = category;

        EventDispatcher.Companion.register(this);
    }

    /**
     * Called every client tick. Useful for most modules.
     */
    public void onUpdate() {

    }

    /**
     * Called whenever the module is enabled. Can be overridden to not register event handlers, etc.
     */
    public void onEnable() {
        EventDispatcher.Companion.subscribe(this);
    }

    /**
     * Called whenever the module is disabled. Can be overridden to not unregister event handlers, etc.
     */
    public void onDisable() {
        EventDispatcher.Companion.unsubscribe(this);
    }

    /**
     * Returns a boolean true or false whether the Module is enabled or not.
     *
     * @return boolean whether the Module is enabled or not.
     */
    public boolean isEnabled() {
        return enabled.getValue();
    }

    /**
     * Sets the enabled setting to the module to the input parameter.
     *
     * @param enabled Boolean of what to set the Modules "enabled" setting to.
     */
    public void setEnabled(boolean enabled) {
        if (enabled) {
            enable();
        } else {
            disable();
        }
    }

    /**
     * Every time the UpdateEvent gets called, we're gonna call the onUpdate method
     *
     * @param event The event we want this to be called at, in this case the UpdateEvent
     */
    @Subscriber
    public void onUpdateEvent(UpdateEvent event) {
        onUpdate();
    }

    /**
     * Enable module
     */
    public void enable() {
        this.enabled.setValue(true);
        onEnable();
    }

    /**
     * Disable module
     */
    public void disable() {
        this.enabled.setValue(false);
        onDisable();
    }

    /**
     * Enable module if disabled, or disable module if enabled
     */
    public void toggle() {
        if (this.enabled.getValue()) {
            disable();
        } else {
            enable();
        }
    }

    /**
     * Getters and Setters for Settings
     */

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public int getBind() {
        return bind.getValue();
    }

    public void setBind(int bind) {
        this.bind.setValue(bind);
    }

    /**
     * The Enum for all the Categories. Determines what Category a Module is in.
     */
    public enum Category {
        COMBAT, PLAYER, MOVEMENT, RENDER, HUD, EXPLOITS
    }

}
