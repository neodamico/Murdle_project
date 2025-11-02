package com.murdle.project.service;

import com.murdle.project.entity.Locais;
import com.murdle.project.repository.LocaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocaisService {

    @Autowired
    private LocaisRepository locaisRepository;

    public List<Locais> buscarTodos() {
        return locaisRepository.findAll();
    }
}