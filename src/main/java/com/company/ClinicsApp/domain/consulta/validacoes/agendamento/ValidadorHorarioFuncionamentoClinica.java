package com.company.ClinicsApp.domain.consulta.validacoes.agendamento;

import com.company.ClinicsApp.domain.ValidacaoException;
import com.company.ClinicsApp.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {
    //VAMOS COMEÇAR A CRIAR AS VALIDAÇÕES. DENTRO DESSA PASTA DE VALIDACOES

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var antesDaAberturaDaClinica = dataConsulta.getHour()<7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour()>18;
        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clinica");
        }
    }
}
