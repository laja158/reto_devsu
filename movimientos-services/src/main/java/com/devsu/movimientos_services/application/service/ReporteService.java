package com.devsu.movimientos_services.application.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.movimientos_services.domain.model.Cuenta;
import com.devsu.movimientos_services.domain.model.Movimiento;
import com.devsu.movimientos_services.domain.port.out.CuentaRepositoryPort;
import com.devsu.movimientos_services.domain.port.out.MovimientoRepositoryPort;
import com.devsu.movimientos_services.infrastructure.rest.dto.ReporteResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final CuentaRepositoryPort cuentaRepository;
    private final MovimientoRepositoryPort movimientoRepository;

    public List<ReporteResponse> generarReporte(
                LocalDateTime fechaInicio,
                LocalDateTime fechaFin,
                String clienteId) {

                List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);

                List<ReporteResponse> reporte = new ArrayList<>();

                for (Cuenta cuenta : cuentas) {

                        List<Movimiento> movimientos =
                                movimientoRepository.findByNumeroCuenta(
                                        cuenta.getNumeroCuenta());

                        for (Movimiento movimiento : movimientos) {

                        if (movimiento.getFecha().isBefore(fechaInicio)
                                || movimiento.getFecha().isAfter(fechaFin)) {
                                continue;
                        }

                        ReporteResponse r = new ReporteResponse();

                        r.setFecha(movimiento.getFecha());
                        r.setCliente(clienteId);
                        r.setNumeroCuenta(cuenta.getNumeroCuenta());
                        r.setTipoCuenta(cuenta.getTipoCuenta());
                        r.setSaldoInicial(movimiento.getSaldoInicial());
                        r.setEstado(cuenta.getEstado());
                        r.setMovimiento(movimiento.getValor());
                        r.setSaldoDisponible(movimiento.getSaldo());

                        reporte.add(r);
                        }
                }

                return reporte;
        }
}