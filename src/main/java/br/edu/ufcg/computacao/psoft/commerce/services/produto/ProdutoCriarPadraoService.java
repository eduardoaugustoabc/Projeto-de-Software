package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.models.Produto;
import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoCriarPadraoService implements ProdutoCriarService{
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Produto salvar(ProdutoPostPutRequestDTO produtoPostPutRequestDTO) {
        Produto produto = modelMapper.map(produtoPostPutRequestDTO, Produto.class);
        return this.produtoRepository.save(produto);
    }
}
