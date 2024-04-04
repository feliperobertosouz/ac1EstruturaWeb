package me.felipe.ac1.service;

import me.felipe.ac1.model.Aluno;

import java.util.List;

public interface TaskService {
    List<Aluno> getAllTasks();
    Aluno getTaskById(Long id);
    Aluno createTask(Aluno aluno);
}
