package br.com.douglasffilho.uaa.utils;

import org.springframework.http.HttpStatus;

public abstract class Response<T> {
    private final String message;
    private final String reason;
    private final HttpStatus status;
    private final T result;

    public Response(final String message, final String reason, final HttpStatus status, final T result) {
        this.message = message;
        this.reason = reason;
        this.status = status;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }
}
