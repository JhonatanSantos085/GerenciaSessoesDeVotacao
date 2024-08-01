package Jhon.santos.votacao.domain.services;

import Jhon.santos.votacao.domain.model.SessaoVotacao;
import Jhon.santos.votacao.domain.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public SessaoVotacao createSessaoVotacao(SessaoVotacao sessaoVotacao){
        sessaoVotacao.setDataInicio();
        sessaoVotacao.setStatus("aberta");
        return sessaoRepository.save(sessaoVotacao);
    }

    public List<SessaoVotacao>listSessoes(){
        return sessaoRepository.findAll();
    }
}
