package ru.aston.bochkareva.handler;

import com.example.core.EmployeeCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.aston.bochkareva.service.EmployeeService;

@Component
@KafkaListener(topics = "employee-created-events-topic")
@RequiredArgsConstructor
public class EmployeeCreatedEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final EmployeeService employeeService;
    @KafkaHandler
    public void handle(EmployeeCreatedEvent employeeCreatedEvent) {
        LOGGER.info("Received event: {}", employeeCreatedEvent.toString());
        String newEmployeeInfo = employeeService.createEmployee(employeeCreatedEvent);
        LOGGER.info("Employee has been created and assigned a task: {}", newEmployeeInfo);
    }
}
