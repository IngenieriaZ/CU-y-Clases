package com.bicicletas.objetivo.test;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bicicletas.objetivo.dataAccess.ObjetivoRepository;
import com.bicicletas.objetivo.dataAccess.RecompensaRepository;
import com.bicicletas.objetivo.modelo.Objetivo;
import com.bicicletas.objetivo.modelo.Recompensa;

@SpringBootTest
public class AsignarRecompensaTest {

    @Autowired
    ObjetivoRepository objetivos;

    @Autowired
    RecompensaRepository recompensas;

    // Prueba asignar recompensa a objetivo
    @Test
    public void asignarRecompensaAObjetivo() {
        try {
            // Creo objeto Objetivo
            Objetivo objetivo = new Objetivo();
            objetivo.setNombre("Perder peso");
            objetivo.setDescripcion("Perder 5 kg en 2 meses");
            objetivo.setVencimiento(60);
            objetivo = objetivos.save(objetivo);

            // Creo objeto Recompensa
            Recompensa recompensa = new Recompensa();
            recompensa.setNombre("Descuento en tienda");
            recompensa.setTipo("Descuento");
            recompensa.setValor("10%");
            recompensa.setObjetivo(objetivo);
            recompensa = recompensas.save(recompensa);

            // Verifico si se asignó correctamente
            Optional<Recompensa> r = recompensas.findById(recompensa.getId());
            if (r.isEmpty() || !r.get().getObjetivo().getId().equals(objetivo.getId())) {
                throw new Exception("La recompensa no fue asignada correctamente al objetivo");
            }
        } catch (Exception e) {
            fail("La prueba falló");
        }
    }
}
