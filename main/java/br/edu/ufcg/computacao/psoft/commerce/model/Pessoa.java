package br.edu.ufcg.computacao.psoft.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

//@data cria hashcode, get, set, equals, etc
@Data
@Builder
@NoArgsConstructor
public class Pessoa {
    @JsonProperty("id")
    @Id
    private Long id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefone")
    private String telefone;
    @JsonProperty("dataNascimento")
    private String dataNascimento;
    @JsonProperty("enderecos")
    private ArrayList<Endereco> enderecos;
    @JsonProperty("profissao")
    private String profissao;

    @Builder
    public Pessoa(Long id, String nome, String cpf, String email, String telefone, String dataNascimento, ArrayList<Endereco> enderecos, String profissao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
        this.profissao = profissao;
    }
}
