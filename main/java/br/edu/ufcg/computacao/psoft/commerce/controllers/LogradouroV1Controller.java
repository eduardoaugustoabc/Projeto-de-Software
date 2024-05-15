package br.edu.ufcg.computacao.psoft.commerce.controllers;

import br.edu.ufcg.computacao.psoft.commerce.dto.LogradouroPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.services.logradouro.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/logradouros", produces = MediaType.APPLICATION_JSON_VALUE)
public class LogradouroV1Controller {
    @Autowired
    LogradouroListarService logradouroListarService;
    @Autowired
    LogradouroListarUmService logradouroListarUmService;
    @Autowired
    LogradouroCriarService logradouroCriarService;
    @Autowired
    LogradouroAtualizaService logradouroAtualizaService;
    @Autowired
    LogradouroRemoverService logradouroRemoverService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUmLogradouro(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(logradouroListarUmService.listarUm(id));
    }

    @GetMapping("")
    public ResponseEntity<?> buscarTodosLogradouros() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(logradouroListarService.listar(null));
    }

    @PostMapping()
    public ResponseEntity<?> salvarLogradouro(@RequestBody @Valid LogradouroPostPutRequestDTO logradouroPostPutRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(logradouroCriarService.salvar(logradouroPostPutRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLogradouro(@PathVariable Long id, @RequestBody @Valid LogradouroPostPutRequestDTO logradouroPostPutRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(logradouroAtualizaService.alterar(id, logradouroPostPutRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirLogradouro(@PathVariable Long id) {
        logradouroRemoverService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }
}
