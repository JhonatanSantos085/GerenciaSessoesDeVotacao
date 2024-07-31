package Jhon.santos.votacao.domain.services;


import Jhon.santos.votacao.domain.model.Pauta;
import Jhon.santos.votacao.domain.repositories.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    public Pauta createPauta(Pauta pauta){
        pauta.setDataDeCriacao();
        return pautaRepository.save(pauta);

    }

    public List<Pauta> listPautas(){
        return pautaRepository.findAll();
    }

}
