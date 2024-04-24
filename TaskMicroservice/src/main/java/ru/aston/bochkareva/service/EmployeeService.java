package ru.aston.bochkareva.service;

import com.example.core.EmployeeCreatedEvent;

public interface EmployeeService {
    String createEmployee(EmployeeCreatedEvent employeeCreatedEvent);
}
