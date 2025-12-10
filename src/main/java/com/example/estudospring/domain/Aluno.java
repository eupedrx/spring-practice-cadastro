package com.example.estudospring.domain;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Aluno implements Serializable {
    @Id
    @Column(name = "matricula", unique = true,nullable = false)
    @Schema(description = "Matrícula do aluno", example = "202501")
    private Long matricula;
    @Column(name = "nome", nullable = false)
    @Schema(description = "Nome do aluno", example = "João Silva")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "curso_codigo")
    @Schema(description = "ID do curso", example = "1")
    private Curso curso;




    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", curso=" + curso +
                '}';
    }


    public Aluno() {

    }

    public Aluno(Long matricula, String nome, Curso curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public static void validarMatricula(Integer matricula) throws Exception {
        if (matricula <= 0)
            throw new Exception("A matrícula do aluno deve ser maior que zero!");
    }

    public static void validarNome(String nome) throws Exception {
        if (nome == null || nome.length() == 0)
            throw new Exception("O nome do aluno não pode ser nulo!");
    }

    public static void validarCurso(Curso curso) throws Exception {
        if (curso == null)
            throw new Exception("O aluno deve estar obrigatoriamente matriculado em um curso!");
    }
}