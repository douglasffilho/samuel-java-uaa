package br.com.douglasffilho.uaa.controller.handler;

import br.com.douglasffilho.uaa.errors.BadRequestException;
import br.com.douglasffilho.uaa.errors.UserNotFoundException;
import br.com.douglasffilho.uaa.response.BadRequestResponse;
import br.com.douglasffilho.uaa.response.NotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestResponse> handleBadRequest(BadRequestException ex) {
        BadRequestResponse response = new BadRequestResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<NotFoundResponse> handleNotFound(UserNotFoundException ex) {
        NotFoundResponse response = new NotFoundResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
