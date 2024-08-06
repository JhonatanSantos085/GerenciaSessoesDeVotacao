package Jhon.santos.votacao.domain.services;

import Jhon.santos.votacao.domain.model.Pauta;
import Jhon.santos.votacao.domain.model.SessaoVotacao;
import Jhon.santos.votacao.domain.repositories.SessaoRepository;
import Jhon.santos.votacao.domain.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private VotoRepository votoRepository;

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

    public Map<String, Long> calcularVotos(Long sessaoVotacaoId){
        SessaoVotacao sessaoVotacao = sessaoRepository.findById(sessaoVotacaoId)
                .orElseThrow(() -> new RuntimeException("Sessao de votacao nao encontrada!!"));

        Long votosSim = votoRepository.countBySessaoVotacaoAndVoto(sessaoVotacao,"sim");
        Long votosNao = votoRepository.countBySessaoVotacaoAndVoto(sessaoVotacao, "nao");

        Map<String, Long>resultado = new HashMap<>();
        resultado.put("sim", votosSim);
        resultado.put("nao", votosNao);

        return resultado;
    }

}
