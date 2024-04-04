package me.felipe.ac1.service;

import me.felipe.ac1.model.Aluno;

import java.util.List;

public interface AlunoService {
    List<Aluno> getAllAlunos();
    Aluno getAlunoById(Long id);
    Aluno createAluno(Aluno task);

    Aluno removeAluno(int id);

    Aluno updateAluno(int id, Aluno aluno);
}