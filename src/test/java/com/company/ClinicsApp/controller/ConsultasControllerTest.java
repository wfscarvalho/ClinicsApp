package com.company.ClinicsApp.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class ConsultasControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Deveria devolver código 400 quando informações invalidas")
    @WithMockUser
    void criarConsulta_cenario1 () throws Exception {
        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();

        org.assertj.core.api.Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());


    }

    @Test
    @DisplayName("Deveria devolver código 200 quando informações invalidas")
    @WithMockUser
    void criarConsulta_cenario2() throws Exception {
        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();

        org.assertj.core.api.Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());


    }


}