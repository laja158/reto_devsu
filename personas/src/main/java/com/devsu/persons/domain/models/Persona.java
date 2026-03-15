package com.devsu.persons.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;

}
