package com.example.estudospring.service;

import com.example.estudospring.domain.Curso;
import com.example.estudospring.exceptions.CursoNaoEncontradoException;
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
                .orElseThrow(() -> new CursoNaoEncontradoException("Curso não encontrado com ID: " + id));
    }

    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new CursoNaoEncontradoException("Curso não encontrado com ID: " + id));

        curso.setNome(cursoAtualizado.getNome());
        curso.setId(cursoAtualizado.getId());
        // Atualize outros campos necessários

        return cursoRepository.save(curso);
    }

    public void deletarCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new CursoNaoEncontradoException("Curso não encontrado com ID: " + id);
        }
        cursoRepository.deleteById(id);
    }

}
