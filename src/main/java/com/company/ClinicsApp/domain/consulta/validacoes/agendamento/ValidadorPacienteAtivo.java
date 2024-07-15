package com.company.ClinicsApp.domain.consulta.validacoes.agendamento;

import com.company.ClinicsApp.domain.ValidacaoException;
import com.company.ClinicsApp.domain.consulta.DadosAgendamentoConsulta;
import com.company.ClinicsApp.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
