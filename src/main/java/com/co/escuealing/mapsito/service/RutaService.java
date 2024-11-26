package com.co.escuealing.mapsito.service;

import com.co.escuealing.mapsito.model.Ruta;
import com.co.escuealing.mapsito.repository.RutaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sebastian.garciah
 * @created 25/11/2024
 * @project mapsito
 */
@Service
public class RutaService {

    private final RutaRepository rutaRepository;

    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    public List<Ruta> obtenerTodas() {
        return rutaRepository.findAll();
    }

    public Ruta guardarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public Ruta obtenerPorId(Long id) {
        return rutaRepository.findById(id).orElse(null);
    }
}
