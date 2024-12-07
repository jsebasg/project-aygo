package com.co.escuealing.mapsito.model;

import com.co.escuealing.mapsito.model.enums.EstadoPaqueteEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * @author sebastian.garciah
 * @created 26/11/2024
 * @project mapsito
 */

@Entity
@Data
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int peso;
    private String descripcion;
    private boolean fragil;
    private EstadoPaqueteEnum estadoPaqueteEnum;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Long ruta;

}
