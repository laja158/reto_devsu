package com.devsu.movimientos_services.infrastructure.persistence.adapter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsu.movimientos_services.domain.model.Movimiento;
import com.devsu.movimientos_services.domain.port.out.MovimientoRepositoryPort;
import com.devsu.movimientos_services.infrastructure.mapper.MovimientoMapper;
import com.devsu.movimientos_services.infrastructure.persistence.entity.MovimientoEntity;
import com.devsu.movimientos_services.infrastructure.persistence.repository.MovimientoRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MovimientoRepositoryAdapter implements MovimientoRepositoryPort {

    private final MovimientoRepository repository;
    private final MovimientoMapper mapper;

    @Override
    public Movimiento save(Movimiento movimiento) {

        MovimientoEntity entity = mapper.toEntity(movimiento);

        MovimientoEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
    }

    @Override
    public List<Movimiento> findByNumeroCuenta(String numeroCuenta) {

        return repository.findByNumeroCuenta(numeroCuenta)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Movimiento> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Movimiento> findByNumeroCuentaAndFechaBetween(
            String numeroCuenta,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {

        return repository
                .findByNumeroCuentaAndFechaBetween(numeroCuenta, fechaInicio, fechaFin)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
