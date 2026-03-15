package com.devsu.movimientos_services.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.devsu.movimientos_services.domain.model.Cuenta;

public interface CuentaRepositoryPort {

    Cuenta save(Cuenta cuenta);

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    List<Cuenta> findAll();

    List<Cuenta> findByClienteId(String clienteId);

}