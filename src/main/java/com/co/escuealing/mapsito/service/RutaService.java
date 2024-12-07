package com.co.escuealing.mapsito.service;

import com.co.escuealing.mapsito.model.Paquete;
import com.co.escuealing.mapsito.model.Ruta;
import com.co.escuealing.mapsito.repository.PaqueteRepository;
import com.co.escuealing.mapsito.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author sebastian.garciah
 * @created 25/11/2024
 * @project mapsito
 */
@Service
public class RutaService {
    @Autowired
    private AwsSnsConfig awsSnsConfig;
    @Autowired
    private SnsClient snsClient;
    private String topicArn;

    @Autowired
    private RutaRepository rutaRepository;
    @Autowired
    private PaqueteRepository paqueteRepository;


    public List<Ruta> obtenerTodas() {
        return rutaRepository.findAll();
    }

    public Ruta guardarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public Ruta obtenerPorId(Long id) {
        return rutaRepository.findById(id).orElse(null);
    }

    public void subscribeEmailToTopic(String emailAddress) {
        try {
            SubscribeRequest subscribeRequest = SubscribeRequest.builder()
                 .protocol("email") // Protocolo: "email"
                 .endpoint(emailAddress) // Dirección de correo electrónico a suscribir
                 .topicArn(topicArn) // ARN del topic SNS
                 .build();
            snsClient.subscribe(subscribeRequest);
            System.out.println("Correo electrónico suscrito exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al suscribir el correo: " + e.getMessage());
        }
    }

    public Ruta agregarNuevoPaquete(Long idRuta, Long idPaquete) {
        Optional<Ruta> ruta = rutaRepository.findById(idRuta);
        if (ruta.isPresent()) {
            List<Paquete> paquetes = paqueteRepository.findByRuta(idPaquete);

        }
        return null;
    }
}
