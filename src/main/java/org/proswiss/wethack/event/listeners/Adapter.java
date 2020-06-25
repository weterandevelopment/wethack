package org.proswiss.wethack.event.listeners;

import cookiedragon.eventsystem.EventDispatcher;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.proswiss.wethack.event.events.KeyPressEvent;
import org.proswiss.wethack.event.events.UpdateEvent;

public class Adapter {

    /**
     * Puts the Forge Event on our own Event Bus
     *
     * @param event The Event we want this to be called at
     */
    @SubscribeEvent
    public void onTick(net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent event) {
        UpdateEvent updateEvent = new UpdateEvent();
        EventDispatcher.Companion.dispatch(updateEvent);
    }

    /**
     * Puts the Forge Event on our own Event Bus
     *
     * @param event The Event we want this to be called at
     */
    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        KeyPressEvent keyPressEvent = new KeyPressEvent();
        EventDispatcher.Companion.dispatch(keyPressEvent);
    }


}
