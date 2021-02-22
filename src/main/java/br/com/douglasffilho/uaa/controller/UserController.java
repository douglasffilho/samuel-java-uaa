package br.com.douglasffilho.uaa.controller;

import br.com.douglasffilho.authorizationservice.annotations.IsManager;
import br.com.douglasffilho.authorizationservice.config.JwtToken;
import br.com.douglasffilho.uaa.domain.User;
import br.com.douglasffilho.uaa.errors.BadRequestException;
import br.com.douglasffilho.uaa.response.UserAuthenticatedResponse;
import br.com.douglasffilho.uaa.response.UserCreatedResponse;
import br.com.douglasffilho.uaa.response.UserFoundResponse;
import br.com.douglasffilho.uaa.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public UserCreatedResponse create(@RequestBody User toCreate) {
        User created = this.service.create(toCreate);
        return new UserCreatedResponse(created);
    }

    @PostMapping("/authenticate")
    public UserAuthenticatedResponse authenticate(
            @RequestParam(name = "username") final String username,
            @RequestParam(name = "password") final String password
    ) {
        User found = this.service.findByEmail(username);
        boolean matches = this.passwordEncoder.matches(password, found.getPassword());

        if (!matches)
            throw new BadRequestException("user password not matches");

        Date expiresAt = Date.from(LocalDateTime.now()
                .plusHours(12)
                .toInstant(ZoneOffset.ofHours(-3)));

        String authenticationToken = JWT
                .create()
                .withClaim("email", found.getEmail())
                .withClaim("roles", found.getRoles())
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC512(JwtToken.TOKEN));

        return new UserAuthenticatedResponse(authenticationToken);
    }

    @IsManager
    @GetMapping("/{email}")
    public UserFoundResponse findByEmail(@PathVariable String email) {
        User user = this.service.findByEmail(email);
        return new UserFoundResponse(user);
    }
}
