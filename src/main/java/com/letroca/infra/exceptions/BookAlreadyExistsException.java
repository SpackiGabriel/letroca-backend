package com.letroca.infra.exceptions;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException() { super("A book with the same ISBN already exists for this user."); }
    public BookAlreadyExistsException(String message) { super(message); }
}
