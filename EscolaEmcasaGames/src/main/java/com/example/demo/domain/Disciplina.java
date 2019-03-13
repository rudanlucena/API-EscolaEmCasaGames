package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue
    private int id;
    private String anoEnsino;
    private String disciplina;

    public Disciplina(){

    }

    public Disciplina(String anoEnsino, String disciplina){
        this.anoEnsino = anoEnsino;
        this.disciplina = disciplina;
    }

    public String getAnoEnsino() {
        return anoEnsino;
    }

    public void setAnoEnsino(String anoEnsino) {
        this.anoEnsino = anoEnsino;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(anoEnsino, that.anoEnsino) &&
                Objects.equals(disciplina, that.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anoEnsino, disciplina);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", anoEnsino='" + anoEnsino + '\'' +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
