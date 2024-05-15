package br.edu.ufcg.computacao.psoft.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//@data cria hashcode, get, set, equals, etc
@Data
@Builder
@NoArgsConstructor
public class Logradouro {
    @JsonProperty("id")
    @Id
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

    @Builder
    public Logradouro(Long id, String tipo, String nome, String bairro, String cidade, String estado, String pais, String cep) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }
}
