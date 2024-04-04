package me.felipe.ac1.controller;

import me.felipe.ac1.model.Aluno;
import me.felipe.ac1.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    private final AlunoService alunoService;


    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunoService.getAlunoById(id);
    }

    @PostMapping("/add")
    public Aluno createAluno(@RequestBody Aluno task) {
        return alunoService.createAluno(task);
    }


    @DeleteMapping("/remove/{id}")
    public Aluno removeAluno(@PathVariable int id) {
        return alunoService.removeAluno(id);
    }

    @PutMapping("/update/{id}")
    public Aluno updateAluno(@PathVariable int id, @RequestBody Aluno aluno){
        return alunoService.updateAluno(id, aluno);
    }
}