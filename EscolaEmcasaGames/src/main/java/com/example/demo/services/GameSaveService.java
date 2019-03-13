package com.example.demo.services;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Curso;
import com.example.demo.domain.Game;
import com.example.demo.domain.GameSave;
import com.example.demo.repository.GameSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameSaveService {

    @Autowired
    private GameSaveRepository repository;

    public List<GameSave> findAll(){
        return repository.findAll();
    }

    public Optional<List<GameSave>> findByCurso(Curso curso){
        Optional<List<GameSave>> gameSaves = repository.findByAluno_Curso(curso);
        return gameSaves;
    }

    public Optional<List<GameSave>> findByAluno(Aluno aluno){
        Optional<List<GameSave>> gameSaves = repository.findByAluno(aluno);
        return gameSaves;
    }

    public GameSave save(GameSave gameSave){
        return repository.save(gameSave);
    }
}
