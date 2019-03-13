package com.example.demo.resources;

import com.example.demo.domain.Curso;
import com.example.demo.domain.CursoPK;
import com.example.demo.domain.LMS;
import com.example.demo.services.CursoService;
import com.example.demo.services.LMSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.Embedded;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cursos")
@Api(value = "Greeting", description = "Rucurso de cursos")
public class CursoResource {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private LMSService lmsService;

    @GetMapping
    @ApiOperation(value = "Recupera todos os cursos")
    public ResponseEntity<List<Curso>> findAll(){
        List<Curso> cursos = cursoService.findAll();
        return ResponseEntity.ok().body(cursos);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Recupera um curso por id")
    public ResponseEntity<Optional<Curso>> findById(@PathVariable("id") int id){
        Optional<Curso> curso = cursoService.findById(id);
        if(curso.isPresent())
            return ResponseEntity.ok().body(curso);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Salva um curso")
    public ResponseEntity<Void> save(@RequestBody Curso curso){
        Optional<LMS> lms = lmsService.findByUrl(curso.getUrlMLS());
        if(lms.isPresent()) {
            int idCursoConsumer = curso.getId();
            String idLms = Integer.toString(lms.get().getId());
            int id = Integer.parseInt(idLms + "" + idCursoConsumer);
            curso.setId(id);

            lms.get().addCurso(curso);
            curso.setLms(lms.get());
            curso = cursoService.save(curso);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um curso por id")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        Optional<Curso> curso = cursoService.findById(id);
        if(curso.isPresent()) {
            LMS lms = curso.get().getLms();
            lms.removeCurso(curso.get());
            cursoService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
