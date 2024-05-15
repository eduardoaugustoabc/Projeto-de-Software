package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroVolatilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogradouroRemoverPadraoService implements LogradouroRemoverService{
    @Autowired
    LogradouroVolatilRepository logradouroRepository;
    @Override
    public void excluir(Long id) {
        this.logradouroRepository.delete(id);
    }
}
