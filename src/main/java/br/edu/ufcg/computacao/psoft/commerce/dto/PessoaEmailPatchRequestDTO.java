package br.edu.ufcg.computacao.psoft.commerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEmailPatchRequestDTO {
    @JsonProperty("email")
    @NotBlank(message = "Email obrigatorio")
    @NotNull(message = "Email obrigatorio")
    private String email;
}
