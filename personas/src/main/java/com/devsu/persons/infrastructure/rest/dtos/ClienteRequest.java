package com.devsu.persons.infrastructure.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequest {

    @NotBlank
    private String nombre;

    private String genero;

    private Integer edad;

    @NotBlank
    private String identificacion;

    private String direccion;

    private String telefono;

    @NotBlank
    private String password;

    private Boolean estado;

}
