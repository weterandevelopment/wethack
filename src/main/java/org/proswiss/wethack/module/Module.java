package org.proswiss.wethack.module;

/**
 * Abstract base class for modules. Contains essential methods such as onTick.
 *
 * @author zyktex
 */
public abstract class Module {

    /**
     * Defines whether the Module is enabled or not.
     */
    boolean enabled = false;

    /**
     * Called every client tick. Useful for most modules.
     */
    public void onUpdate() {

    }

    /**
     * Called whenever the module is enabled. Can be overridden to not register event handlers, etc.
     */
    public void onEnable() {

    }

    /**
     * Called whenever the module is disabled. Can be overridden to not unregister event handlers, etc.
     */
    public void onDisable() {

    }

    /**
     * Returns a boolean true or false whether the Module is enabled or not.
     * @return boolean whether the Module is enabled or not.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled boolean to the module to the input parameter.
     * @param enabled Boolean of what to set the Modules "enabled" boolean variable to.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
