package org.proswiss.wethack.event.handler;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import org.proswiss.wethack.module.Module;
import org.proswiss.wethack.module.ModuleManager;

/**
 * EventHandler
 *
 * @author DarkiBoi
 */
public class EventHandler {

    public static final EventHandler INSTANCE = new EventHandler();

    private EventHandler(){}

    /**
     * The Client Tick Event gets called every tick.
     * For every tick we loop through the List of Modules, check if they're enabled and if they are run the Modules onUpdate method.
     * @param event Specifies the event we want this to be called at in this case ClientTickEvent
     */
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        for(Module module : ModuleManager.getModules()) {
            if(module.isEnabled()) {
                module.onUpdate();
            }
        }
    }

    /**
     * The Key Input Event gets called everytime a Key is pressed.
     * Everytime we get a new key press, we loop through the Modules and check if the event keybind (Keyboard.getEventKey()) matches the module keybind. If it does we toggle the module.
     * @param event Specifies the event we want this to be called at in this case KeyInputEvent
     */
    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        for(Module module : ModuleManager.getModules()) {
            if(module.getBind() == Keyboard.getEventKey()) {
                module.toggle();
            }
        }
    }

}
