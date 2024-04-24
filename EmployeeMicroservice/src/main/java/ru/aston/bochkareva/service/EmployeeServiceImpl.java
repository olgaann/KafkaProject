package ru.aston.bochkareva.service;

import lombok.extern.slf4j.Slf4j;
import ru.aston.bochkareva.core.EmployeeCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.aston.bochkareva.dto.CreateEmployeeDto;
import ru.aston.bochkareva.entity.Employee;
import ru.aston.bochkareva.exception.CustomKafkaException;
import ru.aston.bochkareva.mapper.EmployeeMapper;
import ru.aston.bochkareva.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final KafkaTemplate<String, EmployeeCreatedEvent> kafkaTemplate;


    @Override
    public String createEmployee(CreateEmployeeDto createEmployeeDto) {
        Employee employee = employeeMapper.mapCreateEmployeeDTOToEmployee(createEmployeeDto);
        employeeRepository.save(employee);
        EmployeeCreatedEvent employeeCreatedEvent = new EmployeeCreatedEvent(createEmployeeDto.getName(), createEmployeeDto.getSurname());

        SendResult<String, EmployeeCreatedEvent> result;
        try {
            result = kafkaTemplate
                    .send("employee-created-events-topic", "someKey", employeeCreatedEvent).get();
        } catch (Exception e) {
            String message = e.getMessage();
            throw new CustomKafkaException(message);
        }

        log.info("Topic: {}", result.getRecordMetadata().topic());
        log.info("Partition: {}", result.getRecordMetadata().partition());
        log.info("Return: {}", employee.toString());

        return String.join(" ", employee.getName(), employee.getSurname());
    }
}
