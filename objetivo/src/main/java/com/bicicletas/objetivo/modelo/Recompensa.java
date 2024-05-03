package com.bicicletas.objetivo.modelo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
