package com.captainbern.minecraft.net.protocol.types;

import com.captainbern.minecraft.net.codec.play.client.*;
import com.captainbern.minecraft.net.codec.play.client.CodecCloseWindow;
import com.captainbern.minecraft.net.codec.play.client.CodecHeldItemChange;
import com.captainbern.minecraft.net.codec.play.client.CodecKeepAlive;
import com.captainbern.minecraft.net.codec.play.client.CodecPlayerAbilities;
import com.captainbern.minecraft.net.codec.play.client.CodecPluginMessage;
import com.captainbern.minecraft.net.codec.play.client.CodecTabComplete;
import com.captainbern.minecraft.net.codec.play.client.CodecUpdateSign;
import com.captainbern.minecraft.net.codec.play.server.*;
import com.captainbern.minecraft.net.packet.play.client.*;
import com.captainbern.minecraft.net.packet.play.client.PacketCloseWindow;
import com.captainbern.minecraft.net.packet.play.client.PacketHeldItemChange;
import com.captainbern.minecraft.net.packet.play.client.PacketKeepAlive;
import com.captainbern.minecraft.net.packet.play.client.PacketPlayerAbilities;
import com.captainbern.minecraft.net.packet.play.client.PacketPluginMessage;
import com.captainbern.minecraft.net.packet.play.client.PacketTabComplete;
import com.captainbern.minecraft.net.packet.play.client.PacketUpdateSign;
import com.captainbern.minecraft.net.packet.play.server.*;
import com.captainbern.minecraft.net.protocol.MinecraftProtocol;
import com.captainbern.minecraft.net.protocol.ProtocolState;
import com.captainbern.minecraft.net.protocol.Side;

public class PlayProtocol extends MinecraftProtocol {

