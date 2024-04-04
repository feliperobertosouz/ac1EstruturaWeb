package me.felipe.ac1.repository;

import me.felipe.ac1.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> findAll() {

        return jdbcTemplate.query("SELECT * FROM task", (resultSet, rowNum) -> {
                    System.out.println("Numero da linha: " + rowNum);
                    return new Task(
                            resultSet.getLong("id"),
                            resultSet.getString("title"),
                            resultSet.getString("description")
                    );
                }
        );
    }

    @Override
    public Task findById(Long id) {
        String query = "SELECT * FROM task WHERE id = ?";

        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
                new Task(

                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                )
        );
    }

    @Override
    public Task save(Task task) {
        if (task.getId() != null) {
            String insertQuery = "INSERT INTO public.task (id, title, description) VALUES (?, ?, ?)";

            jdbcTemplate.update(insertQuery, task.getId(), task.getTitle(), task.getDescription());
        } else {
            String updateQuery = "UPDATE public.task SET title = ?, description = ? WHERE id = ?";
            jdbcTemplate.update(updateQuery, task.getTitle(), task.getDescription(), task.getId());
        }
        return task;
    }
}
