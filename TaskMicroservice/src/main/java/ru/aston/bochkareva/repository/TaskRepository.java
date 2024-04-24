package ru.aston.bochkareva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.bochkareva.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
