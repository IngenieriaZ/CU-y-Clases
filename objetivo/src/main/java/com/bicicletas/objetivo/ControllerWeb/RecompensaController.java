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
import com.bicicletas.objetivo.dataAccess.RecompensaRepository;
import com.bicicletas.objetivo.logica.RecompensaService;
import com.bicicletas.objetivo.modelo.Recompensa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/recompensas")
public class RecompensaController {

    @Autowired
    RecompensaRepository recompensaRepository;

    @Autowired
    RecompensaService recompensaService;

    // Obtener todas las recompensas
    @GetMapping()
    public List<Recompensa> getAllRecompensas() {
        return recompensaRepository.findAll();
    }

    // Obtener una recompensa por ID
    @GetMapping("/{id}")
    public Optional<Recompensa> getRecompensaById(@PathVariable UUID id) {
        return recompensaRepository.findById(id);
    }

    // DTO Crear Recompensa
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class CrearRecompensaRequest {
        String nombre;
        String tipo;
        String valor;
    }

    // Crear una nueva recompensa
    @PostMapping()
    public String crearRecompensa(@RequestBody CrearRecompensaRequest request) throws Exception {
        try {
            UUID idRecompensa = recompensaService.crearRecompensa(request.getNombre(), request.getTipo(), request.getValor());
            if (idRecompensa != null) {
                System.out.println("Recompensa Creada");
                return "Recompensa Creada";
            } else {
                throw new Exception("Error en la creación de la Recompensa");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error en la creación de la Recompensa";
        }
    }

    // DTO para asignar recompensa a un objetivo
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class AsignarRecompensaRequest {
        UUID recompensaId;
        UUID objetivoId;
    }

    // Asignar una recompensa a un objetivo
    @PostMapping("/asignar")
    public String asignarRecompensa(@RequestBody AsignarRecompensaRequest request) throws Exception {
        try {
            recompensaService.asignarRecompensa(request.getRecompensaId(), request.getObjetivoId());
            System.out.println("Recompensa Asignada");
            return "Recompensa Asignada";
        } catch (Exception e) {
            System.out.println("La recompensa no pudo ser asignada: " + e.getMessage());
            e.printStackTrace();
            return "La recompensa no pudo ser asignada: " + e.getMessage();
        }
    }
}
