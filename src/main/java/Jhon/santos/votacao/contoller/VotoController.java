package Jhon.santos.votacao.contoller;


import Jhon.santos.votacao.domain.model.Voto;
import Jhon.santos.votacao.domain.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public Voto createVoto(@RequestBody Voto voto){
        return votoService.createVoto(voto);
    }

    @GetMapping
    public List<Voto> listVotos(){
        return votoService.listVotos();
    }
}
