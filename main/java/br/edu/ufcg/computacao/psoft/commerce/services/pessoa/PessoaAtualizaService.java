package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.dto.PessoaPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.model.Pessoa;

@FunctionalInterface
public interface PessoaAtualizaService {
    Pessoa alterar(Long id, PessoaPostPutRequestDTO pessoaPostPutRequestDTO);
}
