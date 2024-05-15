package br.edu.ufcg.computacao.psoft.commerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogradouroPostPutRequestDTO {
    @JsonProperty("tipo")
    @NotNull(message = "Precisa ter um tipo")
    @NotBlank(message = "Tipo nao pode ser vazio")
    private String tipo;

    @JsonProperty("nome")
    @NotNull(message = "Precisa ter um nome")
    @NotBlank(message = "Nome nao pode ser vazio")
    private String nome;

    @JsonProperty("bairro")
    @NotNull(message = "Precisa ter um bairro")
    @NotBlank(message = "Bairro nao pode ser vazio")
    private String bairro;

    @JsonProperty("cidade")
    @NotNull(message = "Precisa ter um cidade")
    @NotBlank(message = "Cidade nao pode ser vazio")
    private String cidade;

    @JsonProperty("estado")
    @NotNull(message = "Precisa ter um estado")
    @NotBlank(message = "Estado nao pode ser vazio")
    private String estado;

    @JsonProperty("pais")
    @NotNull(message = "Precisa ter ao menos um pais")
    @NotBlank(message = "Pais nao pode ser vazio")
    private String pais;

    @JsonProperty("cep")
    @NotNull(message = "Precisa ter um cep")
    @NotBlank(message = "Cep nao pode ser vazio")
    private String cep;
}
