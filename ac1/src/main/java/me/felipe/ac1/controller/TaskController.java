package me.felipe.ac1.controller;

import me.felipe.ac1.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public TaskController() {
        tasks.add(new Task(nextId++, "Estudar para a prova de matemática", "Revisar álgebra e geometria"));
        tasks.add(new Task(nextId++, "Fazer compras no mercado", "Comprar itens de casa"));
        tasks.add(new Task(nextId++, "Preparar apresentação para o trabalho", "Preparar slides e dados para apresentação"));
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    @GetMapping("/{task}")
    public Task getTaskByIndex(@PathVariable int id) {
        System.out.println("ID RECEBIDO " + id);
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        tasks.add(task);
        System.out.println("Tarefa adicionada: " + task); // Exibe os dados recebidos via POST no console
        return task; // Retorna a tarefa adicionada
    }
}
