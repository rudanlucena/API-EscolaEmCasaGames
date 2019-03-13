package com.example.demo.resources;

import com.example.demo.domain.Disciplina;
import com.example.demo.services.DisciplinaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/diciplinas")
@Api(value = "Greeting", description = "Recurso de Diciplinas")
public class DisciplinaResource {
    @Autowired
    private DisciplinaService service;

    @GetMapping
    @ApiOperation(value = "Recupera todas as diciplinas")
    public ResponseEntity<List<Disciplina>> findAll(){
        List<Disciplina> disciplinas = service.findAll();
        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Recupera uma disciplina por id")
    public ResponseEntity<Optional<Disciplina>> findById(@PathVariable("id") int id){
        Optional<Disciplina> disciplina = service.findById(id);
        if(disciplina.isPresent())
            return ResponseEntity.ok().body(disciplina);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Salva uma disciplina")
    public ResponseEntity<Void> save(@RequestBody Disciplina disciplina){
        disciplina = service.save(disciplina);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplina.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma diciplina por id")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
