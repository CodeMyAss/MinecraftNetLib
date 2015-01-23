package com.captainbern.minecraft.net.handler.test;

import com.captainbern.minecraft.net.packet.Packet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface PacketHandler {

    Class<? extends Packet> value();

}
