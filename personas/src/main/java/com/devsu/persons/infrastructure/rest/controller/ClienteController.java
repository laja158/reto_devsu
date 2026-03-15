package com.devsu.persons.infrastructure.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.persons.domain.models.Cliente;
import com.devsu.persons.domain.ports.in.ClienteUseCase;
import com.devsu.persons.infrastructure.mappers.ClienteMapper;
import com.devsu.persons.infrastructure.rest.dtos.ClienteRequest;
import com.devsu.persons.infrastructure.rest.dtos.ClienteResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteUseCase clienteUseCase;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(
            @RequestBody @Valid ClienteRequest request) {

        Cliente cliente = mapper.toDomain(request);

        Cliente creado = clienteUseCase.crearCliente(cliente);

        return ResponseEntity.ok(mapper.toResponse(creado));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarClientes() {

        List<ClienteResponse> response = clienteUseCase
                .listarClientes()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerCliente(
            @PathVariable String id) {

        Cliente cliente = clienteUseCase.obtenerCliente(id);

        return ResponseEntity.ok(mapper.toResponse(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarCliente(
            @PathVariable String id,
            @RequestBody ClienteRequest request) {

        Cliente cliente = mapper.toDomain(request);

        Cliente actualizado = clienteUseCase.actualizarCliente(id, cliente);

        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable String id) {

        clienteUseCase.eliminarCliente(id);

        return ResponseEntity.noContent().build();
    }
}
