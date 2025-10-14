package com.example.cinema.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.cinema.infra.exceptions.ConflictExceptions;
import com.example.cinema.infra.exceptions.NotFoundExceptions;
import com.example.cinema.infra.exceptions.UnauthorizedExceptions;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // Constrói a resposta de erro
    private ResponseEntity<RestErrorResponse> buildErrorResponse(HttpStatus status, String message) {
        RestErrorResponse responseError = new RestErrorResponse(status, message);

        return ResponseEntity.status(responseError.getStatus()).body(responseError);
    }

    // Exceções de CONFLICT
    @ExceptionHandler({
            ConflictExceptions.DuplicateCpf.class,
            ConflictExceptions.DuplicateEmail.class,
    })
    private ResponseEntity<RestErrorResponse> handleConflict(RuntimeException exception) {
        return buildErrorResponse(HttpStatus.CONFLICT, exception.getMessage());
    }

    // Exceções de NOT_FOUND
    @ExceptionHandler({
            NotFoundExceptions.MovieNotFound.class,
            NotFoundExceptions.OrderNotFound.class,
            NotFoundExceptions.SeatNotFound.class,
            NotFoundExceptions.UserNotFound.class,
            NotFoundExceptions.SessionNotFound.class,
    })
    private ResponseEntity<RestErrorResponse> handleNotFound(RuntimeException exception) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    // Exceções de UNAUTHORIZED
    @ExceptionHandler({
            UnauthorizedExceptions.InvalidPassword.class,
    })
    private ResponseEntity<RestErrorResponse> handleUnauthorized(RuntimeException exception) {
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, exception.getMessage());
    }
}
