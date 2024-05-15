package br.edu.ufcg.computacao.psoft.commerce.services.produto;

@FunctionalInterface
public interface ProdutoRemoverService {
    void excluir(Long id);
}
