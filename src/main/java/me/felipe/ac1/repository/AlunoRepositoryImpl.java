package me.felipe.ac1.repository;

import me.felipe.ac1.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();
    private int nextId = 1;

    public AlunoRepositoryImpl() {
        // Adiciona algumas tarefas pré-cadastradas
        alunos.add(new Aluno(nextId++, "Felipe", "Felipe@gmail.com",15,"1111","(11)1111"));
        alunos.add(new Aluno(nextId++, "João", "Joao@gmail.com",15,"2222","(22)1111"));
        alunos.add(new Aluno(nextId++, "Maria", "Maria@gmail.com",15,"3333","(33)1111"));
        nextId = 4; // Atualiza o próximo ID
    }

    @Override
    public List<Aluno> findAll() {
        return alunos;
    }

    @Override
    public Aluno findById(Long id) {
        return alunos.stream()
                .filter(Aluno -> Aluno.getId() == (id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno save(Aluno aluno) {
        if (aluno.getId() == 0) {
            aluno.setId(nextId++);
            alunos.add(aluno);
        } else {
            alunos.removeIf(t -> t.getId() == (aluno.getId()));
            alunos.add(aluno);
        }
        return aluno;
    }
}
