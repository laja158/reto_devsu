package com.devsu.personas.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.devsu.persons.domain.models.Cliente;
import com.devsu.persons.domain.ports.outs.ClienteRepositoryPort;
import com.devsu.persons.application.services.ClienteService;
import com.devsu.persons.infrastructure.messaging.RabbitProducer;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepositoryPort repository;

    @Mock
    private RabbitProducer rabbitProducer;

    @Mock
    private PasswordEncoder passwordEncoder; 

    @InjectMocks
    private ClienteService service;

    @Test
    void shouldCreateCliente() {

        Cliente cliente = new Cliente();
        cliente.setClienteId("1");
        cliente.setNombre("Jose Lema");

        when(repository.save(any())).thenReturn(cliente);

        Cliente result = service.crearCliente(cliente);

        assertNotNull(result);
        assertEquals("1", result.getClienteId());
        assertEquals("Jose Lema", result.getNombre());

        verify(repository, times(1)).save(cliente);
    }
}