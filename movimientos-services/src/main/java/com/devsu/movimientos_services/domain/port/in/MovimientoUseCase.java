package com.devsu.movimientos_services.domain.port.in;

import java.util.List;

import com.devsu.movimientos_services.domain.model.Movimiento;

public interface MovimientoUseCase {

    Movimiento registrarMovimiento(Movimiento movimiento);

    List<Movimiento> listarMovimientos(String numeroCuenta);

}