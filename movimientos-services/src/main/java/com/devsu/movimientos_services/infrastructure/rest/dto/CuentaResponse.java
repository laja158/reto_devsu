package com.devsu.movimientos_services.infrastructure.rest.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CuentaResponse {

    private String numeroCuenta;

    private String tipoCuenta;

    private BigDecimal saldoInicial;

    private Boolean estado;

    private String clienteId;
}