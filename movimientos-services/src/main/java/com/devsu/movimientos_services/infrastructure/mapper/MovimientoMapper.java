package com.devsu.movimientos_services.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.devsu.movimientos_services.domain.model.Movimiento;
import com.devsu.movimientos_services.infrastructure.persistence.entity.MovimientoEntity;
import com.devsu.movimientos_services.infrastructure.rest.dto.MovimientoRequest;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    Movimiento toDomain(MovimientoEntity entity);

    MovimientoEntity toEntity(Movimiento movimiento);

    Movimiento toDomain(MovimientoRequest request);
}
