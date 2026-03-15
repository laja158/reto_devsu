package com.devsu.movimientos_services.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.movimientos_services.infrastructure.persistence.entity.MovimientoEntity;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

    List<MovimientoEntity> findByNumeroCuenta(String numeroCuenta);

    List<MovimientoEntity> findByNumeroCuentaAndFechaBetween(
        String numeroCuenta,
        LocalDateTime inicio,
        LocalDateTime fin);
}