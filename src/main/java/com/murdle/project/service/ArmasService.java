package com.murdle.project.service;

import com.murdle.project.repository.ArmasRepository;
import com.murdle.project.entity.Armas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmasService {

    @Autowired
    private ArmasRepository armasRepository;

    public List<Armas> buscarTodos() {
        return armasRepository.findAll();
    }
}
