package com.bicicletas.objetivo.modelo;

import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Objetivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private UUID id;

    private String nombre;
    private String descripcion;
    private boolean completado;
    private boolean iniciado;
    private Integer vencimiento;

    @OneToOne(mappedBy = "objetivo")
    private Recompensa recompensa;

    @ManyToOne
    private Usuario usuario;

}
