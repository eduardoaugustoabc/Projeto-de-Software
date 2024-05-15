package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.exception.PessoaNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.models.Pessoa;
import br.edu.ufcg.computacao.psoft.commerce.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaListarUmaPadraoService implements PessoaListarUmaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public Pessoa listarUma(Long id) {
        return pessoaRepository.findById(id).orElseThrow(PessoaNaoExisteException::new);
    }
}
