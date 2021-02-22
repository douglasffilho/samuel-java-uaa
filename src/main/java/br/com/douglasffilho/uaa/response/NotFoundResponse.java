package br.com.douglasffilho.uaa.response;

import br.com.douglasffilho.uaa.utils.Response;
import org.springframework.http.HttpStatus;

public class NotFoundResponse extends Response<Void> {
    public NotFoundResponse(final String reason) {
        super("not-found", reason, HttpStatus.NOT_FOUND, null);
    }
}
