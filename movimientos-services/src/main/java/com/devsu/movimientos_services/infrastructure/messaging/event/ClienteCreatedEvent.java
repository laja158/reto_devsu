package com.devsu.movimientos_services.infrastructure.messaging.event;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClienteCreatedEvent implements Serializable {

    private String clienteId;
    private String nombre;

}