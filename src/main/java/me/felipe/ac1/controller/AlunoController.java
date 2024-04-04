package me.felipe.ac1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    private List<String> alunos = new ArrayList<>();

    public AlunoController() {
        alunos.add("João");
        alunos.add("Felipe");
        alunos.add("Maria");
    }
    @GetMapping
    public List<String> getAllalunos() {
        return alunos;
    }

    @GetMapping("/{aluno}")
    public String getAlunoByIndex(@PathVariable int aluno) {
        if (aluno >= 0 && aluno < alunos.size()) {
            return alunos.get(aluno);
        } else {
            return "Aluno não encontrada";
        }
    }

    @PostMapping("/add")
    public void addaluno(@RequestBody String aluno) {
        alunos.add(aluno); 
        System.out.println("Aluno(a) adicionada: " + aluno);
    }
}
