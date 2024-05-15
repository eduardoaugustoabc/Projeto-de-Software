package br.edu.ufcg.computacao.psoft.commerce.repositories;

import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.model.Logradouro;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LogradouroVolatilRepository implements LogradouroRepository<Long, Logradouro> {
    private Long nextId;
    private Map<Long, Logradouro> logradouroRepository;

    public LogradouroVolatilRepository() {
        this.logradouroRepository = new HashMap<>();
        this.nextId = 1L;
    }

    @Override
    public Logradouro save(Logradouro logradouro){
        logradouro.setId(this.nextId++);
        this.logradouroRepository.put(logradouro.getId(), logradouro);
        return logradouro;
    }

    @Override
    public Logradouro find(Long id){
        if(this.logradouroRepository.containsKey(id)){
            return this.logradouroRepository.get(id);
        }else{
            throw new LogradouroNaoExisteException();
        }
    }

    @Override
    public List<Logradouro> findAll(){
        return (List<Logradouro>) this.logradouroRepository.values();
    }

    @Override
    public Logradouro update(@PathVariable("id") Long id, @RequestBody Logradouro logradouro){
        if(this.logradouroRepository.containsKey(id)) {
            logradouro.setId(id);
            this.logradouroRepository.put(id, logradouro);
            return this.logradouroRepository.get(id);
        }else {
            throw new LogradouroNaoExisteException();
        }
    }

    @Override
    public void delete(@PathVariable("id") Long id){
        if(this.logradouroRepository.containsKey(id)){
            this.logradouroRepository.remove(id);
        }else{
            throw new LogradouroNaoExisteException();
        }
    }

    @Override
    public Logradouro put(Long id, Logradouro logradouro){
        logradouro.setId(id);
        return this.logradouroRepository.put(id, logradouro);
    }
}
