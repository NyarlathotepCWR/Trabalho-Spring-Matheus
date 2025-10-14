package com.example.cinema.infra.exceptions;

public abstract class NotFoundExceptions extends RuntimeException {

    // Chama o construtor de RuntimeException
    public NotFoundExceptions(String message) {
        super(message);
    }

    // Filme não encontrado
    public static class MovieNotFound extends NotFoundExceptions {
        public MovieNotFound(Long id) {
            super("Movie not found with id: " + id);
        }
    }

    // Pedido não encontrado
    public static class OrderNotFound extends NotFoundExceptions {
        public OrderNotFound(Long id) {
            super("Order not found with id: " + id);
        }
    }

    // Assento não encontrado
    public static class SeatNotFound extends NotFoundExceptions {
        public SeatNotFound(Long id) {
            super("Seat not found with id: " + id);
        }
    }

    // Usuario não encontrado
    public static class UserNotFound extends NotFoundExceptions {
        public UserNotFound(Long id) {
            super("User not found with id: " + id);
        }

        public UserNotFound(String email) {
            super("User not found with email: " + email);
        }
    }

    // Sessão não encontrada
    public static class SessionNotFound extends NotFoundExceptions {
        public SessionNotFound(Long id) {
            super("Session not found with id: " + id);
        }
    }
}
