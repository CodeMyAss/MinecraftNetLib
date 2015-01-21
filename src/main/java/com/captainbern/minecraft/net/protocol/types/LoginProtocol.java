package com.captainbern.minecraft.net.protocol.types;

import com.captainbern.minecraft.net.codec.login.client.CodecEncryptionResponse;
import com.captainbern.minecraft.net.codec.login.client.CodecLoginRequest;
import com.captainbern.minecraft.net.codec.login.server.CodecEncryptionRequest;
import com.captainbern.minecraft.net.codec.login.server.CodecLoginKickDisconnect;
import com.captainbern.minecraft.net.codec.login.server.CodecLoginResponse;
import com.captainbern.minecraft.net.codec.login.server.CodecLoginSetCompression;
import com.captainbern.minecraft.net.packet.login.client.PacketEncryptionResponse;
import com.captainbern.minecraft.net.packet.login.client.PacketLoginRequest;
import com.captainbern.minecraft.net.packet.login.server.PacketEncryptionRequest;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginKickDisconnect;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginResponse;
import com.captainbern.minecraft.net.packet.login.server.PacketLoginSetCompression;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.ProtocolState;
import com.captainbern.minecraft.net.protocol.Side;

class LoginProtocol extends MinecraftProtocol {

    public LoginProtocol() {
        super(ProtocolState.LOGIN);

        registerClient(0x0, PacketLoginRequest.class, CodecLoginRequest.class);
        registerClient(0x01, PacketEncryptionResponse.class, CodecEncryptionResponse.class);

        registerServer(0x0, PacketLoginKickDisconnect.class, CodecLoginKickDisconnect.class);
        registerServer(0x01, PacketEncryptionRequest.class, CodecEncryptionRequest.class);
        registerServer(0x02, PacketLoginResponse.class, CodecLoginResponse.class);
        registerServer(0x03, PacketLoginSetCompression.class, CodecLoginSetCompression.class);
    }
}
