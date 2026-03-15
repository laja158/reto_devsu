package com.devsu.movimientos_services.application.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.movimientos_services.application.exception.SaldoNoDisponibleException;
import com.devsu.movimientos_services.domain.model.Cuenta;
import com.devsu.movimientos_services.domain.model.Movimiento;
import com.devsu.movimientos_services.domain.port.out.CuentaRepositoryPort;
import com.devsu.movimientos_services.domain.port.out.MovimientoRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final CuentaRepositoryPort cuentaRepository;
    private final MovimientoRepositoryPort movimientoRepository;

    public Movimiento registrarMovimiento(Movimiento movimiento) {

        Cuenta cuenta = cuentaRepository
                .findByNumeroCuenta(movimiento.getNumeroCuenta())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if(!cuenta.getEstado()) {
            throw new RuntimeException("Cuenta no disponible");
        }
        BigDecimal saldoActual = cuenta.getSaldoInicial();
        movimiento.setSaldoInicial(cuenta.getSaldoInicial());
        BigDecimal nuevoSaldo = saldoActual.add(movimiento.getValor());

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoNoDisponibleException("Saldo no disponible");
        }

        movimiento.setFecha(LocalDateTime.now());
        movimiento.setSaldo(nuevoSaldo);

        if (movimiento.getValor().compareTo(BigDecimal.ZERO) > 0) {
            movimiento.setTipoMovimiento("DEPOSITO");
        } else {
            movimiento.setTipoMovimiento("RETIRO");
        }

        Movimiento guardado = movimientoRepository.save(movimiento);

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        return guardado;
    }

    public List<Movimiento> listarMovimientos() {
        return movimientoRepository.findAll();
    }
}