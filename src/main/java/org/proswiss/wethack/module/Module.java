package org.proswiss.wethack.module;

/**
 * Abstract base class for modules. Contains essential methods such as onTick.
 *
 * @author zyktex
 */
public abstract class Module {
    /**
     * Called every client tick. Useful for most modules.
     */
    public void onTick() {

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
}
