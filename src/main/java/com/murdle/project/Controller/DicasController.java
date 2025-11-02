package com.murdle.project.Controller;

import com.murdle.project.entity.Dicas;
import com.murdle.project.service.DicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api")
@CrossOrigin(origins = "*")
public class DicasController {

    @Autowired
    private DicasService dicasService;

    @GetMapping("dicas")
    public List<Dicas> listar(){
        return dicasService.buscarTodos();
    }
}
