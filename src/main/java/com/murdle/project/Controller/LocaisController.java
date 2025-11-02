package com.murdle.project.Controller;

import com.murdle.project.dto.ItemResponse;
import com.murdle.project.repository.LocaisRepository;
import com.murdle.project.service.LocaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin(origins = "*")
public class LocaisController {

    @Autowired
    private LocaisRepository locaisRepository;

    @GetMapping("/locais")
    public List<ItemResponse> listarTodos() {
        return locaisRepository.findAll().stream()
                .map(l -> {
                    ItemResponse item = new ItemResponse();
                    item.setId(l.getId_local());
                    item.setNome(l.getNome_local());
                    item.setTexto(l.getTexto_local());
                    item.setExtra(l.getTipo_ambiente());
                    return item;
                })
                .toList();
    }
}