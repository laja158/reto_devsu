package com.devsu.movimientos_services.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MovimientoRequest {

    private String numeroCuenta;

    private BigDecimal valor;

}
