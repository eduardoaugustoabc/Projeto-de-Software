package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.model.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogradouroListarUmPadraoService implements LogradouroListarUmService{

    @Autowired
    LogradouroRepository logradouroRepository;

    @Override
    public Logradouro listarUm(Long id) {
        return (Logradouro) this.logradouroRepository.find(id);
    }
}
