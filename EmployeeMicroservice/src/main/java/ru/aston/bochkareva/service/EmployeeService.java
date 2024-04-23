package ru.aston.bochkareva.service;

import ru.aston.bochkareva.dto.CreateEmployeeDto;

public interface EmployeeService {
    String createEmployee(CreateEmployeeDto createEmployeeDto);
}
