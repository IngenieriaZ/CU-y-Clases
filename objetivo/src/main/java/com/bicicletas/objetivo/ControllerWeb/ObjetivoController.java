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
import com.bicicletas.objetivo.logica.ObjetivoService;
import com.bicicletas.objetivo.modelo.Objetivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    ObjetivoRepository objetivoRepository;
    
    @Autowired
    ObjetivoService objetivoService;

    // Obtener todos los objetivos
    @GetMapping()
    public List<Objetivo> getAllObjetivos() {
        return objetivoRepository.findAll();
    }

    // Obtener un objetivo por ID
    @GetMapping("/{id}")
    public Optional<Objetivo> getObjetivoById(@PathVariable UUID id) {
        return objetivoRepository.findById(id);
    }

    // DTO Crear Objetivo
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class CrearObjetivoRequest {
        String nombre;
        String descripcion;
        Integer vencimiento;
    }

    // Crear un nuevo objetivo
    @PostMapping()
    public String crearObjetivo(@RequestBody CrearObjetivoRequest request) throws Exception {
        try {
            UUID idObjetivo = objetivoService.crearObjetivo(request.getNombre(), request.getDescripcion(), request.getVencimiento());
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

    // DTO para actualizar el estado del objetivo
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class ActualizarEstadoObjetivoRequest {
        boolean completado;
        boolean iniciado;
    }

    // Actualizar el estado de un objetivo
    @PostMapping("/{id}/actualizar-estado")
    public String actualizarEstadoObjetivo(@PathVariable UUID id, @RequestBody ActualizarEstadoObjetivoRequest request) throws Exception {
        try {
            Objetivo objetivo = objetivoService.actualizarEstadoObjetivo(id, request.isCompletado(), request.isIniciado());
            if (objetivo != null) {
                System.out.println("Estado del Objetivo Actualizado");
                return "Estado del Objetivo Actualizado";
            } else {
                throw new Exception("Error en la actualización del estado del Objetivo");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error en la actualización del estado del Objetivo";
        }
    }
}
