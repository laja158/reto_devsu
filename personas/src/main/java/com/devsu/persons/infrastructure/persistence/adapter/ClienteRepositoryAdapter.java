package com.devsu.persons.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.devsu.persons.domain.models.Cliente;
import com.devsu.persons.domain.ports.outs.ClienteRepositoryPort;
import com.devsu.persons.infrastructure.mappers.ClienteMapper;
import com.devsu.persons.infrastructure.persistence.entity.ClienteEntity;
import com.devsu.persons.infrastructure.persistence.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    @Override
    public Cliente save(Cliente cliente) {

        ClienteEntity entity = mapper.toEntity(cliente);

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Cliente> findById(String clienteId) {

        return repository
                .findById(clienteId)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {

        return repository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(String clienteId) {

        repository.deleteById(clienteId);
    }

    @Override
    public boolean existsByIdentificacion(String identificacion) {
        return repository.existsByIdentificacion(identificacion);
    }

}