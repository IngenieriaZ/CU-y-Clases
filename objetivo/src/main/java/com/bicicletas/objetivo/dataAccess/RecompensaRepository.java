package com.bicicletas.objetivo.dataAccess;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bicicletas.objetivo.modelo.Recompensa;
@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, UUID>{
    private final RecompensaRepository recompensaRepository;

    public RecompensaRepository(RecompensaRepository repository) {
        this.recompensaRepository = repository;
    }

    public List<Recompensa> listarRecompensas() {
        return recompensaRepository.findAll();
    }
}
