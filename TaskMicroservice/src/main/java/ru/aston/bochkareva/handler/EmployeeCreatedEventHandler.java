package ru.aston.bochkareva.handler;

import lombok.extern.slf4j.Slf4j;
import ru.aston.bochkareva.core.EmployeeCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.aston.bochkareva.service.EmployeeService;

@Component
@KafkaListener(topics = "employee-created-events-topic")
@RequiredArgsConstructor
@Slf4j
public class EmployeeCreatedEventHandler {

    private final EmployeeService employeeService;
    @KafkaHandler
    public void handle(EmployeeCreatedEvent employeeCreatedEvent) {
        log.info("Received event: {}", employeeCreatedEvent.toString());
        String newEmployeeInfo = employeeService.createEmployee(employeeCreatedEvent);
        log.info("Employee has been created and assigned a task: {}", newEmployeeInfo);
    }
}
