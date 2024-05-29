package com.bicicletas.objetivo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bicicletas.objetivo.modelo.Objetivo;
import com.bicicletas.objetivo.modelo.Usuario;
import java.util.List;
import java.util.UUID;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, UUID> {
    List<Objetivo> findByUsuarioAndCompletado(Usuario usuario, boolean completado);
}
