package org.proswiss.wethack.event.listeners;

import cookiedragon.eventsystem.EventDispatcher;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.proswiss.wethack.event.events.ChatEvent;
import org.proswiss.wethack.event.events.KeyPressEvent;
import org.proswiss.wethack.event.events.UpdateEvent;

/**
 * This class puts forge events on our own Event Bus
 *
 * @author Darki
 */

public class Adapter {

    /**
     * Puts the Forge Event on our own Event Bus
     *
     * @param event The Event we want this to be called at
     */
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
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

    /**
     * Puts the Forge Event on our own Event Bus
     * Sets the message of the Forge Event to the Message of our own Event
     * Sets the Forge Event to cancelled if our own event is cancelled
     *
     * @param event The Event we want this to be called at
     */
    @SubscribeEvent
    public void onChatMessage(ClientChatEvent event) {
        ChatEvent chatEvent = new ChatEvent(event.getMessage());
        EventDispatcher.Companion.dispatch(chatEvent);
        event.setMessage(chatEvent.getMessage());
        if(chatEvent.isCancelled()) event.setCanceled(true);
    }


}
