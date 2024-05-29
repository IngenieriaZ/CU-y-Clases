package com.bicicletas.objetivo.logica;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.modelo.Objetivo;

@Service
public class ObjetivoService {

    @Autowired
    ObjetivoRepository objetivoRepository;

    // Crear Objetivo
    public UUID crearObjetivo(String nombre, String descripcion, Integer vencimiento) throws Exception {
        Objetivo objetivo = new Objetivo();
        objetivo.setNombre(nombre);
        objetivo.setDescripcion(descripcion);
        objetivo.setCompletado(false);
        objetivo.setIniciado(false);
        objetivo.setVencimiento(vencimiento);
        objetivo = objetivoRepository.save(objetivo);
        return objetivo.getId();
    }

    // Actualizar Estado del Objetivo
    public Objetivo actualizarEstadoObjetivo(UUID objetivoId, boolean completado, boolean iniciado) throws Exception {
        Optional<Objetivo> optObjetivo = objetivoRepository.findById(objetivoId);
        if (optObjetivo.isEmpty()) {
            throw new Exception("Objetivo no encontrado");
        }
        Objetivo objetivo = optObjetivo.get();
        objetivo.setCompletado(completado);
        objetivo.setIniciado(iniciado);
        return objetivoRepository.save(objetivo);
    }

    // Obtener todos los objetivos
    public List<Objetivo> getAllObjetivos() {
        return objetivoRepository.findAll();
    }

    public UUID establecerObjetivo(String nombre, String descripcion, boolean iniciado, Integer vencimiento) {
        throw new UnsupportedOperationException("Unimplemented method 'establecerObjetivo'");
    }
}
