package me.felipe.ac1.service;

import me.felipe.ac1.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);

    Task removeTask(int id);
}
