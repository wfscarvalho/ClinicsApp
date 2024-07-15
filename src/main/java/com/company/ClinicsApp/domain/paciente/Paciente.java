package com.company.ClinicsApp.domain.paciente;

import com.company.ClinicsApp.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    private Endereco endereco;
    private boolean ativo;


    public Paciente(DadosCadastroPaciente dados) {
    this.ativo = true;
    this.nome = dados.nome();
    this.email = dados.email();
    this.telefone = dados.telefone();
    this.cpf = dados.cpf();
    this.endereco = new Endereco(dados.endereco());
    }



    public void AtualizarInformacoes(DadosAtualizarPaciente dadosAtualizarPaciente) {
        if (dadosAtualizarPaciente.nome()!=null){
            this.nome = dadosAtualizarPaciente.nome();
        }
        if (dadosAtualizarPaciente.telefone()!=null) {
            this.telefone = dadosAtualizarPaciente.telefone();
        }
        if (dadosAtualizarPaciente.endereco()!=null) {
            this.endereco.AtualizarDados(dadosAtualizarPaciente.endereco());
        }
    }

    public void Excluir() {
        this.ativo = false;
    }
}
