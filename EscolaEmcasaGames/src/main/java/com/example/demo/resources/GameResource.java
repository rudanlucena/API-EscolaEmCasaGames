package com.example.demo.resources;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Game;
import com.example.demo.services.GameService;

@RestController
@RequestMapping(value="/games")
@Api(value = "Greeting", description = "Recurso de Games")
public class GameResource {
	
	@Autowired
	private GameService service;
	
	@GetMapping
	@ApiOperation(value = "Recupera games cadastrados")
	public ResponseEntity<List<Game>> findAll(){
		List<Game> games = service.findAll();
		return ResponseEntity.ok().body(games);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Recupera game por id")
	public ResponseEntity<Optional<Game>> findById(@PathVariable("id") int id){
		Optional<Game> aluno = service.findById(id);
		if(aluno.isPresent())
			return ResponseEntity.ok().body(aluno);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Salva um novo game")
	public ResponseEntity<Void> save(@RequestBody Game game){
		game = service.save(game);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(game.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um game por id")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
