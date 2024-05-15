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
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("nome_produto")
    private String nome_produto;

    @JsonProperty("codigo_barras")
    private String codigo_barras;

    @JsonProperty("preco")
    private double preco;

    @JsonProperty("nome_fabricante")
    private String nome_fabricante;
}