    public PlayProtocol() {
        super(ProtocolState.PLAY);

        registerClient(0x0, PacketKeepAlive.class, CodecKeepAlive.class);
        registerClient(0x01, PacketClientChatMessage.class, CodecClientChatMessage.class);
        registerClient(0x02, PacketUseEntity.class, CodecUseEntity.class);
        registerClient(0x03, PacketPlayerUpdate.class, CodecPlayerUpdate.class);
        registerClient(0x04, PacketPlayerUpdatePosition.class, CodecPlayerUpdatePosition.class);
        registerClient(0x05, PacketPlayerUpdateLook.class, CodecPlayerUpdateLook.class);
        registerClient(0x06, PacketPlayerUpdatePositionAndLook.class, CodecPlayerUpdatePositionLook.class);
        registerClient(0x07, PacketDigging.class, CodecDigging.class);
        registerClient(0x08, PacketPlaceBlock.class, CodecPlaceBlock.class);
        registerClient(0x09, PacketHeldItemChange.class, CodecHeldItemChange.class);
        registerClient(0x0a, PacketSwingArm.class, CodecSwingArm.class);
        registerClient(0x0b, PacketEntityAction.class, CodecEntityAction.class);
        registerClient(0x0c, PacketSteerVehicle.class, CodecSteerVehicle.class);
        registerClient(0x0d, PacketCloseWindow.class, CodecCloseWindow.class);
        registerClient(0x0e, PacketClickWindow.class, CodecClickWindow.class);
        registerClient(0x0f, PacketConfirmTransation.class, CodecConfirmTransation.class);
        registerClient(0x10, PacketCreativeInventoryAction.class, CodecCreativeInventoryAction.class);
        registerClient(0x11, PacketEnchantItem.class, CodecEnchantItem.class);
        registerClient(0x12, PacketUpdateSign.class, CodecUpdateSign.class);
        registerClient(0x13, PacketPlayerAbilities.class, CodecPlayerAbilities.class);
        registerClient(0x14, PacketTabComplete.class, CodecTabComplete.class);
        registerClient(0x15, PacketClientSettings.class, CodecClientSettings.class);
        registerClient(0x16, PacketClientStatus.class, CodecClientStatus.class);
        registerClient(0x17, PacketPluginMessage.class, CodecPluginMessage.class);
        registerClient(0x18, PacketSpectate.class, CodecSpectate.class);
        registerClient(0x19, PacketResourcePackStatus.class, CodecResourcePackStatus.class);

        registerServer(0x0, com.captainbern.minecraft.net.packet.play.server.PacketKeepAlive.class, com.captainbern.minecraft.net.codec.play.server.CodecKeepAlive.class);
        registerServer(0x1, PacketJoinGame.class, CodecJoinGame.class);
        registerServer(0x2, PacketServerChatMessage.class, CodecServerChatMessage.class);
        registerServer(0x3, PacketTimeUpdate.class, CodecTimeUpdate.class);
        registerServer(0x4, PacketEntityEquipment.class, CodecEntityEquipment.class);
        registerServer(0x5, PacketSpawnPosition.class, CodecSpawnPosition.class);
        registerServer(0x6, PacketUpdateHealth.class, CodecUpdateHealth.class);
        registerServer(0x7, PacketRespawn.class, CodecRespawn.class);
        registerServer(0x8, PacketPlayerPositionAndLook.class, CodecPlayerPositionAndLook.class);
        registerServer(0x9, com.captainbern.minecraft.net.packet.play.server.PacketHeldItemChange.class, com.captainbern.minecraft.net.codec.play.server.CodecHeldItemChange.class);
        registerServer(0xa, PacketUseBed.class, CodecUseBed.class);
        registerServer(0xb, PacketAnimation.class, CodecAnimation.class);
        registerServer(0xc, PacketSpawnPlayer.class, CodecSpawnPlayer.class);
        registerServer(0xd, PacketCollectItem.class, CodecCollectItem.class);
        registerServer(0xe, PacketSpawnObject.class, CodecSpawnObject.class);
        registerServer(0xf, PacketSpawnMob.class, CodecSpawnMob.class);
        registerServer(0x10, PacketSpawnPainting.class, CodecSpawnPainting.class);
        registerServer(0x11, PacketSpawnExperienceOrb.class, CodecSpawnExperienceOrb.class);
        registerServer(0x12, PacketEntityVelocity.class, CodecEntityVelocity.class);
        registerServer(0x13, PacketDestroyEntities.class, CodecDestroyEntities.class);
        registerServer(0x14, PacketEntity.class, CodecEntity.class);
        registerServer(0x15, PacketEntityRelativeMove.class, CodecEntityRelativeMove.class);
        registerServer(0x16, PacketEntityLook.class, CodecEntityLook.class);
        registerServer(0x17, PacketEntityLookAndRelativeMove.class, CodecEntityLookandRelativeMove.class);
        registerServer(0x18, PacketEntityTeleport.class, CodecEntityTeleport.class);
        registerServer(0x19, PacketEntityHeadLook.class, CodecEntityHeadLook.class);
        registerServer(0x1a, PacketEntityStatus.class, CodecEntityStatus.class);
        registerServer(0x1b, PacketAttachEntity.class, CodecAttachEntity.class);
        registerServer(0x1c, PacketEntityMetadata.class, CodecEntityMetadata.class);
        registerServer(0x1d, PacketEntityEffect.class, CodecEntityEffect.class);
        registerServer(0x1e, PacketRemoveEntityEffect.class, CodecRemoveEntityEffect.class);
        registerServer(0x1f, PacketSetExperience.class, CodecSetExperience.class);
        registerServer(0x20, PacketEntityProperties.class, CodecEntityProperties.class);
        registerServer(0x21, PacketChunkData.class, CodecChunkData.class);
        registerServer(0x22, PacketMultiBlockChange.class, CodecMultiBlockChange.class);
        registerServer(0x23, PacketBlockChange.class, CodecBlockChange.class);
        registerServer(0x24, PacketBlockAction.class, CodecBlockAction.class);
        registerServer(0x25, PacketBlockBreakAnimation.class, CodecBlockBreakAnimation.class);
        registerServer(0x26, PacketMapChunkBulk.class, CodecMapChunkBulk.class);
        registerServer(0x27, PacketExplosion.class, CodecExplosion.class);
        registerServer(0x28, PacketEffect.class, CodecEffect.class);
        registerServer(0x29, PacketSoundEffect.class, CodecSoundEffect.class);
        registerServer(0x2a, PacketParticle.class, CodecParticle.class);
        registerServer(0x2b, PacketChangeGameState.class, CodecChangeGameState.class);
        registerServer(0x2c, PacketSpawnGlobalEntity.class, CodecSpawnGlobalEntity.class);
        registerServer(0x2d, PacketOpenWindow.class, CodecOpenWindow.class);
        registerServer(0x2e, com.captainbern.minecraft.net.packet.play.server.PacketCloseWindow.class, com.captainbern.minecraft.net.codec.play.server.CodecCloseWindow.class);
        registerServer(0x2f, PacketSetSlot.class, CodecSetSlot.class);
        registerServer(0x30, PacketWindowItems.class, CodecWindowItems.class);
        registerServer(0x31, PacketWindowProperty.class, CodecWindowProperty.class);
        registerServer(0x32, com.captainbern.minecraft.net.packet.play.server.PacketConfirmTransaction.class, CodecConfirmTransaction.class);
        registerServer(0x33, com.captainbern.minecraft.net.packet.play.server.PacketUpdateSign.class, com.captainbern.minecraft.net.codec.play.server.CodecUpdateSign.class);
        registerServer(0x34, PacketMaps.class, CodecMaps.class);
        registerServer(0x35, PacketUpdateBlockEntity.class, CodecUpdateBlockEntity.class);
        registerServer(0x36, PacketSignEditorOpen.class, CodecSignEditorOpen.class);
        registerServer(0x37, PacketStatistics.class, CodecStatistics.class);
        registerServer(0x38, PacketPlayerListItem.class, CodecPlayerListItem.class);
        registerServer(0x39, com.captainbern.minecraft.net.packet.play.server.PacketPlayerAbilities.class, com.captainbern.minecraft.net.codec.play.server.CodecPlayerAbilities.class);
        registerServer(0x3a, com.captainbern.minecraft.net.packet.play.server.PacketTabComplete.class, com.captainbern.minecraft.net.codec.play.server.CodecTabComplete.class);
        registerServer(0x3b, PacketScoreboardObjective.class, CodecScoreboardObjective.class);
        registerServer(0x3c, PacketUpdateScore.class, CodecUpdateScore.class);
        registerServer(0x3d, PacketDisplayScoreboard.class, CodecDisplayScoreboard.class);
        registerServer(0x3e, PacketTeams.class, CodecTeams.class);
        registerServer(0x3f, com.captainbern.minecraft.net.packet.play.server.PacketPluginMessage.class, com.captainbern.minecraft.net.codec.play.server.CodecPluginMessage.class);
        registerServer(0x40, PacketDisconnect.class, CodecDisconnect.class);
        registerServer(0x41, PacketServerDifficulty.class, CodecServerDifficulty.class);
        registerServer(0x42, PacketCombatEvent.class, CodecCombatEvent.class);
        registerServer(0x43, PacketCamera.class, CodecCamera.class);
        registerServer(0x44, PacketWorldBorder.class, CodecWorldBorder.class);
        registerServer(0x45, PacketTitle.class, CodecTitle.class);
        registerServer(0x46, PacketSetCompression.class, CodecSetCompression.class);
        registerServer(0x47, PacketPlayerListHeaderFooter.class, CodecPlayerListHeaderFooter.class);
        registerServer(0x48, PacketResourcePackSend.class, CodecResourcePackSend.class);
        registerServer(0x49, PacketUpdateEntityNBT.class, CodecUpdateEntityNBT.class);
    }
}
