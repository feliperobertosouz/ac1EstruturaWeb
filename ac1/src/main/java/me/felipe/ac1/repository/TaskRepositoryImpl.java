package me.felipe.ac1.repository;

import me.felipe.ac1.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public TaskRepositoryImpl() {
        // Adiciona algumas tarefas pré-cadastradas
        tasks.add(new Task(1L, "Estudar para a prova de matemática", "Revisar cálculos e geometria"));
        tasks.add(new Task(2L, "Fazer compras no mercado", "Comprar vegetais, carne e itens de limpeza"));
        tasks.add(new Task(3L, "Preparar apresentação para o trabalho", "Criar slides e ensaiar apresentação"));
        nextId = 4L; // Atualiza o próximo ID
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(nextId++);
            tasks.add(task);
        } else {
            tasks.removeIf(t -> t.getId().equals(task.getId()));
            tasks.add(task);
        }
        return task;
    }
}
