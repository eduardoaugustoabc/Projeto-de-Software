package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.model.Pessoa;
import br.edu.ufcg.computacao.psoft.commerce.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaListarPadraoService implements PessoaListarService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> listar(Long id) {
            return this.pessoaRepository.findAll();
    }
}
