package com.devsu.movimientos_services.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.devsu.movimientos_services.domain.model.Cuenta;
import com.devsu.movimientos_services.domain.port.out.CuentaRepositoryPort;
import com.devsu.movimientos_services.infrastructure.mapper.CuentaMapper;
import com.devsu.movimientos_services.infrastructure.persistence.entity.CuentaEntity;
import com.devsu.movimientos_services.infrastructure.persistence.repository.CuentaRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CuentaRepositoryAdapter implements CuentaRepositoryPort {

    private final CuentaRepository repository;
    private final CuentaMapper mapper;

    @Override
    public Cuenta save(Cuenta cuenta) {

        CuentaEntity entity = mapper.toEntity(cuenta);

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Cuenta> findByNumeroCuenta(String numeroCuenta) {

        return repository.findById(numeroCuenta)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cuenta> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Cuenta> findByClienteId(String clienteId) {
        return repository.findByClienteId(clienteId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
