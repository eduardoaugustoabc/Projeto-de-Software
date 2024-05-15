package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.model.Pessoa;

import java.util.List;

@FunctionalInterface
public interface PessoaListarService {
    List<Pessoa> listar(Long id);
}
