package com.bicicletas.objetivo.test;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bicicletas.objetivo.dataAccess.RecompensaRepository;
import com.bicicletas.objetivo.modelo.Recompensa;

@SpringBootTest
public class CrearRecompensaTest {

    @Autowired
    RecompensaRepository recompensas;

    // Prueba crear recompensa
    @Test
    public void verificarCreacionRecompensa() {
        try {
            // Creo objeto Recompensa
            Recompensa recompensa = new Recompensa();
            recompensa.setNombre("Descuento en tienda");
            recompensa.setTipo("Descuento");
            recompensa.setValor("10%");
            // Lo guardo en la BDD
            recompensa = recompensas.save(recompensa);
            // Lo extraigo de la base de datos
            Optional<Recompensa> r = recompensas.findById(recompensa.getId());
            // Verifico si se guardó
            if (!r.isPresent()) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("La prueba falló");
        }
    }

    // Test que esa Recompensa no esté creada ya
    @Test
    public void verificarRecompensaNoCreadaAun() {
        try {
            // Extraigo todas las recompensas
            List<Recompensa> listaRecompensas = recompensas.findAll();
            // Creo objeto Recompensa
            Recompensa recompensa = new Recompensa();
            recompensa.setNombre("Descuento en tienda");
            recompensa.setTipo("Descuento");
            recompensa.setValor("10%");
            // Lo guardo en la BDD y actualizo
            recompensa = recompensas.save(recompensa);
            // Verifico que no esté creada aún
            for (Recompensa r : listaRecompensas) {
                if (recompensa.getId().equals(r.getId())) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            fail("La prueba falló");
        }
    }
}
