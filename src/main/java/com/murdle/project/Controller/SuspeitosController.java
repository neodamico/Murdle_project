package com.murdle.project.Controller;

import com.murdle.project.entity.Suspeitos;
import com.murdle.project.repository.SuspeitosRepository;
import com.murdle.project.dto.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin(origins = "*")
public class SuspeitosController {

    @Autowired
    private SuspeitosRepository suspeitosRepository;

    @GetMapping("/suspeitos")
    public List<ItemResponse> listarTodos() {
        return suspeitosRepository.findAll().stream()
                .map(s -> {
                    ItemResponse item = new ItemResponse();
                    item.setId(s.getId_suspeito());
                    item.setNome(s.getNome_suspeito());
                    item.setTexto(s.getTexto_suspeito());
                    item.setAltura(s.getAltura_suspeito());
                    item.setLateralidade(s.getLateralidade());
                    item.setCor_olhos(s.getCor_olhos());
                    item.setCor_cabelo(s.getCor_cabelo());
                    return item;
                })
                .toList();
    }
}