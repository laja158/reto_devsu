package com.devsu.movimientos_services.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.devsu.movimientos_services.domain.model.Cuenta;
import com.devsu.movimientos_services.infrastructure.persistence.entity.CuentaEntity;
import com.devsu.movimientos_services.infrastructure.rest.dto.CuentaRequest;
import com.devsu.movimientos_services.infrastructure.rest.dto.CuentaResponse;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    
    Cuenta toDomain(CuentaRequest request);

    CuentaResponse toResponse(Cuenta cuenta);

    CuentaEntity toEntity(Cuenta cuenta);

    Cuenta toDomain(CuentaEntity entity);
}
