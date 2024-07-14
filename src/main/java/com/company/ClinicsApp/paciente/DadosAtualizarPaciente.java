package com.company.ClinicsApp.paciente;

import com.company.ClinicsApp.endereco.DadosEndereco;

public record DadosAtualizarPaciente(Long Id, String nome, String telefone, DadosEndereco endereco) {
}
