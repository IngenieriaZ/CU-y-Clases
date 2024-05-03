package com.bicicletas.modelo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Recompensa {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    UUID id;
    String nombre;
    String tipo;
    String valor;
    @OneToOne
    Objetivo objetivo;
}
