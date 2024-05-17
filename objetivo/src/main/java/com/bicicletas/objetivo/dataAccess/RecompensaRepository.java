package com.bicicletas.objetivo.dataAccess;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bicicletas.objetivo.modelo.Recompensa;
@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, UUID>{
    
    
}
