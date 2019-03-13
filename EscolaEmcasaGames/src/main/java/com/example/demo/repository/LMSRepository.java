package com.example.demo.repository;

import com.example.demo.domain.LMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LMSRepository extends JpaRepository<LMS, Integer> {
    Optional<LMS> findByUrl(String url);
}
