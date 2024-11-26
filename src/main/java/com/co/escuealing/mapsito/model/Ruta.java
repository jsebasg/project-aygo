package com.co.escuealing.mapsito.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author sebastian.garciah
 * @created 25/11/2024
 * @project mapsito
 */
@Entity
@Data
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<PuntoEntrega> puntosEntrega;
    private double distanciaTotal;
    private double tiempoEstimado;

}
