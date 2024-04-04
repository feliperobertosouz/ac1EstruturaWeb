package me.felipe.ac1.model;

import me.felipe.ac1.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(Long id);
    Task save(Task task);

    Task delete(int id);
}