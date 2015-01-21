package com.captainbern.minecraft.net.packet.play.server;

import com.captainbern.minecraft.net.packet.Packet;

import java.util.List;

public class PacketMaps implements Packet {

    public static class Icon {

        private byte rotation;
        private byte type;
        private byte x;
        private byte y;

        public Icon(byte rotation, byte type, byte x, byte y) {
            this.rotation = rotation;
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public byte getRotation() {
            return this.rotation;
        }

        public byte getType() {
            return this.type;
        }

        public byte getX() {
            return this.x;
        }

        public byte getY() {
            return this.y;
        }
    }

    public static class MapSection {

        private byte width;
        private byte height;
        private byte x;
        private byte y;
        private byte[] data;

        public MapSection(byte width, byte height, byte x, byte y, byte[] data) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
            this.data = data;
        }

        public byte getWidth() {
            return this.width;
        }

        public byte getHeight() {
            return this.height;
        }

        public byte getX() {
            return this.x;
        }

        public byte getY() {
            return this.y;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    private int mapId;
    private byte scale;
    private List<Icon> icons;
    private MapSection section;


    public PacketMaps(int mapId, byte scale, List<Icon> icons, MapSection section) {
        this.mapId = mapId;
        this.scale = scale;
        this.icons = icons;
        this.section = section;
    }

    public int getMapId() {
        return this.mapId;
    }

    public byte getScale() {
        return this.scale;
    }

    public List<Icon> getIcons() {
        return this.icons;
    }

    public MapSection getSection() {
        return this.section;
    }
}
