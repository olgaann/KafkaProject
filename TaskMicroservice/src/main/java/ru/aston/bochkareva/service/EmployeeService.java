package ru.aston.bochkareva.service;

import ru.aston.bochkareva.core.EmployeeCreatedEvent;

public interface EmployeeService {
    String createEmployee(EmployeeCreatedEvent employeeCreatedEvent);
}
