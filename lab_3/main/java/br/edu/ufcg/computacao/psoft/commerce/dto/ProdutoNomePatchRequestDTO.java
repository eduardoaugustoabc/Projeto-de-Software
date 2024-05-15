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
public class ProdutoNomePatchRequestDTO {
    @JsonProperty("nome_produto")
    @NotBlank(message = "Nome do produto nao pode ser vazio")
    @NotNull(message = "Nome do produto nao pode ser nulo")
    private String nome_produto;
}
