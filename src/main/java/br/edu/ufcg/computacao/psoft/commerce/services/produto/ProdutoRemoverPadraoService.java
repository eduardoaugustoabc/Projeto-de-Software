package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.exception.ProdutoNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.models.Produto;
import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoRemoverPadraoService implements ProdutoRemoverService{
    @Autowired
    ProdutoRepository produtoRepository;
    @Override
    public void excluir(Long id) {
        Produto produto = this.produtoRepository.findById(id).orElseThrow(ProdutoNaoExisteException::new);
        this.produtoRepository.delete(produto);
    }
}
