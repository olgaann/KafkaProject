package ru.aston.bochkareva.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateEmployeeDto {
    private String name;
    private String surname;
}
