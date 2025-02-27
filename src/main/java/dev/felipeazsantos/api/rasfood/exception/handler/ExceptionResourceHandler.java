package dev.felipeazsantos.api.rasfood.exception.handler;

import dev.felipeazsantos.api.rasfood.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResourceHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Void> notFoundException(NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}
