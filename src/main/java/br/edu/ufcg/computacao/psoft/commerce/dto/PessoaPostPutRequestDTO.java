package br.edu.ufcg.computacao.psoft.commerce.dto;

import br.edu.ufcg.computacao.psoft.commerce.models.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaPostPutRequestDTO {

    @JsonProperty("nome")
    @NotNull(message = "Precisa ter um nome")
    @NotBlank(message = "Nome nao pode ser vazio")
    private String nome;

    @JsonProperty("cpf")
    @NotNull(message = "Precisa ter um cpf")
    @NotBlank(message = "Email nao pode ser vazio")
    private String cpf;

    @JsonProperty("email")
    @NotNull(message = "Precisa ter um email")
    @NotBlank(message = "Email nao pode ser vazio")
    private String email;

    @JsonProperty("telefone")
    @NotNull(message = "Precisa ter um telefone")
    @NotBlank(message = "telefone nao pode ser vazio")
    private String telefone;

    @JsonProperty("dataNascimento")
    @NotNull(message = "Precisa ter uma data de nascimento")
    @NotBlank(message = "Data de nascimento nao pode ser vazia")
    private String dataNascimento;

    @JsonProperty("enderecos")
    @NotNull(message = "Precisa ter ao menos um endereco")
    private ArrayList<Endereco> enderecos;

    @JsonProperty("profissao")
    @NotNull(message = "Precisa ter uma profissao")
    @NotBlank(message = "Profissao nao pode ser vazia")
    private String profissao;
}