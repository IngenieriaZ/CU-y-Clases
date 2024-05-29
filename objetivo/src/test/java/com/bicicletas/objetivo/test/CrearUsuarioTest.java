package com.bicicletas.objetivo.test;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bicicletas.objetivo.dataAccess.UsuarioRepository;
import com.bicicletas.objetivo.modelo.Usuario;

@SpringBootTest
public class CrearUsuarioTest {

    @Autowired
    UsuarioRepository usuarios;

    // Prueba crear usuario
    @Test
    public void verificarCreacionUsuario() {
        try {
            // Creo objeto Usuario
            Usuario usuario = new Usuario();
            usuario.setNombre("Tatis");
            usuario.setEmail("tatis@example.com");
            usuario.setContrasena("secret");
            // Lo guardo en la BDD
            usuario = usuarios.save(usuario);
            // Lo extraigo de la base de datos
            Optional<Usuario> u = usuarios.findById(usuario.getId());
            // Verifico si se guardó
            if (!u.isPresent()) {
                throw new Exception();
            }
        } catch (Exception e) {
            fail("La prueba falló");
        }
    }

    // Test que ese Usuario no esté creado ya
    @Test
    public void verificarUsuarioNoCreadoAun() {
        try {
            // Extraigo todos los usuarios
            List<Usuario> listaUsuarios = usuarios.findAll();
            // Creo objeto Usuario
            Usuario usuario = new Usuario();
            usuario.setNombre("Tatis");
            usuario.setEmail("Tatis@example.com");
            usuario.setContrasena("password");
            // Lo guardo en la BDD y actualizo
            usuario = usuarios.save(usuario);
            // Verifico que no esté creado aún
            for (Usuario u : listaUsuarios) {
                if (usuario.getId().equals(u.getId())) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            fail("La prueba falló");
        }
    }
}
