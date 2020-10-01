package org.proswiss.wethack.event.events;

import net.minecraft.network.Packet;
import org.proswiss.wethack.event.CancellableEvent;

public class PacketEvent extends CancellableEvent {

    private final Packet packet;

    public PacketEvent(Packet packet) {
        this.packet = packet;
    }

    public static class Send extends PacketEvent {
        public Send(Packet packet) {
            super(packet);
        }
    }

    public static class Receive extends PacketEvent {
        public Receive(Packet packet) {
            super(packet);
        }
    }

    public Packet getPacket() {
        return packet;
    }
}
