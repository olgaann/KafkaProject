package ru.aston.bochkareva.service;

import com.example.core.EmployeeCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final KafkaTemplate<String, EmployeeCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String createEmployee(CreateEmployeeDto createEmployeeDto) {
        Employee employee = employeeMapper.mapCreateEmployeeDTOToEmployee(createEmployeeDto);
        employeeRepository.save(employee);
        EmployeeCreatedEvent employeeCreatedEvent = new EmployeeCreatedEvent(createEmployeeDto.getName(), createEmployeeDto.getSurname());

        SendResult<String, EmployeeCreatedEvent> result;
        try {
            result = kafkaTemplate
                    .send("employee-created-events-topic",employeeCreatedEvent).get();
        } catch (Exception e){
            String message = e.getMessage();
            throw new CustomKafkaException(message);
        }

        LOGGER.info("Topic: {}", result.getRecordMetadata().topic());
        LOGGER.info("Partition: {}", result.getRecordMetadata().partition());
        LOGGER.info("Return: {}", employee.toString());

        return String.join(" ", employee.getName(), employee.getSurname());
    }
}
