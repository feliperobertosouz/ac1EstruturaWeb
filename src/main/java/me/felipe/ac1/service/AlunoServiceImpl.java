package me.felipe.ac1.service;

import me.felipe.ac1.model.Aluno;
import me.felipe.ac1.model.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getAlunoById(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    public Aluno createAluno(Aluno task) {
        return alunoRepository.save(task);
    }

    @Override
    public Aluno removeAluno(int id) {
        return alunoRepository.delete(id);
    }

    @Override
    public Aluno updateAluno(int id, Aluno aluno) {
        return alunoRepository.update(id, aluno);
    }
}