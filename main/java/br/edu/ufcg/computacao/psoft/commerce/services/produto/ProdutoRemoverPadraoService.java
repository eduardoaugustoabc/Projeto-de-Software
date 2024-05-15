package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoRemoverPadraoService implements ProdutoRemoverService{
    @Autowired
    ProdutoRepository produtoRepository;
    @Override
    public void excluir(Long id) {
       this.produtoRepository.delete(id);
    }
}
