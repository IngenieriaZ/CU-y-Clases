package com.bicicletas.objetivo.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;

@SpringBootTest
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
