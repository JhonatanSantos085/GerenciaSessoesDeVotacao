package Jhon.santos.votacao.domain.services;

import Jhon.santos.votacao.domain.model.Voto;
import Jhon.santos.votacao.domain.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public Voto createVoto(Voto voto){
        if(votoRepository.existsBySessaoVotacaoAndUsuario(voto.getSessaoVotacao(),voto.getUsuario())){
            throw new RuntimeException("O usuario ja votou nesta sessao de votacao.");
        }


        voto.setDataHoraDoVoto();
        return votoRepository.save(voto);
    }

    public List<Voto> listVotos(){
        return votoRepository.findAll();
    }

}
