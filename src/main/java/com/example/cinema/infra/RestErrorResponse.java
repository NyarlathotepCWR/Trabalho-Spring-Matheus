package com.example.cinema.infra;

import org.springframework.http.HttpStatus;

public class RestErrorResponse {
    private HttpStatus status;
    private String message;

    public RestErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
