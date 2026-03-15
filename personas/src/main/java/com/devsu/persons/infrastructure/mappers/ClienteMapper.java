package com.devsu.persons.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.devsu.persons.domain.models.Cliente;
import com.devsu.persons.infrastructure.persistence.entity.ClienteEntity;
import com.devsu.persons.infrastructure.rest.dtos.ClienteRequest;
import com.devsu.persons.infrastructure.rest.dtos.ClienteResponse;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "clienteId", ignore = true)
    Cliente toDomain(ClienteRequest request);

    ClienteResponse toResponse(Cliente cliente);

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "edad", target = "edad")
    @Mapping(source = "identificacion", target = "identificacion")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "telefono", target = "telefono")
    ClienteEntity toEntity(Cliente cliente);

    Cliente toDomain(ClienteEntity entity);

}
