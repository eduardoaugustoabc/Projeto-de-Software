package br.edu.ufcg.computacao.psoft.commerce.controller;

import br.edu.ufcg.computacao.psoft.commerce.dto.LogradouroPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.exception.CustomErrorType;
import br.edu.ufcg.computacao.psoft.commerce.model.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroRepository;
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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do controlador de Logradouro")
public class LogradouroV1ControllerTests {
    @Autowired
    MockMvc driver;

    @Autowired
    LogradouroRepository logradouroRepository;


    ObjectMapper objectMapper = new ObjectMapper();

    Logradouro logradouro;

    @BeforeEach
    void setup() {
        // Object Mapper suporte para LocalDateTime
        objectMapper.registerModule(new JavaTimeModule());
        logradouro = Logradouro.builder()
                .tipo("avenida")
                .nome("rua aprigio veloso")
                .bairro("Prata")
                .cidade("Campina Grande")
                .estado("Paraiba")
                .pais("Brasil")
                .cep("58032110")
                .build();
    }

    @Nested
    @DisplayName("Conjunto de casos de operações em logradouro")
    class OperacoesEmLogradouro {
        @Test
        @Transactional
        @DisplayName("Teste com tipo inválido")
        void testaTipoInvalido() throws Exception {
            // Arrange
            LogradouroPostPutRequestDTO logradouroPostPutRequestDTO = LogradouroPostPutRequestDTO.builder()
                    .tipo(null)
                    .nome("rua aprigio veloso")
                    .bairro("Prata")
                    .cidade("Campina Grande")
                    .estado("Paraiba")
                    .pais("Brasil")
                    .cep("58032110")
                    .build();

            // Act
            String responseJsonString = driver.perform(post("/logradouros/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(logradouroPostPutRequestDTO)))
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
    @DisplayName("Teste com nome inválido")
    void testaNomeInvalido() throws Exception {
        // Arrange
        LogradouroPostPutRequestDTO logradouroPostPutRequestDTO = LogradouroPostPutRequestDTO.builder()
                .tipo("avenida")
                .nome(null)
                .bairro("Prata")
                .cidade("Campina Grande")
                .estado("Paraiba")
                .pais("Brasil")
                .cep("58032110")
                .build();

        // Act
        String responseJsonString = driver.perform(post("/logradouros/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logradouroPostPutRequestDTO)))
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
    @DisplayName("Teste com bairro inválido")
    void testaBairroInvalido() throws Exception {
        // Arrange
        LogradouroPostPutRequestDTO logradouroPostPutRequestDTO = LogradouroPostPutRequestDTO.builder()
                .tipo("avenida")
                .nome("rua aprigio veloso")
                .bairro(null)
                .cidade("Campina Grande")
                .estado("Paraiba")
                .pais("Brasil")
                .cep("58032110")
                .build();

        // Act
        String responseJsonString = driver.perform(post("/logradouros/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logradouroPostPutRequestDTO)))
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
    @DisplayName("Teste com cidade inválida")
    void testaCidadeInvalida() throws Exception {
        // Arrange
        LogradouroPostPutRequestDTO logradouroPostPutRequestDTO = LogradouroPostPutRequestDTO.builder()
                .tipo("avenida")
                .nome("rua aprigio veloso")
                .bairro("prata")
                .cidade(null)
                .estado("Paraiba")
                .pais("Brasil")
                .cep("58032110")
                .build();

        // Act
        String responseJsonString = driver.perform(post("/logradouros/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logradouroPostPutRequestDTO)))
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
    @DisplayName("Teste com estado inválido")
    void testaEstadoInvalido() throws Exception {
        // Arrange
        LogradouroPostPutRequestDTO logradouroPostPutRequestDTO = LogradouroPostPutRequestDTO.builder()
                .tipo("avenida")
                .nome("rua aprigio veloso")
                .bairro("prata")
                .cidade("Campina Grande")
                .estado(null)
                .pais("Brasil")
                .cep("58032110")
                .build();

        // Act
        String responseJsonString = driver.perform(post("/logradouros/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logradouroPostPutRequestDTO)))
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
    @DisplayName("Teste com pais inválido")
    void testaPaisInvalido() throws Exception {
        // Arrange
        LogradouroPostPutRequestDTO logradouroPostPutRequestDTO = LogradouroPostPutRequestDTO.builder()
                .tipo("avenida")
                .nome("rua aprigio veloso")
                .bairro("prata")
                .cidade("Campina Grande")
                .estado("Paraiba")
                .pais(null)
                .cep("58032110")
                .build();

        // Act
        String responseJsonString = driver.perform(post("/logradouros/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logradouroPostPutRequestDTO)))
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
    @DisplayName("Teste com cep inválido")
    void testaCepInvalido() throws Exception {
        // Arrange
        LogradouroPostPutRequestDTO logradouroPostPutRequestDTO = LogradouroPostPutRequestDTO.builder()
                .tipo("avenida")
                .nome("rua aprigio veloso")
                .bairro("prata")
                .cidade("Campina Grande")
                .estado("Paraiba")
                .pais("Brasil")
                .cep(null)
                .build();

        // Act
        String responseJsonString = driver.perform(post("/logradouros/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(logradouroPostPutRequestDTO)))
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
    @DisplayName("Teste de busca por logradouro inválido")
    void testaBuscaLogradouroInvalido() throws Exception {
        // Act
        String responseJsonString = driver.perform(get("/logradouros/" + "/" + 55555)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        CustomErrorType resultado = objectMapper.readValue(responseJsonString, CustomErrorType.class);
        // Assert
        assertAll(
                () -> assertEquals("O Logradouro nao existe!", resultado.getMessage())
        );
    }
}
