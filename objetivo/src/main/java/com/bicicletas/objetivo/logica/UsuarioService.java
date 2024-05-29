package com.bicicletas.objetivo.logica;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bicicletas.objetivo.dataAccess.UsuarioRepository;
import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.modelo.Usuario;
import com.bicicletas.objetivo.modelo.Objetivo;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ObjetivoRepository objetivoRepository;

    // Crear Usuario
    public Long crearUsuario(String nombre, String email, String contrasena) throws Exception {
        // Verificar si el correo electrónico ya está registrado
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente.isPresent()) {
            throw new Exception("El correo electrónico ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setContrasena(contrasena);
        usuario = usuarioRepository.save(usuario);
        return usuario.getId();
    }

    // Obtener objetivos cumplidos por usuario
    public List<Objetivo> getObjetivosCumplidos(Long usuarioId) throws Exception {
        Optional<Usuario> optUsuario = usuarioRepository.findById(usuarioId);
        if (optUsuario.isEmpty()) {
            throw new Exception("Usuario no encontrado");
        }
        return objetivoRepository.findByUsuarioAndCompletado(optUsuario.get(), true);
    }

    // Obtener objetivos por cumplir por usuario
    public List<Objetivo> getObjetivosPorCumplir(Long id) throws Exception {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if (optUsuario.isEmpty()) {
            throw new Exception("Usuario no encontrado");
        }
        return objetivoRepository.findByUsuarioAndCompletado(optUsuario.get(), false);
    }

    // Asignar un objetivo a un usuario
    public void asignarObjetivo(Long integer, UUID objetivoId) throws Exception {
        Optional<Usuario> optUsuario = usuarioRepository.findById(integer);
        if (optUsuario.isEmpty()) {
            throw new Exception("Usuario no encontrado");
        }
        Optional<Objetivo> optObjetivo = objetivoRepository.findById(objetivoId);
        if (optObjetivo.isEmpty()) {
            throw new Exception("Objetivo no encontrado");
        }
        Objetivo objetivo = optObjetivo.get();
        Usuario usuario = optUsuario.get();
        objetivo.setUsuario(usuario);
        objetivoRepository.save(objetivo);
    }
}
