package com.bicicletas.objetivo.logica;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bicicletas.objetivo.dataAccess.RecompensaRepository;
import com.bicicletas.objetivo.modelo.Objetivo;
import com.bicicletas.objetivo.modelo.Recompensa;

@Service
public class RecompensaService {

    @Autowired
    RecompensaRepository recompensaRepository;

    // Crear Recompensa
    public UUID crearRecompensa(String nombre, String tipo, String valor) throws Exception {
        Recompensa recompensa = new Recompensa();
        recompensa.setNombre(nombre);
        recompensa.setTipo(tipo);
        recompensa.setValor(valor);
        recompensa = recompensaRepository.save(recompensa);
        return recompensa.getId();
    }

    // Obtener todas las recompensas
    public List<Recompensa> obtenerRecompensas() {
        return recompensaRepository.findAll();
    }

    // Asignar recompensa a un objetivo
    public void asignarRecompensa(UUID recompensaId, UUID objetivoId) throws Exception {
        Optional<Recompensa> optRecompensa = recompensaRepository.findById(recompensaId);
        if (optRecompensa.isEmpty()) {
            throw new Exception("Recompensa no encontrada");
        }
        Recompensa recompensa = optRecompensa.get();
        recompensa.setObjetivo(new Objetivo());
        recompensa.getObjetivo().setId(objetivoId);
        recompensaRepository.save(recompensa);
    }
}
