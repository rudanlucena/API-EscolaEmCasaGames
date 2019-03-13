package com.example.demo.resources;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Curso;
import com.example.demo.services.AlunoService;
import com.example.demo.services.CursoService;
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
@RequestMapping("/alunos")
@Api(value = "Greeting", description = "Rucurso de alunos")
public class AlunoResource {
    @Autowired
    private AlunoService service;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @ApiOperation(value = "Recupera todos os alunos")
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> alunos = service.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Recupera aluno por id")
    public ResponseEntity<Optional<Aluno>> findById(@PathVariable("id") int id){
        Optional<Aluno> aluno = service.findById(id);
        if(aluno.isPresent())
            return ResponseEntity.ok().body(aluno);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Salva um aluno")
    public ResponseEntity<Void> save(@RequestBody Aluno aluno){
        Optional<Curso> curso = cursoService.findById(aluno.getIdCurso());
        if(curso.isPresent()) {
            int id = Integer.parseInt(aluno.getIdCurso() + "" + aluno.getId());
            aluno.setId(id);

            curso.get().addAluno(aluno);
            aluno.setCurso(curso.get());

            aluno = service.save(aluno);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um aluno por id")
    public ResponseEntity<Void> delete(@PathVariable ("id") int id){
        Optional<Aluno> aluno = service.findById(id);
        if(aluno.isPresent()) {
            Curso curso = aluno.get().getCurso();
            curso.removeAluno(aluno.get());

            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
