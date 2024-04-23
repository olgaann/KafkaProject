package ru.aston.bochkareva.mapper;

import org.mapstruct.Mapper;
import ru.aston.bochkareva.dto.CreateEmployeeDto;
import ru.aston.bochkareva.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee mapCreateEmployeeDTOToEmployee(CreateEmployeeDto createEmployeeDto);
}
