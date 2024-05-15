package br.edu.ufcg.computacao.psoft.commerce.controllers;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.exception.CustomErrorType;
import br.edu.ufcg.computacao.psoft.commerce.models.Produto;
import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do controlador de Produto")
public class ProdutoControllerTests {
    @Autowired
    MockMvc driver;

    @Autowired
    ProdutoRepository produtoRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    Produto produto;

    @BeforeEach
    void setup() {
        // Object Mapper suporte para LocalDateTime
        objectMapper.registerModule(new JavaTimeModule());
        produto = Produto.builder()
                .nome_produto("brinquedo")
                .codigo_barras("4 012345 678901")
                .preco(45.5)
                .nome_fabricante("brinquedos de campina")
                .build();
    }

    @Nested
    @DisplayName("Conjunto de casos de operações em produto")
    class OperacoesEmProduto {
        @Test
        @Transactional
        @DisplayName("Teste com valor negativo")
        void testaValorNegativo() throws Exception {
            // Arrange
            ProdutoPostPutRequestDTO produtoPostPutRequestDTO = ProdutoPostPutRequestDTO.builder()
                    .nome_produto(produto.getNome_produto())
                    .codigo_barras(produto.getCodigo_barras())
                    .preco(-1)
                    .nome_fabricante(produto.getNome_fabricante())
                    .build();

            // Act
            String responseJsonString = driver.perform(post("/produtos")

                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(produtoPostPutRequestDTO)))
                    .andExpect(status().isBadRequest())
                    .andDo(print())
                    .andReturn().getResponse().getContentAsString();

            // Assert
            assertTrue(responseJsonString.contains("Preco nao pode ser 0 ou menor"));
        }
    }

    @Test
    @Transactional
    @DisplayName("Teste com nome inválido")
    void testaNomeInvalido() throws Exception {
        // Arrange
        ProdutoPostPutRequestDTO produtoPostPutRequestDTO = ProdutoPostPutRequestDTO.builder()
                .nome_produto(null)
                .codigo_barras(produto.getCodigo_barras())
                .preco(produto.getPreco())
                .nome_fabricante(produto.getNome_fabricante())
                .build();

        // Act
        String responseJsonString = driver.perform(post("/produtos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produtoPostPutRequestDTO)))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        // Assert
        assertTrue(responseJsonString.contains("Precisa ter um nome do produto"));
    }

    @Test
    @Transactional
    @DisplayName("Teste com nome do fabricante inválido")
    void testaFabricanteInvalido() throws Exception {
        // Arrange
        ProdutoPostPutRequestDTO produtoPostPutRequestDTO = ProdutoPostPutRequestDTO.builder()
                .nome_produto(produto.getNome_produto())
                .codigo_barras(produto.getCodigo_barras())
                .preco(produto.getPreco())
                .nome_fabricante(null)
                .build();

        // Act
        String responseJsonString = driver.perform(post("/produtos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produtoPostPutRequestDTO)))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        // Assert
        assertTrue(responseJsonString.contains("Precisa ter um nome do fabricante"));
    }
    @Test
    @Transactional
    @DisplayName("Teste de busca por produto inválido")
    void testaBuscaProdutoInvalido() throws Exception {
        // Act
        String responseJsonString = driver.perform(get("/produtos/" + "/" + 55555)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        CustomErrorType resultado = objectMapper.readValue(responseJsonString, CustomErrorType.class);
        // Assert
        assertAll(
                () -> assertEquals("O Produto consultado nao existe!", resultado.getMessage())
        );
    }

    @Test
    @Transactional
    @DisplayName("Teste de busca por produto válido")
    void testaBuscaProdutoValido() throws Exception {
        //Arrange
        //Nao precisa gracas ao before each
        // Act
        String responseJsonString = driver.perform(get("/produtos" + "/" + 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        Produto resultado = objectMapper.readValue(responseJsonString, Produto.class);

        // Assert
        assertAll(
                () -> assertEquals(produto.getId().longValue(), resultado.getId().longValue()),
                () -> assertEquals(produto.getNome_produto(), resultado.getNome_produto()),
                () -> assertEquals(produto.getNome_fabricante(), resultado.getNome_fabricante())
        );
    }
    @Test
    @Transactional
    @DisplayName("Quando excluímos um produto salvo")
    void testaExcluirProdutoValido() throws Exception {
        // Arrange
        // nenhuma necessidade além do setup()
        // Act
        String responseJsonString = driver.perform(delete("/produtos/" + "/" + produto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent()) // Codigo 204
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        // Assert
        assertTrue(responseJsonString.isBlank());

    }
}

