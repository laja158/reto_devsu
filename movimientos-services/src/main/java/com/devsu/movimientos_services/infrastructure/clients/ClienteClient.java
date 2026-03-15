package com.devsu.movimientos_services.infrastructure.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.devsu.movimientos_services.domain.port.out.ClienteClientPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteClient implements ClienteClientPort {

    public static final String URL_CLIENT = "http://clientes-service:8081/clientes/";
    private final RestTemplate restTemplate;

    public boolean existeCliente(String clienteId) {

        try {

            restTemplate.getForObject(
                    URL_CLIENT + clienteId,
                    Object.class
            );
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
