package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.model.Logradouro;

import java.util.List;

@FunctionalInterface
public interface LogradouroListarService {
    List<Logradouro> listar(Long id);
}
