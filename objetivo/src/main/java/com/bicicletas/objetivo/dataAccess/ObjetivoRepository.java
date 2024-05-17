package com.bicicletas.objetivo.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bicicletas.objetivo.modelo.Objetivo;

@Repository
public interface ObjetivoRepository
    extends JpaRepository<Objetivo, UUID>
{
// obtiene el objetivo con "enProceso == true"")
/*
// obtiene los trayectos entre fecha inico y fecha fin
@Modifying
@Query("select t from Objetivos t where t.horaFin > :horaInicio and t.horaInicio < :horaFin")
List<Trayecto> findEnRangoFechas(Date horaInicio, Date horaFin);
*/
}
