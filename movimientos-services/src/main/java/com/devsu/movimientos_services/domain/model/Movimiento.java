package com.devsu.movimientos_services.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movimiento {

    private Long id;

    private LocalDateTime fecha;

    private String tipoMovimiento;

    private BigDecimal valor;

    private BigDecimal saldo;

    private BigDecimal saldoInicial;

    private String numeroCuenta;

}
