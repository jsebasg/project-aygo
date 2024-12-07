package com.co.escuealing.mapsito.repository;

import com.co.escuealing.mapsito.model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sebastian.garciah
 * @created 06/12/2024
 * @project mapsito
 */
@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    List<Paquete> findByRuta(Long ruta);

}
