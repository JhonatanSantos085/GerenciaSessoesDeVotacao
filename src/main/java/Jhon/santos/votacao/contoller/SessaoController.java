package Jhon.santos.votacao.contoller;


import Jhon.santos.votacao.domain.model.SessaoVotacao;
import Jhon.santos.votacao.domain.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sessoesVotacao")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @PostMapping
    public SessaoVotacao createSessaoVotacao(@RequestBody SessaoVotacao sessaoVotacao){
        return sessaoService.createSessaoVotacao((sessaoVotacao));
    }

    @GetMapping
    public List<SessaoVotacao>listSessoes(){
        return sessaoService.listSessoes();
    }

    @GetMapping("/{id}/calcular-votos")
    public Map<String, Long> calcularVotos(@PathVariable Long id){
        return sessaoService.calcularVotos(id);
    }

}
