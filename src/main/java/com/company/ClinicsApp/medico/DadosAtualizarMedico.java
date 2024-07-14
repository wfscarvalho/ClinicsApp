package com.company.ClinicsApp.medico;

import com.company.ClinicsApp.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico (@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
