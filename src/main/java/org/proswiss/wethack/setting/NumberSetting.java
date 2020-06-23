package org.proswiss.wethack.setting;

/**
 * Number Setting class, for integers, longs, doubles, and floats
 *
 * @author zyktex
 */
public class NumberSetting<T extends Number> extends Setting<T> {
    private T min;
    private T max;

    /**
     * @Param name This is the name of the setting
     * @Param value This is the number value of the setting
     * @Param min This is the minimum value of the setting
     * @Param max This is the maximum value of the setting
     */
    public NumberSetting(String name, T value, T min, T max) {
        super(name, value);
        this.min = min;
        this.max = max;
    }

    /**
     * Gets min value of setting
     * @Return Number Min value of setting
     */
    public T getMin() {
        return this.min;
    }

    /**
     * Gets max value of setting
     * @Return Number Max value of setting
     */
    public T getMax() {
        return this.max;
    }
}
