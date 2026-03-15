package com.devsu.movimientos_services.integration;

import com.devsu.movimientos_services.application.service.MovimientoService;
import com.devsu.movimientos_services.domain.model.Movimiento;
import com.devsu.movimientos_services.infrastructure.persistence.entity.CuentaEntity;
import com.devsu.movimientos_services.infrastructure.persistence.repository.CuentaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovimientoServiceIntegrationTest {

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Test
    void shouldRegisterMovimiento() {

        CuentaEntity cuenta = new CuentaEntity();
        cuenta.setNumeroCuenta("999999");
        cuenta.setSaldoInicial(new BigDecimal("1000"));
        cuenta.setEstado(true);

        cuentaRepository.save(cuenta);

        Movimiento movimiento = new Movimiento();
        movimiento.setNumeroCuenta("999999");
        movimiento.setValor(new BigDecimal("-100"));

        Movimiento result = movimientoService.registrarMovimiento(movimiento);

        assertNotNull(result);
        assertEquals(0, new BigDecimal("900").compareTo(result.getSaldo()));
    }
}