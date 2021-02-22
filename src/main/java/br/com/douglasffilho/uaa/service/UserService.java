package br.com.douglasffilho.uaa.service;

import br.com.douglasffilho.uaa.domain.User;
import br.com.douglasffilho.uaa.errors.BadRequestException;
import br.com.douglasffilho.uaa.errors.UserNotFoundException;
import br.com.douglasffilho.uaa.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(final UserRepository repository, final PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(final String email) {
        return this.repository.findById(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    public User create(final User user) {
        try {
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            return this.repository.save(user);
        } catch (Exception ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }
}
