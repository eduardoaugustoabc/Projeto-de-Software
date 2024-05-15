package br.edu.ufcg.computacao.psoft.commerce.services.pessoa;

import br.edu.ufcg.computacao.psoft.commerce.dto.LogradouroPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.dto.PessoaPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.exception.PessoaNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.models.Pessoa;
import br.edu.ufcg.computacao.psoft.commerce.repositories.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaAtualizaPadraoService implements PessoaAtualizaService{
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Pessoa alterar(Long id, PessoaPostPutRequestDTO pessoaPostPutRequestDTO) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(PessoaNaoExisteException::new);
        modelMapper.map(pessoaPostPutRequestDTO, pessoa);
        return pessoaRepository.save(pessoa);
    }
}
