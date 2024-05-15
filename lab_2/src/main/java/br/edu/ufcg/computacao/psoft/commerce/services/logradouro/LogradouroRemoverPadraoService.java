package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogradouroRemoverPadraoService implements LogradouroRemoverService{
    @Autowired
    LogradouroRepository logradouroRepository;
    @Override
    public void excluir(Long id) {
        Logradouro logradouro = this.logradouroRepository.findById(id).orElseThrow(LogradouroNaoExisteException::new);
        this.logradouroRepository.delete(logradouro);
    }
}
