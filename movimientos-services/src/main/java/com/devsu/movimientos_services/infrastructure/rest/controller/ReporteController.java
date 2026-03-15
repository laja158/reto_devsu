package com.devsu.movimientos_services.infrastructure.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.devsu.movimientos_services.application.service.ReporteService;
import com.devsu.movimientos_services.infrastructure.rest.dto.ReporteResponse;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping()
    public List<ReporteResponse> generarReporte(
            @RequestParam String cliente,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        return reporteService.generarReporte(
                fechaInicio.atStartOfDay(),
                fechaFin.atTime(23, 59, 59),
                cliente
        );
    }
}