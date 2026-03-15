package com.devsu.movimientos_services.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    private String tipoMovimiento;

    private BigDecimal valor;

    private BigDecimal saldo;

    private BigDecimal saldoInicial;

    private String numeroCuenta;
}
