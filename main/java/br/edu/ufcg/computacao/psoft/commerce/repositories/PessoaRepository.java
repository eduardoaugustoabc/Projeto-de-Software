package br.edu.ufcg.computacao.psoft.commerce.repositories;

import java.util.List;

public interface PessoaRepository<T, Pessoa> {

    Pessoa save(Pessoa pessoa);

    Pessoa find(Long id);
    List<Pessoa> findAll();

    Pessoa update(Long id, Pessoa pessoa);

    void delete(Long id);

    Pessoa put(Long id, Pessoa pessoa);
}


