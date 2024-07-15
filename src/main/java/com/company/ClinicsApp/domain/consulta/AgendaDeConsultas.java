package com.company.ClinicsApp.domain.consulta;

import com.company.ClinicsApp.domain.ValidacaoException;
import com.company.ClinicsApp.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import com.company.ClinicsApp.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import com.company.ClinicsApp.domain.medico.Medico;
import com.company.ClinicsApp.domain.medico.MedicoRepository;
import com.company.ClinicsApp.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){

        if (!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do Paciente não existe");
        }

        if (dados.idMedico()!= null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do Médico não existe");
        }

        validadores.forEach(validadorAgendamentoDeConsulta -> validadorAgendamentoDeConsulta.validar(dados));

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        var consultaCriada = consultaRepository.save(consulta);
        System.out.println(consultaCriada);

        return new DadosDetalhamentoConsulta(consultaCriada);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade()== null) {
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        var resultadoBusca = medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());

        if (resultadoBusca == null) {
            throw new ValidacaoException("Nenhum médico disponível para atendimento");
        }

        return resultadoBusca;

    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoException("Id da consulta informado não existe");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));


        var consulta = consultaRepository.getReferenceById(dados.idConsulta());

        consulta.cancelar(dados.motivo());


    }
}
