package com.letroca.infra.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() { super("Not authorized."); }
    public UnauthorizedException(String message) { super(message); }
}
