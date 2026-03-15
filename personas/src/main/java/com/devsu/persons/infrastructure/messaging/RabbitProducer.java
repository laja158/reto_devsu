package com.devsu.persons.infrastructure.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.devsu.persons.infrastructure.config.RabbitConfig;
import com.devsu.persons.infrastructure.messaging.event.ClienteCreatedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public void enviarClienteCreado(ClienteCreatedEvent event) {

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                event
        );

    }

}
