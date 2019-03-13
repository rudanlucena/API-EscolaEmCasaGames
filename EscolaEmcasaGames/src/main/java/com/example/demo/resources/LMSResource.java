package com.example.demo.resources;

import com.example.demo.domain.LMS;
import com.example.demo.services.LMSService;
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
@RequestMapping(value = "/lms")
@Api(value = "Greeting", description = "Rucurso de LMS")
public class LMSResource {
    @Autowired
    private LMSService service;

    @GetMapping
    @ApiOperation(value = "Recupera todos os LMS")
    public ResponseEntity<List<LMS>> findAll(){
        List<LMS> lmsList = service.findAll();
        return ResponseEntity.ok().body(lmsList);
    }

//    @GetMapping("/{id}")
//    @ApiOperation(value = "Recupera um LMS por id")
//    public ResponseEntity<Optional<LMS>> findById(@PathVariable("id") int id){
//        Optional<LMS> lms = service.findById(id);
//        return ResponseEntity.ok().body(lms);
//    }

    @GetMapping("/{url}")
    @ApiOperation(value = "Recupera um lms por url")
    public ResponseEntity<Optional<LMS>> findByUrl(@PathVariable("url") String url){
        Optional<LMS> lms = service.findByUrl(url);
        if(lms.isPresent()){
            return ResponseEntity.ok().body(lms);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Salva um LMS")
    public ResponseEntity<Void> save(@RequestBody LMS lms){
        lms = service.save(lms);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lms.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um LMS por id")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        Optional<LMS> lms = service.findById(id);
        if(lms.isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
