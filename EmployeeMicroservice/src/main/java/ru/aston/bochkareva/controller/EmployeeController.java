package ru.aston.bochkareva.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.bochkareva.dto.CreateEmployeeDto;
import ru.aston.bochkareva.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto) {
        String employeeData = employeeService.createEmployee(createEmployeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("New employee %s created", employeeData));
    }
}
