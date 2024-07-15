package com.company.ClinicsApp.domain.consulta.validacoes.agendamento;

import com.company.ClinicsApp.domain.ValidacaoException;
import com.company.ClinicsApp.domain.consulta.DadosAgendamentoConsulta;
import com.company.ClinicsApp.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar (DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null){
            return;
        }

        var MedicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!MedicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }
}
