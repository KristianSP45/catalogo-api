package com.kristian.catalogoapi.infrastructure.exceptions;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
