package br.com.douglasffilho.uaa.response;

import br.com.douglasffilho.uaa.domain.User;
import br.com.douglasffilho.uaa.utils.Response;
import org.springframework.http.HttpStatus;

public class UserCreatedResponse extends Response<User> {
    public UserCreatedResponse(final User result) {
        super("user-created", "", HttpStatus.CREATED, result);
    }
}
