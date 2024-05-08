package com.bicicletas.objetivo.logica;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bicicletas.objetivo.modelo.Objetivo;
import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;

@Service
public class ObjetivosService {
    @Autowired
    private ObjetivoRepository objetivoRepository;
    /*CU001 :Establecer objetivos personales

    |Usuario|Sistema|
    |-------|-------|
    |1. solicitar establecer objetivo||
    ||2. Pedir datos del objetivo|
    |3. Ingresar datos del objetivos||
    ||4. Crear objetivos|
    */
    public UUID establecerObjetivo(String nombre, String descripcion, boolean iniciado, Integer vencimiento) throws Exception {
        Objetivo nuevoObjetivo = new Objetivo();
        nuevoObjetivo.setNombre(nombre);
        nuevoObjetivo.setDescripcion(descripcion);
        nuevoObjetivo.setCompletado(false);  // Un nuevo objetivo, por defecto, no está completado
        nuevoObjetivo.setIniciado(iniciado);
        nuevoObjetivo.setVencimiento(vencimiento);

        // Guardar el objetivo en la base de datos
        objetivoRepository.save(nuevoObjetivo);
        return nuevoObjetivo.getId();
    }
}
