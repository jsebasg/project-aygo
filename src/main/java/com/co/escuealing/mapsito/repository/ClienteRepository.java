package com.co.escuealing.mapsito.repository;

import com.co.escuealing.mapsito.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sebastian.garciah
 * @created 06/12/2024
 * @project mapsito
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
