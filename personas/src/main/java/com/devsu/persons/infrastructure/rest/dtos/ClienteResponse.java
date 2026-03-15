package com.devsu.persons.infrastructure.rest.dtos;

import lombok.Data;

@Data
public class ClienteResponse {

    private String clienteId;

    private String nombre;

    private String genero;

    private Integer edad;

    private String identificacion;

    private String direccion;

    private String telefono;

    private Boolean estado;

}
