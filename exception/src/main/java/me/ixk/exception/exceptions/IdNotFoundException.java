package me.ixk.exception.exceptions;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException() {
        super("Id not found.");
    }
}
