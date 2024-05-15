package br.edu.ufcg.computacao.psoft.commerce.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.ArrayList;

//@data cria hashcode, get, set, equals, etc
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("cpf")
    @Column(nullable = false)
    private String cpf;

    @JsonProperty("email")
    @Column(nullable = false)
    private String email;

    @JsonProperty("telefone")
    @Column(nullable = false)
    private String telefone;

    @JsonProperty("dataNascimento")
    @Column(nullable = false)
    private String dataNascimento;

    //CORRIGIR ESSE ONE TO MANY ABAIXO
    //@OneToMany(mappedBy = "/pessoas", cascade = CascadeType.ALL)

    //private ArrayList<Endereco> enderecos;

    @JsonProperty("profissao")
    @Column(nullable = false)
    private String profissao;
}
