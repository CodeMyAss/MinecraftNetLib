# MinecraftNetLib
A Minecraft Networking Library

# Design

MinecraftProtocol
    -> Register Packets
    -> Side.CLIENT || Side.SERVER
        -> CodecLookup
