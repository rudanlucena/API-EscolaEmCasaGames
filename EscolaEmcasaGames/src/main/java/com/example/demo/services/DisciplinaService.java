package com.example.demo.services;

import com.example.demo.domain.Disciplina;
import com.example.demo.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> findAll(){
        return repository.findAll();
    }

    public Optional<Disciplina> findById(int id){
        return repository.findById(id);
    }

    public Disciplina save(Disciplina disciplina){
        return repository.save(disciplina);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
