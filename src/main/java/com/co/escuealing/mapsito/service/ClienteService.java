package com.co.escuealing.mapsito.service;

import com.co.escuealing.mapsito.model.Cliente;
import com.co.escuealing.mapsito.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author sebastian.garciah
 * @created 06/12/2024
 * @project mapsito
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SnsClient snsClient;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    // Método para suscribir un correo electrónico a un Topic SNS

}