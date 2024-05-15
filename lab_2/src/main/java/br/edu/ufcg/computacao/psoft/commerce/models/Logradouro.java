package br.edu.ufcg.computacao.psoft.commerce.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

//@data cria hashcode, get, set, equals, etc
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logradouros")
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("pais")
    private String pais;

    @JsonProperty("cep")
    private String cep;
}
