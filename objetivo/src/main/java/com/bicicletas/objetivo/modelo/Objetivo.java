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
@NoArgsConstructor
@AllArgsConstructor
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

    public void setUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUsuario'");
    }
}
