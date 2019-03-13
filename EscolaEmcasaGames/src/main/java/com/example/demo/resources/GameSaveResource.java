package com.example.demo.resources;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Curso;
import com.example.demo.domain.Game;
import com.example.demo.domain.GameSave;
import com.example.demo.services.AlunoService;
import com.example.demo.services.CursoService;
import com.example.demo.services.GameSaveService;
import com.example.demo.services.GameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gameSaved")
public class GameSaveResource  {

    @Autowired
    private GameSaveService service;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private GameService gameService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @ApiOperation(value = "Recupera games salvos")
    public ResponseEntity<List<GameSave>> findAll(){
        List<GameSave> games = service.findAll();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping("curso/{cursoId}")
    @ApiOperation(value = "Recupera games salvos de um curso")
    public ResponseEntity<List<GameSave>> findAByCurso(@PathVariable("cursoId") int id){
        //recuperar curso
        Optional<Curso> curso = cursoService.findById(id);
        if(curso.isPresent()) {
            //
            List<GameSave> games = service.findByCurso(curso.get()).get();
            return ResponseEntity.ok().body(games);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("aluno/{alunoId}")
    @ApiOperation(value = "Recupera games salvos de um aluno")
    public ResponseEntity<List<GameSave>> findAByAluno(@PathVariable("alunoId") int id){
        //recuperar curso
        Optional<Aluno> aluno = alunoService.findById(id);
        if(aluno.isPresent()) {
            //
            Optional<List<GameSave>> games = service.findByAluno(aluno.get());
            if(games.isPresent())
                return ResponseEntity.ok().body(games.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Salva um novo game")
    public ResponseEntity<Void> save(@RequestBody GameSave gameSave){
        LocalDateTime dataSalvamento = LocalDateTime.now();
        int alunoId = gameSave.getAlunoID();
        int gameId = gameSave.getGameID();

        Optional<Aluno> aluno = alunoService.findById(alunoId);
        Optional<Game> game = gameService.findById(gameId);

        if(aluno.isPresent() && game.isPresent()) {
            gameSave.setGame(game.get());
            aluno.get().addGameSaved(gameSave);
            gameSave.setAluno(aluno.get());
            gameSave.setData(dataSalvamento);

            gameSave = service.save(gameSave);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(gameSave.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.notFound().build();
    }


}
