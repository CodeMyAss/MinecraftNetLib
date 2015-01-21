package com.captainbern.minecraft.net.exception;

public class NetworkException extends Exception {

    public NetworkException(Exception e) {
        super(e);
    }

    public NetworkException(String message) {
        super(message);
    }

    public NetworkException(String message, Exception e) {
        super(message, e);
    }
}
