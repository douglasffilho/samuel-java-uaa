package br.com.douglasffilho.uaa.utils;

public abstract class NotFound extends RuntimeException {
    public NotFound(final String message) {
        super(message);
    }
}
