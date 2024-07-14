package com.company.ClinicsApp.domain.medico;

import com.company.ClinicsApp.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico (@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
