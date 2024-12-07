package com.co.escuealing.mapsito.controller;

import com.co.escuealing.mapsito.model.Paquete;
import com.co.escuealing.mapsito.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sebastian.garciah
 * @created 06/12/2024
 * @project mapsito
 */
@RestController
@RequestMapping("/api/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;

    @GetMapping
    public List<Paquete> getAllPaquetes() {
        return paqueteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paquete> getPaqueteById(@PathVariable Long id) {
        return paqueteService.findById(id)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paquete createPaquete(@RequestBody Paquete paquete) {
        return paqueteService.save(paquete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paquete> updatePaquete(@PathVariable Long id, @RequestBody Paquete paqueteDetails) {
        return paqueteService.findById(id).map(paquete -> {
            paquete.setPeso(paqueteDetails.getPeso());
            paquete.setDescripcion(paqueteDetails.getDescripcion());
            paquete.setFragil(paqueteDetails.isFragil());
            return ResponseEntity.ok(paqueteService.save(paquete));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaquete(@PathVariable Long id) {
        if (paqueteService.findById(id).isPresent()) {
            paqueteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/cambiar-estado")
    public ResponseEntity<String> changeState(@PathVariable Long id) {
        try {
            Paquete paquete = paqueteService.changeState(id);
            return ResponseEntity.ok("El estado del paquete con ID " + id + " fue actualizado correctamente. Nuevo estado :" + paquete.getEstadoPaqueteEnum());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                 .body("Error actualizando el estado del paquete: " + e.getMessage());
        }
    }
}