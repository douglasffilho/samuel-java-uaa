package br.com.douglasffilho.uaa.response;

import br.com.douglasffilho.uaa.utils.Response;
import org.springframework.http.HttpStatus;

public class UserAuthenticatedResponse extends Response<String> {
    public UserAuthenticatedResponse(final String token) {
        super("user-authenticated", "", HttpStatus.OK, token);
    }
}
