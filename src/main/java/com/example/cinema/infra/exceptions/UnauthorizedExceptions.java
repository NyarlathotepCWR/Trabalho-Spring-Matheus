package com.example.cinema.infra.exceptions;

public abstract class UnauthorizedExceptions extends RuntimeException {

    public UnauthorizedExceptions(String message) {
        super(message);
    }

    public static class InvalidPassword extends UnauthorizedExceptions {
        public InvalidPassword() {
            super("Invalid password");
        }
    }
}
