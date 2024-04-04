package me.felipe.ac1.repository;

import me.felipe.ac1.model.Aluno;

import java.util.List;

public interface AlunoRepository {
    List<Aluno> findAll();
    Aluno findById(Long id);
    Aluno save(Aluno aluno);
}