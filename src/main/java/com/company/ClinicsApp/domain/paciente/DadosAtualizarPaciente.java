package com.company.ClinicsApp.domain.paciente;

import com.company.ClinicsApp.domain.endereco.DadosEndereco;

public record DadosAtualizarPaciente(Long Id, String nome, String telefone, DadosEndereco endereco) {
}
