package br.edu.ufcg.computacao.psoft.commerce.services.logradouro;

import br.edu.ufcg.computacao.psoft.commerce.dto.LogradouroPostPutRequestDTO;
import br.edu.ufcg.computacao.psoft.commerce.models.Logradouro;
import br.edu.ufcg.computacao.psoft.commerce.repositories.LogradouroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogradouroCriarPadraoService implements LogradouroCriarService {
    @Autowired
    LogradouroRepository logradouroRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Logradouro salvar(LogradouroPostPutRequestDTO logradouroPostPutRequestDTO) {
        Logradouro logradouro = modelMapper.map(logradouroPostPutRequestDTO, Logradouro.class);
        return this.logradouroRepository.save(logradouro);
    }

}
