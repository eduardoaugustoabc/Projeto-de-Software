package br.edu.ufcg.computacao.psoft.commerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPostPutRequestDTO {
    @JsonProperty("nome_produto")
    @NotNull(message = "Precisa ter um nome do produto")
    @NotBlank(message = "Nome do produto nao pode ser vazio")
    private String nome_produto;

    @JsonProperty("codigo_barras")
    @NotNull(message = "Precisa ter um codigo de barras")
    @NotBlank(message = "Codigo de barras nao pode ser vazio")
    private String codigo_barras;

    @JsonProperty("preco")
    @NotNull(message = "Precisa ter um preco")
    @Positive(message = "Preco nao pode ser 0 ou menor")
    private double preco;

    @JsonProperty("nome_fabricante")
    @NotNull(message = "Precisa ter um nome do fabricante")
    @NotBlank(message = "Nome do fabricante nao pode ser vazio")
    private String nome_fabricante;
}
