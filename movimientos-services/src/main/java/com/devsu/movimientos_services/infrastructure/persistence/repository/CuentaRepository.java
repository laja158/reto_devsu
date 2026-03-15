package com.devsu.movimientos_services.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.movimientos_services.infrastructure.persistence.entity.CuentaEntity;

public interface CuentaRepository extends JpaRepository<CuentaEntity, String> {

    List<CuentaEntity> findByClienteId(String clienteId);
    
}