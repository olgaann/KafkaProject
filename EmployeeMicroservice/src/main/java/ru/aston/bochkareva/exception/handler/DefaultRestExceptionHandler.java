package ru.aston.bochkareva.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.aston.bochkareva.exception.CustomKafkaException;

@RestControllerAdvice
public class DefaultRestExceptionHandler {

    @ExceptionHandler(CustomKafkaException.class)
    public ResponseEntity<String> handleCustomKafkaException(CustomKafkaException exception) {
        return ResponseEntity.badRequest().body("C отправкой в кафку что-то не так: " + exception.getMessage());
    }

}
