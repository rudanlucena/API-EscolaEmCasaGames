package com.example.demo.repository;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Curso;
import com.example.demo.domain.GameSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameSaveRepository extends JpaRepository<GameSave, Integer> {
    Optional<List<GameSave>> findByAluno_Curso(Curso curso);
    Optional<List<GameSave>> findByAluno(Aluno aluno);
}
