package Jhon.santos.votacao.contoller;


import Jhon.santos.votacao.domain.model.Pauta;
import Jhon.santos.votacao.domain.services.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @PostMapping
    public Pauta createPauta(@RequestBody Pauta pauta){
        return pautaService.createPauta(pauta);
    }

    @GetMapping
    public List<Pauta> listPautas(){
        return pautaService.listPautas();
    }


}
