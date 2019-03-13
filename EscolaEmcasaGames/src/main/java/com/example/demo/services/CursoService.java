package com.example.demo.services;

import com.example.demo.domain.Curso;
import com.example.demo.domain.LMS;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.LMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    public List<Curso> findAll(){
        return repository.findAll();
    }

    public Optional<Curso> findById(int id){
        return repository.findById(id);
    }

    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    public void saveAll(List<Curso> cursos){
        repository.saveAll(cursos);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
