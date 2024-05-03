package com.bicicletas.modelo;
import org.hibernate.annotations.OnDelete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Recompensa {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    Integer id;
    String nombre;
    String tipo;
    String valor;
    @OneToOne
    Objetivo objetivo;
}
