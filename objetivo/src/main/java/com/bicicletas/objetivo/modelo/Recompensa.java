package com.bicicletas.objetivo.modelo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Recompensa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    
    String nombre;
    String tipo;
    String valor;

    @OneToOne
    Objetivo objetivo;
}