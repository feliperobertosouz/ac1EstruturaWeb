package me.felipe.ac1.model;

import me.felipe.ac1.model.Aluno;

import java.util.List;

public interface AlunoRepository {
    List<Aluno> findAll();
    Aluno findById(Long id);
    Aluno save(Aluno task);

    Aluno delete(int id);

    Aluno update(int id, Aluno aluno);
}