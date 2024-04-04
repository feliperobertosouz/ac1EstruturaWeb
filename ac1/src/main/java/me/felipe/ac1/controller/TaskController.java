package me.felipe.ac1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private List<String> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add("Estudar para a prova de matemática");
        tasks.add("Estudar para alguma prova ai ");
        tasks.add("Peeeeeeeeeeeeeee");
    }
    @GetMapping
    public List<String> getAllTasks() {
        return tasks;
    }

    @GetMapping("/{task}")
    public String getTaskByIndex(@PathVariable int task) {
        if (task >= 0 && task < tasks.size()) {
            return tasks.get(task);
        } else {
            return "Tarefa não encontrada";
        }
    }

    @PostMapping("/add")
    public void addTask(@RequestBody String task) {
        tasks.add(task); // Adiciona a tarefa recebida aos dados simulados
        System.out.println("Tarefa adicionada: " + task); // Exibe os dados recebidos via POST no console
    }
}
