package br.edu.ufcg.computacao.psoft.commerce.controllers;

import br.edu.ufcg.computacao.psoft.commerce.dto.PessoaPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.exception.CustomErrorType;
import br.edu.ufcg.computacao.psoft.commerce.models.Endereco;
import br.edu.ufcg.computacao.psoft.commerce.models.Pessoa;
import br.edu.ufcg.computacao.psoft.commerce.repositories.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do controlador de Pessoa")
public class PessoaControllerTests {
    @Autowired
    MockMvc driver;

    @Autowired
    PessoaRepository pessoaRepository;


    ObjectMapper objectMapper = new ObjectMapper();

    Pessoa pessoa;

    Endereco endereco;

    @BeforeEach
    void setup() {
        // Object Mapper suporte para LocalDateTime
        objectMapper.registerModule(new JavaTimeModule());
        endereco = Endereco.builder()
                .logradouro("rua aprigio veloso")
                .numero(555L)
                .complemento("Na rua da farmacia")
                .build();

        ArrayList<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);

        pessoa = (Pessoa) pessoaRepository.save(Pessoa.builder()
                .nome("joaozinho")
                .cpf("222.444.111-88")
                .email("joaozinho@hotmail.com")
                .telefone("(83) 855698-4175")
                .dataNascimento("01/01/2001")
                //.enderecos(enderecos)
                .profissao("pintor")
                .build()
        );
    }

    @Nested
    @DisplayName("Conjunto de casos de operações em pessoa")
    class OperacoesEmPessoa {
        @Test
        @Transactional
        @DisplayName("Teste com nome inválido")
        void testaNomeInvalido() throws Exception {
            // Arrange
            endereco = Endereco.builder()
                    .logradouro("rua aprigio veloso")
                    .numero(555L)
                    .complemento("Na rua da farmacia")
                    .build();

            ArrayList<Endereco> enderecos = new ArrayList<>();
            enderecos.add(endereco);
            PessoaPostPutRequestDTO pessoaPostPutRequestDTO = PessoaPostPutRequestDTO.builder()
                    .nome(null)
                    .cpf("222.444.111-88")
                    .email("joaozinho@hotmail.com")
                    .telefone("(83) 855698-4175")
                    .dataNascimento("01/01/2001")
                    .enderecos(enderecos)
                    .profissao("pintor")
                    .build();

            // Act
            String responseJsonString = driver.perform(post("/pessoas/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(pessoaPostPutRequestDTO)))
                    .andExpect(status().isBadRequest())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            CustomErrorType resultado = objectMapper.readValue(responseJsonString, CustomErrorType.class);
            // Assert
            assertAll(
                    () -> assertEquals("Erros de validacao encontrados", resultado.getMessage())
            );
        }
    }

    @Test
    @Transactional
    @DisplayName("Teste com cpf inválido")
    void testaCpfInvalido() throws Exception {
        // Arrange
        endereco = Endereco.builder()
                .logradouro("rua aprigio veloso")
                .numero(555L)
                .complemento("Na rua da farmacia")
                .build();

        ArrayList<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        PessoaPostPutRequestDTO pessoaPostPutRequestDTO = PessoaPostPutRequestDTO.builder()
                .nome("joaozinho")
                .cpf(null)
                .email("joaozinho@hotmail.com")
                .telefone("(83) 855698-4175")
                .dataNascimento("01/01/2001")
                .enderecos(enderecos)
                .profissao("pintor")
                .build();

        // Act
        String responseJsonString = driver.perform(post("/pessoas/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pessoaPostPutRequestDTO)))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        CustomErrorType resultado = objectMapper.readValue(responseJsonString, CustomErrorType.class);
        // Assert
        assertAll(
                () -> assertEquals("Erros de validacao encontrados", resultado.getMessage())
        );
    }

    @Test
    @Transactional
    @DisplayName("Teste com email inválido")
    void testaEmailInvalido() throws Exception {
        // Arrange
        endereco = Endereco.builder()
                .logradouro("rua aprigio veloso")
                .numero(555L)
                .complemento("Na rua da farmacia")
                .build();

        ArrayList<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        PessoaPostPutRequestDTO pessoaPostPutRequestDTO = PessoaPostPutRequestDTO.builder()
                .nome("joaozinho")
                .cpf("222.444.111-88")
                .email(null)
                .telefone("(83) 855698-4175")
                .dataNascimento("01/01/2001")
                .enderecos(enderecos)
                .profissao("pintor")
                .build();

        // Act
        String responseJsonString = driver.perform(post("/pessoas/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pessoaPostPutRequestDTO)))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        CustomErrorType resultado = objectMapper.readValue(responseJsonString, CustomErrorType.class);
        // Assert
        assertAll(
                () -> assertEquals("Erros de validacao encontrados", resultado.getMessage())
        );
    }
    @Test
    @Transactional
    @DisplayName("Teste de busca por pessoa inválida")
    void testaBuscaPessoaInvalida() throws Exception {
        // Act
        String responseJsonString = driver.perform(get("/pessoas/" + "/" + 55555)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        CustomErrorType resultado = objectMapper.readValue(responseJsonString, CustomErrorType.class);
        // Assert
        assertAll(
                () -> assertEquals("A Pessoa consultada nao existe!", resultado.getMessage())
        );
    }
}

