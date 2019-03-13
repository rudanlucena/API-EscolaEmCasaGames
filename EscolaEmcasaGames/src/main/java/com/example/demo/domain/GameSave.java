package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class GameSave {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JsonIgnore
    private Game game;
    @JsonIgnore
    @ManyToOne
    private Aluno aluno;
    private transient int gameID;
    private transient int alunoID;
    private double pontuacao;
    private double tempo;
    private LocalDateTime data;

    public GameSave(){

    }

    public GameSave(Game game, double pontuacao, double tempo){
        this.game = game;
        this.pontuacao = pontuacao;
        this.tempo = tempo;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getAlunoID() {
        return alunoID;
    }

    public void setAlunoID(int alunoID) {
        this.alunoID = alunoID;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSave gameSave = (GameSave) o;
        return Double.compare(gameSave.pontuacao, pontuacao) == 0 &&
                Double.compare(gameSave.tempo, tempo) == 0 &&
                Objects.equals(game, gameSave.game) &&
                Objects.equals(data, gameSave.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, pontuacao, tempo, data);
    }

    @Override
    public String toString() {
        return "GameSave{" +
                ", game=" + game +
                ", pontuacao=" + pontuacao +
                ", tempo=" + tempo +
                ", data='" + data + '\'' +
                '}';
    }
}
