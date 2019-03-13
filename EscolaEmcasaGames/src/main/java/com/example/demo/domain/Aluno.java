package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno {
    @Id
    private int id;
    private String nome;
    private String email;
    private transient int idCurso;

    @ManyToOne
    @JsonIgnore
    private Curso curso;

    @OneToMany
    @Cascade(CascadeType.REMOVE)
    @ApiModelProperty(hidden = true)
    private List<GameSave> gamesSaved;

    public Aluno(){

    }

    public Aluno(String nome, int id, int idCurso){
        gamesSaved = new ArrayList<>();
        this.nome = nome;
        this.id = id;
        this.id = idCurso;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<GameSave> getGamesSaved() {
        return gamesSaved;
    }

    public void setGamesSaved(List<GameSave> gamesSaved) {
        this.gamesSaved = gamesSaved;
    }

    public void addGameSaved(GameSave gameSave){
        gamesSaved.add(gameSave);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id &&
                idCurso == aluno.idCurso &&
                Objects.equals(nome, aluno.nome) &&
                Objects.equals(email, aluno.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, idCurso);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idCurso=" + idCurso +
                ", curso=" + curso +
                ", gamesSaved=" + gamesSaved +
                '}';
    }
}
