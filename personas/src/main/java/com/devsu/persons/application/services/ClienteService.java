package com.devsu.persons.application.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsu.persons.domain.models.Cliente;
import com.devsu.persons.domain.ports.in.ClienteUseCase;
import com.devsu.persons.domain.ports.outs.ClienteRepositoryPort;
import com.devsu.persons.infrastructure.messaging.RabbitProducer;
import com.devsu.persons.infrastructure.messaging.event.ClienteCreatedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteUseCase {

    private final PasswordEncoder passwordEncoder;

    private final ClienteRepositoryPort repository;

    private final RabbitProducer rabbitProducer;

    @Override
    public Cliente crearCliente(Cliente cliente) {

        if(repository.existsByIdentificacion(cliente.getIdentificacion())) throw new RuntimeException("Ya existe un cliente con esta identificación");
        
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        
        Cliente clienteGuardado = repository.save(cliente);

        rabbitProducer.enviarClienteCreado(
                new ClienteCreatedEvent(
                        clienteGuardado.getClienteId(),
                        clienteGuardado.getNombre()
                )
        );

        return clienteGuardado;
    }

    @Override
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente obtenerCliente(String clienteId) {
        return repository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Cliente actualizarCliente(String clienteId, Cliente cliente) {

        cliente.setClienteId(clienteId);

        return repository.save(cliente);
    }

    @Override
    public void eliminarCliente(String clienteId) {
        repository.deleteById(clienteId);
    }
}
