package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.dto.LogradouroPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.model.Logradouro;

@FunctionalInterface
public interface LogradouroAtualizaService {
    Logradouro alterar(Long id, LogradouroPostPutRequestDTO logradouroPostPutRequestDTO);
}
