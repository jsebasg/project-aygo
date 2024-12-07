package com.co.escuealing.mapsito.service;

import com.co.escuealing.mapsito.model.Paquete;
import com.co.escuealing.mapsito.model.enums.EstadoPaqueteEnum;
import com.co.escuealing.mapsito.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author sebastian.garciah
 * @created 06/12/2024
 * @project mapsito
 */
@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;
    @Autowired
    private SnsService snsService;

    public List<Paquete> findAll() {
        return paqueteRepository.findAll();
    }

    public Optional<Paquete> findById(Long id) {
        return paqueteRepository.findById(id);
    }

    public Paquete save(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    public void deleteById(Long id) {
        paqueteRepository.deleteById(id);
    }
    public Paquete changeState(Long id) throws Exception {
        Paquete paquete = paqueteRepository.findById(id).orElseThrow(() -> new Exception("Paquete no encontrado"));
        try {
            EstadoPaqueteEnum result = paquete.getEstadoPaqueteEnum().next();
            String correoAEnviar = paquete.getCliente().getCorreo();
            String mensaje = "El estado de su paquete ha cambiado a: " + result.name();

            // Enviar correo usando AWS SNS
            snsService.sendEmail(correoAEnviar, "Cambio de Estado de Paquete", mensaje);

            paquete.setEstadoPaqueteEnum(result); // Actualizar estado
        } catch (Exception e) {
            throw new Exception("Ocurrió un error actualizando el estado del pedido: " + e.getMessage());
        }
        return paqueteRepository.save(paquete);
    }
}