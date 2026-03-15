package com.devsu.persons.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona {

    private String clienteId;
    private String password;
    private Boolean estado;

}
