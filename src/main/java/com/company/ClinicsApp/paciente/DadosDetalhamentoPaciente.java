package com.company.ClinicsApp.paciente;

import com.company.ClinicsApp.endereco.DadosEndereco;
import com.company.ClinicsApp.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosDetalhamentoPaciente(
        String nome,

        String email,

        String telefone,

        String cpf,

        Endereco endereco
) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
