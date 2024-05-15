package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.models.Produto;

@FunctionalInterface
public interface ProdutoCriarService {
    Produto salvar(ProdutoPostPutRequestDTO produtoPostPutRequestDTO);
}
