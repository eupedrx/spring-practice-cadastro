package com.example.estudospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
public class Curso implements Serializable {
    @Id
    @Column(name = "codigo")
    @Schema(description = "Código do curso", example = "1")
    private Long id;
    @Column(name = "nome", nullable = false)
    @Schema(description = "Nome do curso", example = "Sistemas de Informação")
    private String nome;
    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<Aluno> listaAlunos;

    public Curso() {

    }

    public Curso(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public boolean adicionarAluno(Aluno novo) throws Exception {
        if (novo == null)
            throw new Exception("O aluno não pode ser nulo.");
        return this.listaAlunos.add(novo);
    }

    public boolean removerAluno(Aluno ex) throws Exception {
        if (ex == null)
            throw new Exception("O aluno não pode ser nulo.");
        return this.listaAlunos.remove(ex);
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public static void validarCodigo(int codigo) throws Exception {
        if (codigo <= 0)
            throw new Exception("O código do curso deve ser maior que zero!");
    }

    public static void validarNome(String nome) throws Exception {
        if (nome == null || nome.length() == 0)
            throw new Exception("O nome do curso não pode ser nulo!");
    }
}