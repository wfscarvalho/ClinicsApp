package com.company.ClinicsApp.controller;

import com.company.ClinicsApp.domain.paciente.DadosListagemPaciente;
import com.company.ClinicsApp.domain.paciente.Paciente;
import com.company.ClinicsApp.domain.paciente.PacienteRepository;
import com.company.ClinicsApp.domain.paciente.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroPaciente(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder){
        var paciente = new Paciente(dados);
                pacienteRepository.save(paciente);

        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listaPaciente (@PageableDefault(size = 10,sort = {"nome"}) Pageable pageable){
        var paciente = pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaPaciente(@RequestBody @Valid DadosAtualizarPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.Id());
        paciente.AtualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletaPaciente(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.Excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalharPaciente(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
