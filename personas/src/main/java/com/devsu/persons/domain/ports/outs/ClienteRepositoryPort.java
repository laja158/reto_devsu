package com.devsu.persons.domain.ports.outs;

import java.util.List;
import java.util.Optional;

import com.devsu.persons.domain.models.Cliente;

public interface ClienteRepositoryPort {

    Cliente save(Cliente cliente);

    Optional<Cliente> findById(String clienteId);

    List<Cliente> findAll();

    void deleteById(String clienteId);

    boolean existsByIdentificacion(String identificacion);

}
