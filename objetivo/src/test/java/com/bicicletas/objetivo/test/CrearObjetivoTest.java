package com.bicicletas.objetivo.test;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.modelo.Objetivo;

@SpringBootTest
public class CrearObjetivoTest {

    @Autowired
    ObjetivoRepository objetivos;

    // Prueba crear objetivo
    @Test
    public void verificarCreacionObjetivo() {
        try {
            // Creo objeto Objetivo
            Objetivo objetivo = new Objetivo();
            objetivo.setNombre("Perder peso");
            objetivo.setDescripcion("Perder 5 kg en 2 meses");
            objetivo.setVencimiento(60);
            // Lo guardo en la BDD
            objetivo = objetivos.save(objetivo);
            // Lo extraigo de la base de datos
            Optional<Objetivo> o = objetivos.findById(objetivo.getId());
            // Verifico si se guardó
            if (!o.isPresent()) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("La prueba falló");
        }
    }

    // Test que ese Objetivo no esté creado ya
    @Test
    public void verificarObjetivoNoCreadoAun() {
        try {
            // Extraigo todos los objetivos
            List<Objetivo> listaObjetivos = objetivos.findAll();
            // Creo objeto Objetivo
            Objetivo objetivo = new Objetivo();
            objetivo.setNombre("Perder peso");
            objetivo.setDescripcion("Perder 5 kg en 2 meses");
            objetivo.setVencimiento(60);
            // Lo guardo en la BDD y actualizo
            objetivo = objetivos.save(objetivo);
            // Verifico que no esté creado aún
            for (Objetivo o : listaObjetivos) {
                if (objetivo.getId().equals(o.getId())) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            fail("La prueba falló");
        }
    }
}
