package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.models.Pessoa;

@FunctionalInterface
public interface PessoaListarUmaService {
    Pessoa listarUma(Long id);
}
