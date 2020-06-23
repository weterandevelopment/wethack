package org.proswiss.wethack.setting;

/**
 * Setting class
 *
 * @author zyktex
 */
public abstract class Setting<T> {
    private String name;
    private T value;

    /**
     * @Param name This is the name of the setting
     * @Param value This is the value of the setting
     */
    Setting(String name, T value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets name of setting
     * @Return String Name of setting
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets value of setting
     * @Return T Value of setting
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Sets value of setting
     *
     * @Param value New value
     * @Return Nothing
     */
    public void setValue(T value) {
        this.value = value;
    }
}
