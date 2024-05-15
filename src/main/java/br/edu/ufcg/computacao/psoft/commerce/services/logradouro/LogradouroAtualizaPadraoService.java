package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.dto.LogradouroPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.exception.LogradouroNaoExisteException;
import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogradouroAtualizaPadraoService implements LogradouroAtualizaService {
    @Autowired
    LogradouroRepository logradouroRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Logradouro alterar(Long id, LogradouroPostPutRequestDTO logradouroPostPutRequestDTO) {
        Logradouro logradouro = logradouroRepository.findById(id).orElseThrow(LogradouroNaoExisteException::new);
        modelMapper.map(logradouroPostPutRequestDTO, logradouro);
        return logradouroRepository.save(logradouro);
    }
}