package br.com.douglasffilho.uaa.utils;

public abstract class BadRequest extends RuntimeException {
    public BadRequest(final String message) {
        super(message);
    }
}
