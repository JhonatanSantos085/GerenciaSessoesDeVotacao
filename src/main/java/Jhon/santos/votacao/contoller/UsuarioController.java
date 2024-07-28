package Jhon.santos.votacao.contoller;


import Jhon.santos.votacao.domain.services.UsuarioService;
import Jhon.santos.votacao.domain.user.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario){
        return usuarioService.createUser(usuario);
    }

    @GetMapping
    public List<Usuario> listUsers(){
        return usuarioService.listUsers();
    }
}
