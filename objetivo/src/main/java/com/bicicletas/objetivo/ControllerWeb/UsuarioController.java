package com.bicicletas.objetivo.ControllerWeb;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.dataAccess.UsuarioRepository;
import com.bicicletas.objetivo.logica.UsuarioService;
import com.bicicletas.objetivo.modelo.Objetivo;
import com.bicicletas.objetivo.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    ObjetivoRepository objetivoRepository;
    
    @Autowired
    UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping()
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }
    
    // Obtener objetivos cumplidos por un usuario
    @GetMapping("/{id}/objetivos-cumplidos")
    public List<Objetivo> getObjetivosCumplidos(@PathVariable Long id) throws Exception {
        return usuarioService.getObjetivosCumplidos(id);
    }

    // Obtener objetivos por cumplir por un usuario
    @GetMapping("/{id}/objetivos-por-cumplir")
    public List<Objetivo> getObjetivosPorCumplir(@PathVariable Long id) throws Exception {
        return usuarioService.getObjetivosPorCumplir(id);
    }

    // DTO Crear Usuario
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class CrearUsuarioRequest {
        String nombre;
        String email;
        String contrasena;
    }

    // Crear un nuevo usuario
    @PostMapping()
    public String crearUsuario(@RequestBody CrearUsuarioRequest request) throws Exception {
        try {
            Long idUsuario = usuarioService.crearUsuario(request.getNombre(), request.getEmail(), request.getContrasena());
            if (idUsuario != null) {
                System.out.println("Usuario Creado");
                return "Usuario Creado";
            } else {
                throw new Exception("Error en la creación del Usuario");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error en la creación del Usuario";
        }
    }
    

    // DTO para asignar objetivos a usuarios
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class AsignarObjetivoRequest {
        Long usuarioId;
        UUID objetivoId;
    }

    // Asignar un objetivo a un usuario
    @PostMapping("/asignar-objetivo")
    public String asignarObjetivo(@RequestBody AsignarObjetivoRequest request) throws Exception {
        try {
            usuarioService.asignarObjetivo(request.getUsuarioId(), request.getObjetivoId());
            System.out.println("Objetivo Asignado");
            return "Objetivo Asignado";
        } catch (Exception e) {
            System.out.println("El objetivo no pudo ser asignado: " + e.getMessage());
            e.printStackTrace();
            return "El objetivo no pudo ser asignado: " + e.getMessage();
        }
    }
}
