package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Game;
import com.example.demo.repository.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository repository;

	@Autowired
	private DisciplinaService disciplinaService;
	
	public List<Game> findAll(){
		return repository.findAll();
	}

	public Optional<Game> findById(int id){
		return repository.findById(id);
	}
	
	public Game save(Game game) {
		Optional<Disciplina> disciplina = disciplinaService.findById(game.getDisciplina().getId());
		game.setDisciplina(disciplina.get());

		//logica para adicionar o link e icones do jogo
		game.setLink(game.getDisciplina().getAnoEnsino().replace(" ", "")+"/"+game.getNome().replace(" ", ""));
		game.setIcone(game.getDisciplina().getAnoEnsino().replace(" ", "")+"/"+game.getNome().replace(" ", "")+"/icon.png");
		game.setReputacao(5.0);

		return repository.save(game);
	}

	public void saveAll(List<Game> games){
		repository.saveAll(games);
	}

	public void deleteAll(){
		repository.deleteAll();
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
}
