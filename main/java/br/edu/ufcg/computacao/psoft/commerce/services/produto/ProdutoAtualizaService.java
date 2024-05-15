package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.model.Produto;

@FunctionalInterface
public interface ProdutoAtualizaService {
    Produto alterar(Long id, ProdutoPostPutRequestDTO produtoPostPutRequestDTO);
}
