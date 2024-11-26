package com.co.escuealing.mapsito.controller;

import com.co.escuealing.mapsito.model.Ruta;
import com.co.escuealing.mapsito.service.RutaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sebastian.garciah
 * @created 25/11/2024
 * @project mapsito
 */
@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping
    public List<Ruta> obtenerRutas() {
        return rutaService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<Ruta> guardarRuta(@RequestBody Ruta ruta) {
        return ResponseEntity.ok(rutaService.guardarRuta(ruta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruta> obtenerPorId(@PathVariable Long id) {
        Ruta ruta = rutaService.obtenerPorId(id);
        if (ruta != null) {
            return ResponseEntity.ok(ruta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
