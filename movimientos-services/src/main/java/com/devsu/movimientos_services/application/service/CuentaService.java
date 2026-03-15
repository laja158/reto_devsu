package com.devsu.movimientos_services.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.movimientos_services.application.exception.ClienteNoExisteException;
import com.devsu.movimientos_services.domain.model.Cuenta;
import com.devsu.movimientos_services.domain.port.out.ClienteClientPort;
import com.devsu.movimientos_services.domain.port.out.CuentaRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {

    private final CuentaRepositoryPort repository;
    private final ClienteClientPort clienteClient;

    public Cuenta crearCuenta(Cuenta cuenta) {

        boolean existeCliente = clienteClient.existeCliente(cuenta.getClienteId());
        if (!existeCliente) {
            throw new ClienteNoExisteException("Cliente no existe");
        }
        return repository.save(cuenta);
    }

    public List<Cuenta> listarCuentas() {

        return repository.findAll();
    }

    public Cuenta obtenerCuenta(String numeroCuenta) {

        return repository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    public Cuenta actualizarCuenta(String numeroCuenta, Cuenta cuenta) {

        cuenta.setNumeroCuenta(numeroCuenta);

        return repository.save(cuenta);
    }
}
