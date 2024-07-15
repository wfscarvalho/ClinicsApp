package com.company.ClinicsApp.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(

        @NotNull
        long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}
