package com.co.escuealing.mapsito.service;

import com.co.escuealing.mapsito.model.PuntoEntrega;
import com.co.escuealing.mapsito.repository.PuntoEntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sebastian.garciah
 * @created 25/11/2024
 * @project mapsito
 */
@Service
public class PuntoEntregaService {

    private final PuntoEntregaRepository puntoEntregaRepository;

    public PuntoEntregaService(PuntoEntregaRepository puntoEntregaRepository) {
        this.puntoEntregaRepository = puntoEntregaRepository;
    }

    public List<PuntoEntrega> obtenerTodos() {
        return puntoEntregaRepository.findAll();
    }

    public PuntoEntrega guardarPunto(PuntoEntrega punto) {
        return puntoEntregaRepository.save(punto);
    }
}
