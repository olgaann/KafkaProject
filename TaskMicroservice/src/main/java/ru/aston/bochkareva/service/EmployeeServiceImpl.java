package ru.aston.bochkareva.service;

import com.example.core.EmployeeCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.bochkareva.entity.Employee;
import ru.aston.bochkareva.entity.Task;
import ru.aston.bochkareva.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final TaskService taskService;
    @Override
    public String createEmployee(EmployeeCreatedEvent employeeCreatedEvent) {
        Employee employee = new Employee();
        employee.setName(employeeCreatedEvent.getName());
        employee.setSurname(employeeCreatedEvent.getSurname());
        Task task = taskService.getRandomTask();
        employee.setTask(task);
        employeeRepository.save(employee);
        return employee.toString();
    }
}
