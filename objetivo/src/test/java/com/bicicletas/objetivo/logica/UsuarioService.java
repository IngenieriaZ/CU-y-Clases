package com.bicicletas.objetivo.logica;

import org.springframework.beans.factory.annotation.Autowired;

import com.bicicletas.objetivo.dataAccess.UsuarioRepository;
import com.bicicletas.objetivo.modelo.Usuario;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long crearUsuario(String nombre, String email, String contrasena) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setContrasena(contrasena);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return savedUsuario.getId();
    }
}
