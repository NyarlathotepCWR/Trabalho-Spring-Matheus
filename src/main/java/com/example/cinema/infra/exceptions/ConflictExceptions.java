package com.example.cinema.infra.exceptions;

public abstract class ConflictExceptions extends RuntimeException {

    // Chama o construtor de RuntimeException
    public ConflictExceptions(String message) {
        super(message);
    }

    // CPF duplicado
    public static class DuplicateCpf extends ConflictExceptions {
        public DuplicateCpf(String message) {
            super(message);
        }
    }

    // Email duplicado
    public static class DuplicateEmail extends ConflictExceptions {
        public DuplicateEmail(String message) {
            super(message);
        }
    }
}
