package com.co.escuealing.mapsito.repository;

import com.co.escuealing.mapsito.model.PuntoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sebastian.garciah
 * @created 25/11/2024
 * @project mapsito
 */

@Repository
public interface PuntoEntregaRepository extends JpaRepository<PuntoEntrega, Long> {
}