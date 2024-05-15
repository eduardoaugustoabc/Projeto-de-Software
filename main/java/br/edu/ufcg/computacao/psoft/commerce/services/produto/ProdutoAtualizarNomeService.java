package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoNomePatchRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.model.Produto;

@FunctionalInterface
public interface ProdutoAtualizarNomeService {
    Produto alterarParcialmente(Long id, ProdutoNomePatchRequestDTO produtoNomePatchRequestDTO);
}


