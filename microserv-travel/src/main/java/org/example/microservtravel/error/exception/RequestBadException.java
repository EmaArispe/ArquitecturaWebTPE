package org.example.microservtravel.error.exception;

import jakarta.ws.rs.BadRequestException;

public class RequestBadException extends BadRequestException {
    public RequestBadException(String message) {
        super(message);
    }
}