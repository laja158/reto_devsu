package com.devsu.persons.infrastructure.messaging.event;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteCreatedEvent implements Serializable {

    private String clienteId;

    private String nombre;

}
