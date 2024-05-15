package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.model.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogradouroListarPadraoService implements LogradouroListarService{
    @Autowired
    LogradouroRepository logradouroRepository;

    @Override
    public List<Logradouro> listar(Long id) {
        return this.logradouroRepository.findAll();
    }
}
