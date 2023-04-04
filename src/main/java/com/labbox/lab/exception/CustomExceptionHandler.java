package com.labbox.lab.exception;

import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), "Bad credentials", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<ErrorResponse> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "User not found", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), "Authentication failed", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenInvalidException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseEntity<ErrorResponse> handleTokenInvalidException(TokenInvalidException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), "Invalid token", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenMissingException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseEntity<ErrorResponse> handleTokenMissingException(TokenMissingException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), "Missing token", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseEntity<ErrorResponse> handleTokenExpiredException(TokenExpiredException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), "Token expired", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }


}
