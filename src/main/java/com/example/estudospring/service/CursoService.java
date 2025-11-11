package com.example.estudospring.service;

import com.example.estudospring.domain.Curso;
import com.example.estudospring.domain.User;
import com.example.estudospring.exceptions.UsuarioNaoEncontradoException;
import com.example.estudospring.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    public List<Curso> listarCurso() {
        return cursoRepository.findAll();
    }

    public Curso listarCursoPorId(Long id) {

        return cursoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Curso não encontrado com ID: " + id));
    }

    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deletarCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new UsuarioNaoEncontradoException("Curso não encontrado com ID: " + id);
        }
        cursoRepository.deleteById(id);
    }

}
