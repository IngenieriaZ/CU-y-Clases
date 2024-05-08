package com.bicicletas.objetivo.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bicicletas.objetivo.dataAccess.RecompensaRepository;

@DataJpaTest
public class RecompensaRepositoryTest {

    @Autowired
    private RecompensaRepository recompensaRepository;

    @Test
    void testGuardarYBuscarRecompensa() {
        // Crear una nueva recompensa
        Recompensa nuevaRecompensa = new Recompensa();
        nuevaRecompensa.setNombre("Vale de Descuento");
        nuevaRecompensa.setTipo("Cupón");
        nuevaRecompensa.setValor("15%");

        // Guardar la recompensa
        Recompensa guardada = recompensaRepository.save(nuevaRecompensa);

        // Verificar que la recompensa se guardó correctamente
        assertNotNull(guardada.getId(), "La recompensa debe tener un ID asignado");

        // Buscar la recompensa por el ID
        Optional<Recompensa> encontrada = recompensaRepository.findById(guardada.getId());
        assertTrue(encontrada.isPresent(), "La recompensa debe ser encontrada");
        assertEquals("Vale de Descuento", encontrada.get().getNombre(), "El nombre de la recompensa debe coincidir");
        assertEquals("Cupón", encontrada.get().getTipo(), "El tipo de la recompensa debe coincidir");
        assertEquals("15%", encontrada.get().getValor(), "El valor de la recompensa debe coincidir");
    }
}
