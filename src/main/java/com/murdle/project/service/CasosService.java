package com.murdle.project.service;

import com.murdle.project.dto.*;
import com.murdle.project.entity.Casos;
import com.murdle.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.Objects;
import java.util.List;

@Service
public class CasosService {

    @Autowired
    private CasosRepository casosRepository;

    @Autowired
    private LocaisRepository locaisRepository;

    @Autowired
    private ArmasRepository armasRepository;

    @Autowired
    private SuspeitosRepository suspeitosRepository;

    @Autowired
    private DicasRepository dicasRepository;



    public List<CasoSimplesResponse> buscarTodosSimples() {
        return casosRepository.findAll().stream().map(caso -> {
                    CasoSimplesResponse response = new CasoSimplesResponse();
                    response.setId(caso.getId_casos());
                    response.setTitulo(caso.getTitulo_caso());
                    return response;
                })
                .toList();
    }

    public CasoCompletoResponse buscarCasoCompleto(Integer id) {
        Casos caso = casosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caso não encontrado"));

        CasoCompletoResponse response = new CasoCompletoResponse();
        response.setId(caso.getId_casos());
        response.setTitulo(caso.getTitulo_caso());
        response.setTexto(caso.getTexto_caso());

        // LOCAIS
        response.setLocais(locaisRepository.findByCasos(caso).stream()
                .map(l -> {
                    ItemResponse item = new ItemResponse();
                    item.setId(l.getId_local());
                    item.setNome(l.getNome_local());
                    item.setExtra(l.getTipo_ambiente());
                    item.setTexto(l.getTexto_local());
                    return item;
                })
                .toList());

        // ARMAS
        response.setArmas(armasRepository.findByCasos(caso).stream()
                .map(a -> {
                    ItemResponse item = new ItemResponse();
                    item.setId(a.getId_armas());
                    item.setNome(a.getNome_armas());
                    item.setExtra(a.getPeso());
                    item.setTexto(a.getTexto_armas());
                    return item;
                })
                .toList());

        // SUSPEITOS
        response.setSuspeitos(suspeitosRepository.findByCasos(caso).stream()
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
                .toList());

        // DICAS
        response.setDicas(dicasRepository.findByCasos(caso).stream()
                .flatMap(d -> Stream.of(d.getDica_1(), d.getDica_2(), d.getDica_3(), d.getDica_4(), d.getDica_5()))
                .filter(Objects::nonNull)
                .filter(d -> !d.trim().isEmpty())
                .toList());

        return response;
    }

    public ValidacaoResponse validarResposta(ValidacaoRequest request) {
        Casos caso = casosRepository.findById(request.getCasoId())
                .orElseThrow(() -> new RuntimeException("Caso não encontrado"));

        boolean acertou =
                caso.getLocalCorreto().getId_local().equals(request.getLocalId()) &&
                        caso.getArmaCorreta().getId_armas().equals(request.getArmaId()) &&
                        caso.getSuspeitoCorreto().getId_suspeito().equals(request.getSuspeitoId());

        ValidacaoResponse response = new ValidacaoResponse();
        response.setAcertou(acertou);
        response.setMensagem(acertou
                ? "Parabéns! Você resolveu o caso!"
                : "Sua lógica falhou. Tente novamente.");

        return response;
    }
}

