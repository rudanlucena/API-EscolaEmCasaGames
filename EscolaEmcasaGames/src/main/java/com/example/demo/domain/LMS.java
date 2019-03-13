package com.example.demo.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class LMS {
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private int id;
    @Column(unique = true)
    private String url;
    @Column(unique = true)
    private String nome;
    @OneToMany(cascade = CascadeType.REMOVE)
    @ApiModelProperty(hidden = true)
    private List<Curso> cursos;

    public LMS(){

    }

    public LMS(String url, String nome){
        this.url = url;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void addCurso(Curso curso){
        this.cursos.add(curso);
    }

    public void removeCurso(Curso curso){
        this.cursos.remove(curso);
    }
}
