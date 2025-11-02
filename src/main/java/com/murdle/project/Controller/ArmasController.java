package com.murdle.project.Controller;


import com.murdle.project.dto.ItemResponse;
import com.murdle.project.repository.ArmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin (origins = "*")
public class ArmasController {

    @Autowired
    private ArmasRepository armasRepository;

    @GetMapping("/armas")
    public List<ItemResponse> listarTodas() {
        return armasRepository.findAll().stream()
                .map(a -> {
                    ItemResponse item = new ItemResponse();
                    item.setId(a.getId_armas());
                    item.setNome(a.getNome_armas());
                    item.setTexto(a.getTexto_armas());
                    item.setExtra(a.getPeso());
                    return item;
                })
                .toList();
    }
}