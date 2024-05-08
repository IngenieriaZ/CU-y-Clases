package com.bicicletas.objetivo.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.modelo.Objetivo;
import com.bicicletas.objetivo.logica.ObjetivosService;

@SpringBootTest
/*
public class ObjetivoTest {

    @Autowired
    ObjetivoRepository objetivos;

    @Test
    public void buscarObjetivoQueNoExiste() {

        try {

            UUID id = UUID.randomUUID();
            Optional<Objetivo> o = objetivos.findById(id);
            
            assertFalse(o.isPresent(), "No debería encontrar ningun objeto");

        } catch (Exception e) { 
            fail("genero exepcion y no debería");
        }

    }

    @Test
    public void grabarObjetivo() {

        try {

            Objetivo o = new Objetivo();
            o.setCompletado(false);
            o.setDescripcion("Ejemplo");

            o = objetivos.save(o);

            Optional<Objetivo> otro = objetivos.findById(o.getId());

            if(otro.isPresent()) {
                Objetivo otroObjetivo = otro.get();

                assertEquals(o.getDescripcion(), otroObjetivo.getDescripcion(), "No son iguales");

            }

        } catch (Exception e) {
            fail("genero exepcion y no debería");
        }
        

    }



}
*/


class ObjetivosServiceTests {

    @Autowired
    ObjetivosService objetivosService;

    @Autowired
    ObjetivoRepository objetivoRepository;

    @Test
    @Transactional
    void testEstablecerObjetivo() {
        try {
            // Datos de entrada
            String nombre = "Lograr 10,000 pasos diarios";
            String descripcion = "Caminar 10,000 pasos todos los días durante un mes.";
            boolean iniciado = true;
            Integer vencimiento = 30; // días hasta el vencimiento

            // Ejecuta el caso de uso
            UUID id = objetivosService.establecerObjetivo(nombre, descripcion, iniciado, vencimiento);

            // Revisa si se almacenó el objetivo
            Optional<Objetivo> resultado = objetivoRepository.findById(id);
            assertFalse(resultado.isEmpty(), "No se grabó el objetivo");

            Objetivo objetivo = resultado.get();
            assertEquals(nombre, objetivo.getNombre());
            assertEquals(descripcion, objetivo.getDescripcion());
            assertEquals(false, objetivo.isCompletado());
            assertEquals(iniciado, objetivo.isIniciado());
            assertEquals(vencimiento, objetivo.getVencimiento());

        } catch (Exception e) {
            fail("Generó excepción y no debería: " + e.getMessage());
        }
    }
}
