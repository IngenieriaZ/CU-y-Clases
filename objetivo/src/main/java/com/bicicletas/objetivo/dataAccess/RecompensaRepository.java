package com.bicicletas.objetivo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bicicletas.objetivo.modelo.Recompensa;
import java.util.UUID;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, UUID> {
}
