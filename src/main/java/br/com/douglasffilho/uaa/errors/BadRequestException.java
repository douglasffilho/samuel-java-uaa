package br.com.douglasffilho.uaa.errors;

import br.com.douglasffilho.uaa.utils.NotFound;

public class BadRequestException extends NotFound {
    public BadRequestException(final String message) {
        super(message);
    }
}
