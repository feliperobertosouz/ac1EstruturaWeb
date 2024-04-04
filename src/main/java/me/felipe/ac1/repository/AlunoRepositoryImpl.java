package me.felipe.ac1.repository;

import me.felipe.ac1.model.Aluno;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {

    private final JdbcTemplate jdbcTemplate;

    public AlunoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aluno> findAll() {
        return jdbcTemplate.query("SELECT * FROM public.aluno", (resultSet, rowNum) -> {
                    System.out.println("Número da linha: " + rowNum);
                    return new Aluno(
                            resultSet.getLong("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("email"),
                            resultSet.getInt("idade"),
                            resultSet.getString("cpf"),
                            resultSet.getString("telefone")
                    );
                }
        );
    }

    @Override
    public Aluno findById(Long id) {
        String query = "SELECT * FROM public.aluno WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
                new Aluno(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getInt("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("telefone")
                )
        );
    }

    @Override
    public Aluno save(Aluno aluno) {
        if (aluno.getId() != null) {
            String insertQuery = "INSERT INTO aluno (nome, email, idade, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(insertQuery, aluno.getNome(), aluno.getEmail(), aluno.getIdade(), aluno.getCpf(), aluno.getTelefone());
        } else {
            String updateQuery = "UPDATE aluno SET nome = ?, email = ?, idade = ?, cpf = ?, telefone = ? WHERE id = ?";
            jdbcTemplate.update(updateQuery, aluno.getNome(), aluno.getEmail(), aluno.getIdade(), aluno.getCpf(), aluno.getTelefone(), aluno.getId());
        }
        return aluno;
    }
}
