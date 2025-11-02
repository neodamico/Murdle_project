package com.murdle.project.service;

import com.murdle.project.entity.Dicas;
import com.murdle.project.repository.DicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicasService {

    @Autowired
    private DicasRepository dicasRepository;

    public List<Dicas> buscarTodos(){
        return dicasRepository.findAll();
    }

}
