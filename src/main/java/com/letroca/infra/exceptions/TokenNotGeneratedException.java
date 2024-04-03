package com.letroca.infra.exceptions;

public class TokenNotGeneratedException extends RuntimeException {
    public TokenNotGeneratedException() { super("Error while generating token"); }
    public TokenNotGeneratedException(String message) { super(message); }
}
