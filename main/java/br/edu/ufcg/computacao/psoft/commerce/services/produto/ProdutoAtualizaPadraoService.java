package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.model.Produto;
import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAtualizaPadraoService implements ProdutoAtualizaService{
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Produto alterar(Long id, ProdutoPostPutRequestDTO produtoPostPutRequestDTO) {
        Produto produto = modelMapper.map(produtoPostPutRequestDTO, Produto.class);
        return (Produto) this.produtoRepository.put(produto.getId(),produto);
    }
}
