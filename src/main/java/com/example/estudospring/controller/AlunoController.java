package com.example.estudospring.controller;


import com.example.estudospring.domain.Aluno;
import com.example.estudospring.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class AlunoController {

    private final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/alunos")
    public ResponseEntity<String> listarAlunos() {
        return ResponseEntity.ok("Lista de alunos: " + alunoService.listarAlunos());
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<?> listarAlunosPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.listarAlunosPorId(id));
    }

    @PostMapping("/alunos/salvar")
    public ResponseEntity<String> salvarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno salvo com sucesso! Matricula: " + alunoService.salvarAluno(aluno).getMatricula());
    }

    @DeleteMapping("/alunos/deletar/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }
}
