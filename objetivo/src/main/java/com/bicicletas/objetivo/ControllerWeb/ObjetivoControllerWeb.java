package com.bicicletas.objetivo.ControllerWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.logica.ObjetivosService;
import com.bicicletas.objetivo.modelo.Objetivo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoControllerWeb {


    @Autowired
    ObjetivoRepository objetivoRepository;

    @Autowired
    ObjetivosService objetivoService;

    // Controlador Web Leer Todos los Objetivos
    // ruta: /objetivos
    @GetMapping()
    public List<Objetivo> leerTodos() {
        return objetivoRepository.findAll();
    }

    // DTO Crear Objetivo
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class CrearObjetivoRequest {
        String nombre;
        String descripcion;
        boolean iniciado;
        Integer vencimiento;
    }

    // Controlador Web Crear Objetivo
    @PostMapping()
    public String crearObjetivo(@RequestBody CrearObjetivoRequest request) throws Exception {
        try {
            UUID idObjetivo = objetivoService.establecerObjetivo(request.getNombre(), request.getDescripcion(),request.iniciado, request.getVencimiento());
            if (idObjetivo != null) {
                System.out.println("Objetivo Creado");
                return "Objetivo Creado";
            } else {
                throw new Exception("Error en la creación del Objetivo");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error en la creación del Objetivo";
        }
    }
}
