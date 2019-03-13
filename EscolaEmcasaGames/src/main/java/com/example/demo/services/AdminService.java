package com.example.demo.services;

import com.example.demo.domain.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public List<Admin> listAll(){
        return repository.findAll();
    }

    public Optional<Admin> findByLogin(int id){
        return  repository.findById(id);
    }

    public Admin save(Admin admin){
        return repository.save(admin);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
