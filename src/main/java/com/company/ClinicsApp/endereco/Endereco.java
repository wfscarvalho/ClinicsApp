package com.company.ClinicsApp.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    String logradouro;
    String bairro;
    String cep;
    String cidade;
    String uf;
    String complemento;
    String numero;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }

    public void AtualizarDados(DadosEndereco endereco) {
        if (endereco.logradouro()!= null){
            this.logradouro = endereco.logradouro();
        }
        if (endereco.bairro()!= null){
            this.bairro = endereco.bairro();
        }
        if (endereco.cep()!= null){
            this.cep = endereco.cep();
        }
        if (endereco.cidade()!= null){
            this.cidade = endereco.cidade();
        }
        if (endereco.uf()!= null){
            this.uf = endereco.uf();
        }
        if (endereco.complemento()!= null){
            this.complemento = endereco.complemento();
        }
        if (endereco.numero()!= null){
            this.numero = endereco.numero();
        }
    }
}
