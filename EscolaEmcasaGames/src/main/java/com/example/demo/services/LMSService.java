package com.example.demo.services;

import com.example.demo.domain.LMS;
import com.example.demo.repository.LMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LMSService {
    @Autowired
    private LMSRepository repository;

    public List<LMS> findAll(){
        return repository.findAll();
    }

    public Optional<LMS> findById(int id){
        return repository.findById(id);
    }

    public Optional<LMS> findByUrl(String url){
        return repository.findByUrl(url);
    }

    public LMS save(LMS lms) {
        return repository.save(lms);
    }

    public void saveAll(List<LMS> lmsList){
        repository.saveAll(lmsList);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
