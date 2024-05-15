package br.edu.ufcg.computacao.psoft.commerce.services.produto;

import br.edu.ufcg.computacao.psoft.commerce.dto.ProdutoNomePatchRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.model.Produto;
import br.edu.ufcg.computacao.psoft.commerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAtualizarNomePadraoService implements ProdutoAtualizarNomeService{
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Produto alterarParcialmente(Long id, ProdutoNomePatchRequestDTO produtoNomePatchRequestDTO) {
        //Produto produto = produtoRepository.findById(id).orElseThrow(ProdutoNaoExisteException::new);
        Produto produto = (Produto) this.produtoRepository.find(id);
        modelMapper.map(produtoNomePatchRequestDTO, produto);
        return (Produto) produtoRepository.save(produto);
    }
}
