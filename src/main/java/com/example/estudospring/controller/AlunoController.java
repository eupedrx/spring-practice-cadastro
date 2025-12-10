package com.example.estudospring.controller;


import com.example.estudospring.docs.AlunoControllerDoc;
import com.example.estudospring.domain.Aluno;
import com.example.estudospring.security.SecurityConfig;
import com.example.estudospring.service.AlunoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class AlunoController implements AlunoControllerDoc {

    private final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/alunos")
    @Override
    public ResponseEntity<String> listarAlunos() {
        return ResponseEntity.ok("Lista de alunos: " + alunoService.listarAlunos());
    }

    @GetMapping("/alunos/{id}")
    @Override
    public ResponseEntity<?> listarAlunosPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.listarAlunosPorId(id));
    }

    @PostMapping("/alunos/salvar")
    @Override
    public ResponseEntity<String> salvarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno salvo com sucesso! Matricula: " + alunoService.salvarAluno(aluno).getMatricula());
    }

    @DeleteMapping("/alunos/deletar/{id}")
    @Override
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }
}
