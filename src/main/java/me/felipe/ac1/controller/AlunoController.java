package me.felipe.ac1.controller;

import me.felipe.ac1.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    private List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    public AlunoController() {
        alunos.add(new Aluno(nextId++, "Felipe", "Felipe@gmail.com",15,"1111","(11)1111"));
        alunos.add(new Aluno(nextId++, "João", "Joao@gmail.com",15,"2222","(22)1111"));
        alunos.add(new Aluno(nextId++, "Maria", "Maria@gmail.com",15,"3333","(33)1111"));
    }
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    @GetMapping("/{id}")
    public Aluno getAlunoByIndex(@PathVariable int id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/add")
    public Aluno addAluno(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado(a): " + aluno);
        return aluno;
    }
}
