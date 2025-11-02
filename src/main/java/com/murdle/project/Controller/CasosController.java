package com.murdle.project.Controller;

import com.murdle.project.dto.CasoCompletoResponse;
import com.murdle.project.dto.ValidacaoRequest;
import com.murdle.project.dto.ValidacaoResponse;
import com.murdle.project.entity.Casos;
import com.murdle.project.dto.CasoSimplesResponse;
import com.murdle.project.service.CasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CasosController {

    @Autowired
    private CasosService casosService;

    @GetMapping("/casos")
    public List<CasoSimplesResponse> listarCasos(){
        return casosService.buscarTodosSimples();
    }

    @GetMapping("/casos/{id}")
    public ResponseEntity<CasoCompletoResponse> buscarCaso(@PathVariable Integer id) {
        return ResponseEntity.ok(casosService.buscarCasoCompleto(id));
    }

    @PostMapping("/validar")
    public ResponseEntity<ValidacaoResponse> validar(@RequestBody ValidacaoRequest request) {
        ValidacaoResponse resposta = casosService.validarResposta(request);
        return ResponseEntity.ok(resposta);
    }
}
