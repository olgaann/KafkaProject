package ru.aston.bochkareva.exception;

public class CustomKafkaException extends RuntimeException{
    public CustomKafkaException(String message) {
        super(message);
    }
}
