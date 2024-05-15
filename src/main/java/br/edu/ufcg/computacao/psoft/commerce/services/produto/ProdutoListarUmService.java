package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.models.Produto;

@FunctionalInterface
public interface ProdutoListarUmService {
    Produto listarUm(Long id);
}
