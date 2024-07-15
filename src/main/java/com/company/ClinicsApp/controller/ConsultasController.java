package com.company.ClinicsApp.controller;

import com.company.ClinicsApp.domain.consulta.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    private AgendaDeConsultas agendaDeConsultas;


    @PostMapping
    @Transactional
    public ResponseEntity criarConsulta(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamentoConsulta){
//        var consulta = new Consulta(dadosCadastroConsulta);
        //ConsultaRepository.save

        agendaDeConsultas.agendar(dadosAgendamentoConsulta);

        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null,null,null,null));
    }


    @DeleteMapping
    @Transactional
    public ResponseEntity deletarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dadosCancelamentoConsulta){
        agendaDeConsultas.cancelar(dadosCancelamentoConsulta);

        return ResponseEntity.noContent().build();

    }
}
