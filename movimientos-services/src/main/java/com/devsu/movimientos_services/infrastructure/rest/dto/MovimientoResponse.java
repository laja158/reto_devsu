package com.devsu.movimientos_services.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class MovimientoResponse {

    private LocalDateTime fecha;

    private String tipoMovimiento;

    private BigDecimal valor;

    private BigDecimal saldo;

    private String numeroCuenta;
}
