package com.co.escuealing.mapsito.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author sebastian.garciah
 * @created 25/11/2024
 * @project mapsito
 */


@Entity
@Data
public class PuntoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    private String direccion;

    private double latitud;

    private double longitud;
}
