package com.devsu.movimientos_services.infrastructure.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.movimientos_services.application.service.CuentaService;
import com.devsu.movimientos_services.domain.model.Cuenta;
import com.devsu.movimientos_services.infrastructure.mapper.CuentaMapper;
import com.devsu.movimientos_services.infrastructure.rest.dto.CuentaRequest;
import com.devsu.movimientos_services.infrastructure.rest.dto.CuentaResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;
    private final CuentaMapper mapper;

    @PostMapping
    public ResponseEntity<CuentaResponse> crearCuenta(
            @RequestBody CuentaRequest request) {

        Cuenta cuenta = mapper.toDomain(request);

        Cuenta creada = cuentaService.crearCuenta(cuenta);

        return ResponseEntity.ok(mapper.toResponse(creada));
    }

    @GetMapping
    public ResponseEntity<List<CuentaResponse>> listarCuentas() {

        return ResponseEntity.ok(
                cuentaService.listarCuentas()
                        .stream()
                        .map(mapper::toResponse)
                        .toList()
        );
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaResponse> obtenerCuenta(
            @PathVariable String numeroCuenta) {

        return ResponseEntity.ok(
                mapper.toResponse(
                        cuentaService.obtenerCuenta(numeroCuenta)
                )
        );
    }

    @PutMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaResponse> actualizarCuenta(
            @PathVariable String numeroCuenta,
            @RequestBody CuentaRequest request) {

        Cuenta cuenta = mapper.toDomain(request);

        return ResponseEntity.ok(
                mapper.toResponse(
                        cuentaService.actualizarCuenta(numeroCuenta, cuenta)
                )
        );
    }
}
