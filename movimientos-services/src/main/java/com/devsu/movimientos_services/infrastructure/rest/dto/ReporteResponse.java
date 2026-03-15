package com.devsu.movimientos_services.infrastructure.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReporteResponse {

    private LocalDateTime fecha;

    private String cliente;

    private String numeroCuenta;

    private String tipoCuenta;

    private BigDecimal saldoInicial;

    private Boolean estado;

    private BigDecimal movimiento;

    private BigDecimal saldoDisponible;
}
