package br.com.douglasffilho.uaa.response;

import br.com.douglasffilho.uaa.domain.User;
import br.com.douglasffilho.uaa.utils.Response;
import org.springframework.http.HttpStatus;

public class UserFoundResponse extends Response<User> {
    public UserFoundResponse(final User result) {
        super("user-found", "", HttpStatus.OK, result);
    }
}
