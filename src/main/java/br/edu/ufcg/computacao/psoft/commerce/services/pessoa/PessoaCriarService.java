package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.dto.PessoaPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.models.Pessoa;

@FunctionalInterface
public interface PessoaCriarService {
    Pessoa salvar(PessoaPostPutRequestDTO pessoaPostPutRequestDTO);
}


