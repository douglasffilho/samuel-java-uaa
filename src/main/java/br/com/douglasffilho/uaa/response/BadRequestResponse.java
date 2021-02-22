package br.com.douglasffilho.uaa.response;

import br.com.douglasffilho.uaa.utils.Response;
import org.springframework.http.HttpStatus;

public class BadRequestResponse extends Response<Void> {
    public BadRequestResponse(final String reason) {
        super("bad-request", reason, HttpStatus.BAD_REQUEST, null);
    }
}
