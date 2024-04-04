package me.felipe.ac1.service;

import me.felipe.ac1.model.Aluno;
import me.felipe.ac1.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Aluno> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Aluno getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Aluno createTask(Aluno aluno) {
        return taskRepository.save(aluno);
    }
}