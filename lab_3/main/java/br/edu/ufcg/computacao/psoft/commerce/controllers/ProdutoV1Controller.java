package br.edu.ufcg.computacao.psoft.commerce.controllers;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoNomePatchRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.services.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoV1Controller {
    @Autowired
    ProdutoListarService produtoListarService;
    @Autowired
    ProdutoListarUmService produtoListarUmService;
    @Autowired
    ProdutoCriarService produtoCriarService;
    @Autowired
    ProdutoAtualizaService produtoAtualizaService;

    @Autowired
    ProdutoAtualizarNomeService produtoAtualizaNomeService;

    @Autowired
    ProdutoRemoverService produtoRemoverService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUmProduto(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produtoListarUmService.listarUm(id));
    }

    @GetMapping("")
    public ResponseEntity<?> buscarTodasProdutos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produtoListarService.listar(null));
    }

    @PostMapping()
    public ResponseEntity<?> salvarProduto(@RequestBody @Valid ProdutoPostPutRequestDTO produtoPostPutRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produtoCriarService.salvar(produtoPostPutRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoPostPutRequestDTO produtoPostPutRequestDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produtoAtualizaService.alterar(id, produtoPostPutRequestDto));
    }

    @PatchMapping
    public ResponseEntity<?> atualizarNomeProduto(@PathVariable Long id, @RequestBody @Valid ProdutoNomePatchRequestDTO produtoPostPutRequestDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(produtoAtualizaNomeService.alterarParcialmente(id, produtoPostPutRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        produtoRemoverService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }
}
