package br.edu.ufcg.computacao.psoft.commerce.repositories;

import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.exception.PessoaNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.exception.ProdutoNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProdutoVolatilRepository implements ProdutoRepository<Long, Produto>  {
    private Long nextId;
    private Map<Long, Produto> produtoRepository;

    public ProdutoVolatilRepository(){
        this.produtoRepository = new HashMap<>();
        this.nextId = 1L;
    }
    @Override
    public Produto save(Produto produto){
        produto.setId(this.nextId++);
        this.produtoRepository.put(produto.getId(), produto);
        return produto;
    }

    @Override
    public Produto find(Long id){
        if(this.produtoRepository.containsKey(id)){
            return this.produtoRepository.get(id);
        }
        throw new ProdutoNaoExisteException();
    }

    @Override
    public List<Produto> findAll(){
        return (List<Produto>) this.produtoRepository.values();
    }

    @Override
    public Produto update(@PathVariable("id") Long id, @RequestBody Produto produto){
        if(this.produtoRepository.containsKey(id)) {
            produto.setId(id);
            this.produtoRepository.put(id, produto);
            return this.produtoRepository.get(id);
        }else {
            throw new LogradouroNaoExisteException();
        }
    }

    @Override
    public void delete(@PathVariable("id") Long id){
        if(this.produtoRepository.containsKey(id)){
            this.produtoRepository.remove(id);
        }else{
            throw new PessoaNaoExisteException();
        }
    }

    @Override
    public Produto put(Long id, Produto produto){
        produto.setId(id);
        return this.produtoRepository.put(id, produto);
    }
}