package com.devsu.persons.domain.ports.in;

import java.util.List;

import com.devsu.persons.domain.models.Cliente;

public interface ClienteUseCase {

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(String id, Cliente cliente);

    List<Cliente> listarClientes();

    Cliente obtenerCliente(String id);

    void eliminarCliente(String id);

}
