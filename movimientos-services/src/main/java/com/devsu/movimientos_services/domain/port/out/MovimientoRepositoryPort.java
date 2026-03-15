package com.devsu.movimientos_services.domain.port.out;

import java.time.LocalDateTime;
import java.util.List;

import com.devsu.movimientos_services.domain.model.Movimiento;

public interface MovimientoRepositoryPort {

    Movimiento save(Movimiento movimiento);

    List<Movimiento> findByNumeroCuenta(String numeroCuenta);

    List<Movimiento> findAll();

    public List<Movimiento> findByNumeroCuentaAndFechaBetween(
        String numeroCuenta,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin);

}
