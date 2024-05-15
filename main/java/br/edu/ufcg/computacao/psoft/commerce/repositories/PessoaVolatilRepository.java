package br.edu.ufcg.computacao.psoft.commerce.repositories;

import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.exception.PessoaNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.model.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PessoaVolatilRepository implements PessoaRepository<Long, Pessoa>  {
    private Long nextId;
    private Map<Long, Pessoa> pessoaRepository;

    public PessoaVolatilRepository(){
        this.pessoaRepository = new HashMap<>();
        this.nextId = 1L;
    }

    @Override
    public Pessoa save(Pessoa pessoa){
        pessoa.setId(this.nextId++);
        this.pessoaRepository.put(pessoa.getId(), pessoa);
        return pessoa;
    }

    @Override
    public Pessoa find(Long id){
        if(this.pessoaRepository.containsKey(id)){
            return this.pessoaRepository.get(id);
        }else{
            throw new PessoaNaoExisteException();
        }

    }

    @Override
    public List<Pessoa> findAll(){
        return (List<Pessoa>) this.pessoaRepository.values();
    }

    @Override
    public Pessoa update(@PathVariable("id") Long id, @RequestBody Pessoa pessoa){
        if(this.pessoaRepository.containsKey(id)) {
            pessoa.setId(id);
            this.pessoaRepository.put(id, pessoa);
            return this.pessoaRepository.get(id);
        }else {
            throw new LogradouroNaoExisteException();
        }
    }

    @Override
    public void delete(@PathVariable("id") Long id){
        if(this.pessoaRepository.containsKey(id)){
            this.pessoaRepository.remove(id);
        }else{
            throw new PessoaNaoExisteException();
        }
    }

    @Override
    public Pessoa put(Long id, Pessoa pessoa){
        pessoa.setId(id);
        return this.pessoaRepository.put(id, pessoa);
    }
}
