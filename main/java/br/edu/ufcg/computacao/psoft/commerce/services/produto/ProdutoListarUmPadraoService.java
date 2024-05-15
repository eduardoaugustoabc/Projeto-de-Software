package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.model.Produto;
import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoListarUmPadraoService implements ProdutoListarUmService{
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produto listarUm(Long id) {
        return (Produto) this.produtoRepository.find(id);
    }
}
