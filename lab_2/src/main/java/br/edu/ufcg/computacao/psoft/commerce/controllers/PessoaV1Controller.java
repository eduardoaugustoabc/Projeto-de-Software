package br.edu.ufcg.computacao.psoft.commerce.controllers;

import br.edu.ufcg.computacao.psoft.commerce.dto.PessoaPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.services.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;

@RestController
@RequestMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaV1Controller {
    @Autowired
    PessoaListarService pessoaListarService;
    @Autowired
    PessoaListarUmaService pessoaListarUmaService;
    @Autowired
    PessoaCriarService pessoaCriarService;
    @Autowired
    PessoaAtualizaService pessoaAtualizaService;
    @Autowired
    PessoaRemoverService pessoaRemoverService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUmaPessoa(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pessoaListarUmaService.listarUma(id));
    }

    @GetMapping("")
    public ResponseEntity<?> buscarTodasPessoas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pessoaListarService.listar());
    }

    @PostMapping()
    public ResponseEntity<?> salvarPessoa(@RequestBody @Valid PessoaPostPutRequestDTO pessoaPostPutRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pessoaCriarService.salvar(pessoaPostPutRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid PessoaPostPutRequestDTO pessoaPostPutRequestDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pessoaAtualizaService.alterar(id, pessoaPostPutRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable Long id) {
        pessoaRemoverService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }
}
