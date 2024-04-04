package me.felipe.ac1.controller;

import me.felipe.ac1.model.Aluno;
import me.felipe.ac1.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class AlunoController {
    private final TaskService taskService;

    /*
     a injeção de dependência é visível no construtor da classe TaskController. TaskController depende de TaskService,
     que é passado como um parâmetro no construtor. O Spring será responsável por injetar uma instância de TaskService
     quando criar uma instância de TaskController.
     */
    public AlunoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Aluno> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Aluno getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/add")
    public Aluno createTask(@RequestBody Aluno aluno) {
        return taskService.createTask(aluno);
    }
}
