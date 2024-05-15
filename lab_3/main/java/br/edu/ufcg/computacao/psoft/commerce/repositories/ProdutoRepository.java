package br.edu.ufcg.computacao.psoft.commerce.repositories;

import java.util.List;

public interface ProdutoRepository<T, Produto> {

    Produto save(Produto pessoa);

    Produto find(Long id);
    List<Produto> findAll();

    Produto update(Long id, Produto pessoa);

    void delete(Long id);

    Produto put(Long id, Produto pessoa);
}



