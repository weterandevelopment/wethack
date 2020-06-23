package org.proswiss.wethack.setting;

/**
 * Number Setting class, for integers, longs, doubles, and floats
 *
 * @author zyktex
 */
public class BooleanSetting extends Setting<Boolean> {
    /**
     * @Param name This is the name of the setting
     * @Param value This is the boolean value of the setting
     */
    public BooleanSetting(String name, Boolean value) {
        super(name, value);
    }
}
