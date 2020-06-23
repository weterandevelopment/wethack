package org.proswiss.wethack.module;

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
        return enabled.getValue();
    }

    /**
     * Sets the enabled setting to the module to the input parameter.
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
}
