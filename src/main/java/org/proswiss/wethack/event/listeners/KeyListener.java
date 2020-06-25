package org.proswiss.wethack.event.listeners;

import cookiedragon.eventsystem.Subscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.proswiss.wethack.event.events.KeyPressEvent;
import org.proswiss.wethack.module.Module;
import org.proswiss.wethack.module.ModuleManager;

public class KeyListener {

    public static KeyListener INSTANCE = new KeyListener();

    private KeyListener() {
    }

    /**
     * The Key Press Event gets called everytime a Key is pressed.
     * Everytime we get a new key press, we loop through the Modules and check if the event keybind (Keyboard.getEventKey()) matches the module keybind. If it does we toggle the module.
     *
     * @param event Specifies the event we want this to be called at in this case KeyPressEvent
     */
    @Subscriber
    public void onKeyPress(KeyPressEvent event) {
        for (Module module : ModuleManager.getModules()) {
            if (module.getBind() == Keyboard.getEventKey()) {
                module.toggle();
            }
        }
    }


}
