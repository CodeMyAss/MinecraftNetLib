package com.captainbern.minecraft.net.handler;

import com.captainbern.minecraft.net.packet.Packet;
import com.google.common.collect.Maps;

import java.util.Map;

public class HandlerLookup {

    private Map<Class<? extends Packet>, Handler<?, ?>> LOOKUP = Maps.newConcurrentMap();

    public <P extends Packet, L extends Handler> void register(Class<P> packet, Class<L> handlerClass) throws IllegalAccessException, InstantiationException {
        Handler<?, ? super P> handler = handlerClass.newInstance();
        this.LOOKUP.put(packet, handler);
    }

    public <P extends Packet> Handler<?, P> getHandlerFor(Class<P> packet) {
        return (Handler<?, P>) this.LOOKUP.get(packet);
    }

    @Override
    public String toString() {
        return "HandlerLookup{handlers=" + this.LOOKUP + "}";
    }
}
