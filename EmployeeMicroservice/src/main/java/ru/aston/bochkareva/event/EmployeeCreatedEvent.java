package ru.aston.bochkareva.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeCreatedEvent {
    private String name;
    private String surname;

    public EmployeeCreatedEvent(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
