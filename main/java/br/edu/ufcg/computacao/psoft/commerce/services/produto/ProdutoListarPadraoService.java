package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.model.Produto;
import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoListarPadraoService implements ProdutoListarService{
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listar(Long id) {
        return this.produtoRepository.findAll();
    }
}
