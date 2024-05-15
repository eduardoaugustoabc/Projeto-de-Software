package br.edu.ufcg.computacao.psoft.commerce.repositories;

import java.util.List;

public interface LogradouroRepository<T, Logradouro> {
    Logradouro save(Logradouro logradouro);
    Logradouro find(Long id);
    List<Logradouro> findAll();

    Logradouro update(Long id, Logradouro logradouro);

    void delete(Long id);

    Logradouro put(Long id, Logradouro logradouro);
}
