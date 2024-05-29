package com.bicicletas.objetivo.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bicicletas.objetivo.logica.RecompensaService;
import com.bicicletas.objetivo.modelo.Recompensa;

@SpringBootTest
public class MostrarRecompensasTest {

    @Autowired
    RecompensaService recompensaService;

    // Prueba mostrar todas las recompensas
    @Test
    public void mostrarTodasLasRecompensas() {
        try {
            // Obtengo todas las recompensas
            List<Recompensa> recompensas = recompensaService.obtenerTodasLasRecompensas();
            // Verifico que la lista no esté vacía
            assertFalse(recompensas.isEmpty(), "La lista de recompensas está vacía");
        } catch (Exception e) {
            fail("La prueba falló: " + e.getMessage());
        }
    }
}
