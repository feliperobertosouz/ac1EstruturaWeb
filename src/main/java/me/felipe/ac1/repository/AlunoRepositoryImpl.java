package me.felipe.ac1.repository;

import me.felipe.ac1.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    public AlunoRepositoryImpl() {
        // Adiciona algumas tarefas pré-cadastradas
        alunos.add(new Aluno(1L, "Estudar para a prova de matemática", "Revisar cálculos e geometria"));
        alunos.add(new Aluno(2L, "Fazer compras no mercado", "Comprar vegetais, carne e itens de limpeza"));
        alunos.add(new Aluno(3L, "Preparar apresentação para o trabalho", "Criar slides e ensaiar apresentação"));
        nextId = 4L; // Atualiza o próximo ID
    }

    @Override
    public List<Aluno> findAll() {
        return alunos;
    }

    @Override
    public Aluno findById(Long id) {
        return alunos.stream()
                .filter(Aluno -> Aluno.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno save(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(nextId++);
            alunos.add(aluno);
        } else {
            alunos.removeIf(t -> t.getId().equals(aluno.getId()));
            alunos.add(aluno);
        }
        return aluno;
    }
}
