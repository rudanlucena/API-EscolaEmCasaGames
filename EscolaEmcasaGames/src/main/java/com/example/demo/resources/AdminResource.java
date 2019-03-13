package com.example.demo.resources;

import com.example.demo.domain.Admin;
import com.example.demo.services.AdminService;
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
@RequestMapping("/admin")
@Api(value = "Greeting", description = "Rucurso de administrador")
public class AdminResource {
    @Autowired
    private AdminService service;

    @GetMapping
    @ApiOperation(value = "Recupera todos os administradores")
    public ResponseEntity<List<Admin>> findAll(){
        List<Admin> administradores = service.listAll();
        return ResponseEntity.ok().body(administradores);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Recupera administrador por id")
    public ResponseEntity<Optional<Admin>> findById(@PathVariable ("id") int id){
        Optional<Admin> admin = service.findByLogin(id);
        return ResponseEntity.ok().body(admin);
    }

    @PostMapping
    @ApiOperation(value = "Salva um administrador")
    public ResponseEntity<Void> save(@RequestBody Admin admin){
        admin = service.save(admin);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um administrador por id")
    public ResponseEntity<Void> delete(@PathVariable ("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
