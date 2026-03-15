package com.devsu.movimientos_services.infrastructure.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.devsu.movimientos_services.infrastructure.messaging.event.ClienteCreatedEvent;

@Component
@Slf4j
public class ClienteEventConsumer {

    @RabbitListener(queues = "clientes.queue")
    public void recibirClienteCreado(ClienteCreatedEvent event) {

        log.info("Cliente creado recibido: {}", event);

    }
}
