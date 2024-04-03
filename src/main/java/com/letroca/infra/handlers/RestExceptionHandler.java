package com.letroca.infra.handlers;

import com.letroca.infra.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class, BookNotFoundException.class, UsernameNotFoundException.class})
    private ResponseEntity<RestExceptionDTO> notFoundHandler(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new RestExceptionDTO(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    private ResponseEntity<RestExceptionDTO> unauthorizedHandler(UnauthorizedException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new RestExceptionDTO(HttpStatus.UNAUTHORIZED, exception.getMessage()));
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    private ResponseEntity<RestExceptionDTO> bookAlreadyExistsHandler(BookAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new RestExceptionDTO(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(TokenNotGeneratedException.class)
    private ResponseEntity<RestExceptionDTO> tokenNotGeneratedHandler(TokenNotGeneratedException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new RestExceptionDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage()));
    }
}
