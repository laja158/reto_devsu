package com.devsu.movimientos_services.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.movimientos_services.application.service.MovimientoService;
import com.devsu.movimientos_services.domain.model.Movimiento;
import com.devsu.movimientos_services.infrastructure.mapper.MovimientoMapper;
import com.devsu.movimientos_services.infrastructure.rest.dto.MovimientoRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;
    private final MovimientoMapper mapper;

    @PostMapping
    public ResponseEntity<?> registrarMovimiento(@RequestBody MovimientoRequest request) {

        Movimiento movimiento = mapper.toDomain(request);
        return ResponseEntity.ok(
                movimientoService.registrarMovimiento(movimiento)
        );
    }

    @GetMapping
    public ResponseEntity<?> listarMovimientos() {

        return ResponseEntity.ok(
                movimientoService.listarMovimientos()
        );
    }

}
