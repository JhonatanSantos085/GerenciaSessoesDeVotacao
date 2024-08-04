package Jhon.santos.votacao.domain.services;

import Jhon.santos.votacao.domain.model.Pauta;
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
        Pauta pauta = sessaoVotacao.getPauta();
        if(pauta.getSessaoVotacao() != null){
            throw new RuntimeException("A pauta ja possui uma sessao de votacao");
        }
        sessaoVotacao.setDataInicio();
        sessaoVotacao.setStatus("aberta");
        pauta.setSessaoVotacao(sessaoVotacao);
        return sessaoRepository.save(sessaoVotacao);
    }

    public List<SessaoVotacao>listSessoes(){
        return sessaoRepository.findAll();
    }
}
