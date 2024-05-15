package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.models.Produto;

import java.util.List;

@FunctionalInterface
public interface ProdutoListarService {
    List<Produto> listar();
}
