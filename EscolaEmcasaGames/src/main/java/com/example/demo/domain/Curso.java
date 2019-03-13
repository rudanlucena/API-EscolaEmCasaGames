package com.example.demo.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Curso {

    //private CursoPK PK;
    @Id
    private int id;
    private String nome;

    @OneToMany(cascade = CascadeType.REMOVE)
    @ApiModelProperty(hidden = true)
    private List<Aluno> alunos;

    @ManyToOne
    @JsonIgnore
    private LMS lms;
    //atributo utilizado para recuperar o id do lms e formar o id do curso (id = idLMS + idCurso)
    private transient String urlMLS;

    public Curso(){

    }

    public Curso(String nome, int id, String urlLMS){
        this.nome = nome;
        this.id = id;
        this.urlMLS = urlLMS;
        alunos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlMLS() {
        return urlMLS;
    }

    public void setUrlMLS(String urlMLS) {
        this.urlMLS = urlMLS;
    }

    public LMS getLms() {
        return lms;
    }

    public void setLms(LMS lms) {
        this.lms = lms;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno){
        alunos.remove(aluno);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) &&
                Objects.equals(nome, curso.nome) &&
                Objects.equals(urlMLS, curso.urlMLS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, urlMLS);
    }
}
