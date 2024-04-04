package me.felipe.ac1.controller;

import me.felipe.ac1.model.Task;
import me.felipe.ac1.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/add")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }


    @DeleteMapping("/remove/{id}")
    public Task removeTask(@PathVariable int id) {
        return taskService.removeTask(id);
    }
}