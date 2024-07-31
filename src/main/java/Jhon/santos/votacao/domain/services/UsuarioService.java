package Jhon.santos.votacao.domain.services;


import Jhon.santos.votacao.domain.repositories.UsuarioRepository;
import Jhon.santos.votacao.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listUsers(){
        return usuarioRepository.findAll();
    }
}
