package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Game {

	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String nome;
	@OneToOne
	private Disciplina disciplina;
	private String link; //derivado do nome do jogo
	private String icone; //derivado do nome do jogo
	private double reputacao; //A avaliacao será medida em uma escala de 1 a 5 estrelas;
	private String gamePlay;
	private String comentarios; //A lista de comentarios será diferente pra cada curso;
	private String resumo;

	public Game() {
		
	}
	
	public Game(String nome, Disciplina disciplina, String resumo, String gamePlay) {
		super();
		this.nome = nome;
		this.resumo = resumo;
		this.disciplina = disciplina;
		this.gamePlay = gamePlay;

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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public double getReputacao() {
		return reputacao;
	}

	public void setReputacao(double reputacao) {
		this.reputacao = reputacao;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getGamePlay() {
		return gamePlay;
	}

	public void setGamePlay(String gamePlay) {
		this.gamePlay = gamePlay;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Game game = (Game) o;
		return id == game.id &&
				Double.compare(game.reputacao, reputacao) == 0 &&
				nome.equals(game.nome) &&
				disciplina.equals(game.disciplina) &&
				link.equals(game.link) &&
				icone.equals(game.icone) &&
				gamePlay.equals(game.gamePlay) &&
				comentarios.equals(game.comentarios) &&
				resumo.equals(game.resumo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, disciplina, link, icone, reputacao, gamePlay, comentarios, resumo);
	}

	@Override
	public String toString() {
		return "Game{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", disciplina=" + disciplina +
				", link='" + link + '\'' +
				", icone='" + icone + '\'' +
				", reputacao=" + reputacao +
				", gamePlay='" + gamePlay + '\'' +
				", comentarios='" + comentarios + '\'' +
				", resumo='" + resumo + '\'' +
				'}';
	}
}
