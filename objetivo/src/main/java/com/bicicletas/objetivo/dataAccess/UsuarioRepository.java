package com.bicicletas.objetivo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bicicletas.objetivo.modelo.Usuario;
import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByUsuarioAndCompletado(Usuario usuario, boolean completado);
}
