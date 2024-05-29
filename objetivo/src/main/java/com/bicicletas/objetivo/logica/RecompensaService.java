package com.bicicletas.objetivo.logica;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bicicletas.objetivo.dataAccess.RecompensaRepository;
import com.bicicletas.objetivo.modelo.Recompensa;

@Service
public class RecompensaService {

    @Autowired
    RecompensaRepository recompensaRepository;

    public List<Recompensa> obtenerTodasLasRecompensas() {
        return recompensaRepository.findAll();
    }

    public void asignarRecompensa(UUID recompensaId, UUID objetivoId) throws Exception {
        // Implementación de asignar recompensa...
    }

    public UUID crearRecompensa(String nombre, String tipo, String valor) {
        Recompensa recompensa = new Recompensa();
        recompensa.setNombre(nombre);
        recompensa.setTipo(tipo);
        recompensa.setValor(valor);
        recompensa = recompensaRepository.save(recompensa);
        return recompensa.getId();
    }
}
