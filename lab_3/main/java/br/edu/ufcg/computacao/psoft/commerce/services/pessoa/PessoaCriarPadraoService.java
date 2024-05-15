package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.dto.PessoaPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.model.Pessoa;
import br.edu.ufcg.computacao.psoft.commerce.repositories.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaCriarPadraoService implements PessoaCriarService {
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Pessoa salvar(PessoaPostPutRequestDTO pessoaPostPutRequestDTO) {
        Pessoa pessoa = modelMapper.map(pessoaPostPutRequestDTO, Pessoa.class);
        return (Pessoa) this.pessoaRepository.put(pessoa.getId(), pessoa);
    }
}
