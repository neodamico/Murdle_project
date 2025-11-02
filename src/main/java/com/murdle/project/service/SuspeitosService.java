package com.murdle.project.service;

import com.murdle.project.entity.Suspeitos;
import com.murdle.project.repository.SuspeitosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuspeitosService {

    @Autowired
    private SuspeitosRepository suspeitosRepository;

    public List<Suspeitos> buscarTodos(){
        return suspeitosRepository.findAll();
    }
}
