package com.example.estudospring.service;

import com.example.estudospring.domain.Aluno;
import com.example.estudospring.domain.Curso;
import com.example.estudospring.domain.User;
import com.example.estudospring.exceptions.UsuarioNaoEncontradoException;
import com.example.estudospring.repository.AlunoRepository;
import com.example.estudospring.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }


    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno listarAlunosPorId(Long id) {

        return alunoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
    }

    public Aluno salvarAluno(Aluno aluno) {
        if (aluno.getCurso() != null && aluno.getCurso().getId() != null) {
            // Busca o curso existente no banco
            Curso cursoExistente = cursoRepository.findById(aluno.getCurso().getId())
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado com código: " + aluno.getCurso().getId()));

            // Reassocia o curso "gerenciado" ao aluno
            aluno.setCurso(cursoExistente);
        }
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id);
        }
       alunoRepository.deleteById(id);
    }

}
