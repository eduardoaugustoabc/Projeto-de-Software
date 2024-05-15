package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogradouroListarPadraoService implements LogradouroListarService{
    @Autowired
    LogradouroRepository logradouroRepository;

    @Override
    public List<Logradouro> listar() {
        return logradouroRepository.findAll().stream().toList();
    }
}
