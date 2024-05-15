package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaRemoverPadraoService implements PessoaRemoverService {
    @Autowired
    PessoaRepository pessoaRepository;
    @Override
    public void excluir(Long id) {
            this.pessoaRepository.delete(id);
    }
}
