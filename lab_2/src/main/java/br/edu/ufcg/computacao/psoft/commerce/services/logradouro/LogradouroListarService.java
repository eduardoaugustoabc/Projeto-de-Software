package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;

import java.util.List;

@FunctionalInterface
public interface LogradouroListarService {
    List<Logradouro> listar();
}
