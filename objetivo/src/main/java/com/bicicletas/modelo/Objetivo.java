package com.bicicletas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Objetivo {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    Integer id;

    String nombre;
    String descripcion;
    boolean completado;
    boolean iniciado;
    Integer vencimiento;
    @OneToOne(mappedBy = "objetivo")
    Recompensa recompensa;
    
    
}
