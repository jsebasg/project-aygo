package com.co.escuealing.mapsito.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
