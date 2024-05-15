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
public class Endereco{
    @JsonProperty("id")
    @Id
    private Long id;
    @JsonProperty("tipoLogradouro")
    private String tipoLogradouro;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("numero")
    private Long numero;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("pais")
    private String pais;
    @JsonProperty("cep")
    private Long cep;

    @Builder
    public Endereco(Long id, String tipoLogradouro, String logradouro, Long numero, String complemento, String bairro, String cidade, String estado, String pais, Long cep) {
        this.id = id;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }
}

