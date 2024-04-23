package ru.aston.bochkareva.exception.handler;

public class CustomKafkaException extends RuntimeException{
    public CustomKafkaException(String message) {
        super(message);
    }
}
