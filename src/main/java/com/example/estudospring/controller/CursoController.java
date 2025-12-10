package com.example.estudospring.controller;


import com.example.estudospring.docs.CursoControllerDoc;
import com.example.estudospring.repository.CursoRepository;
import com.example.estudospring.domain.Curso;
import com.example.estudospring.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CursoController implements CursoControllerDoc {


    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/cursos")
    @Override
    public ResponseEntity<String> listarCursos() {
        return ResponseEntity.ok("Lista de cursos: " + cursoService.listarCurso());
    }

    @GetMapping("/cursos/{id}")
    @Override
    public ResponseEntity<?> listarCursosPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.listarCursoPorId(id));
    }

    @PostMapping("/cursos/salvar")
    @Override
    public ResponseEntity<String> salvarCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Curso salvo com sucesso! ID: " + cursoService.salvarCurso(curso).getId());
    }

    @DeleteMapping("/cursos/deletar/{id}")
    @Override
    public void deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
    }

}
