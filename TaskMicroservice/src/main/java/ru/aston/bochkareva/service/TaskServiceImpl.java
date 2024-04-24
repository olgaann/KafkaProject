package ru.aston.bochkareva.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.bochkareva.entity.Task;
import ru.aston.bochkareva.repository.TaskRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private Random random = new Random();

    @Override
    public Task getRandomTask() {
        List<Task> taskList = taskRepository.findAll();
        int randomNumber = random.nextInt(taskList.size());
        return taskList.get(randomNumber);
    }
}
