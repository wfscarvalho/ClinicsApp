package com.company.ClinicsApp.medico;

import com.company.ClinicsApp.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.ativo=true;
        this.nome = dadosCadastroMedico.nome();
        this.email = dadosCadastroMedico.email();
        this.crm = dadosCadastroMedico.crm();
        this.telefone = dadosCadastroMedico.telefone();
        this.especialidade = dadosCadastroMedico.especialidade();
        this.endereco = new Endereco(dadosCadastroMedico.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarMedico dados) {
        if (dados.nome()!= null){
            this.nome = dados.nome();
        }
        if (dados.telefone()!= null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco()!= null){
            this.endereco.AtualizarDados(dados.endereco());
        }
    }

    public void Excluir(Long id) {
        this.ativo = false;
    }
}
