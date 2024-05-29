package com.bicicletas.objetivo.logica;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.dataAccess.UsuarioRepository;
import com.bicicletas.objetivo.modelo.Objetivo;
import com.bicicletas.objetivo.modelo.Usuario;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ObjetivoRepository objetivoRepository;

    public Long crearUsuario(String nombre, String email) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        return usuarioRepository.save(usuario).getId();
    }

    public List<Objetivo> getObjetivosCumplidos(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return objetivoRepository.findByUsuarioAndCompletado(usuario, true);
    }

    public List<Objetivo> getObjetivosPorCumplir(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return objetivoRepository.findByUsuarioAndCompletado(usuario, false);
    }

    public void asignarObjetivo(Integer usuarioId, UUID objetivoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Objetivo objetivo = objetivoRepository.findById(objetivoId).orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));
        objetivo.setUsuario(usuario);
        objetivoRepository.save(objetivo);
    }
}
