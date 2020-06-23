package org.proswiss.wethack.event;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.proswiss.wethack.Wethack;
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
     * @param event Specifies the event we want this to be called at
     */
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        for(Module module : ModuleManager.getModules()) {
            if(module.isEnabled()) {
                module.onUpdate();
            }
        }
    }

}
