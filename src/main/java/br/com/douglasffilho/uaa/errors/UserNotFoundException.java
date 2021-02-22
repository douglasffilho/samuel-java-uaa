package br.com.douglasffilho.uaa.errors;

import br.com.douglasffilho.uaa.utils.NotFound;

public class UserNotFoundException extends NotFound {
    public UserNotFoundException(final String email) {
        super(String.format("user not found by email = %s", email));
    }
}
