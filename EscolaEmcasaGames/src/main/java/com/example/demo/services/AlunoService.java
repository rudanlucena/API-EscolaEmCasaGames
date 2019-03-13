package com.example.demo.services;

import com.example.demo.domain.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public Optional<Aluno> findById(int id){
        return repository.findById(id);
    }

    public Aluno save(Aluno aluno) {
        return repository.save(aluno);
    }

    public void saveAll(List<Aluno> alunos){
        repository.saveAll(alunos);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
