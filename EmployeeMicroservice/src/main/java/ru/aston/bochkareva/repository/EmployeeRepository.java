package ru.aston.bochkareva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.bochkareva.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
