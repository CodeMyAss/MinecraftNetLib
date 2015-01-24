package com.captainbern.minecraft.net.handler;

import com.captainbern.minecraft.net.packet.Packet;
import com.captainbern.minecraft.net.protocol.types.ProtocolType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PacketHandler {

    Class<? extends Packet> packet();

    ProtocolType protocol();

}
