package com.devsu.persons.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.persons.infrastructure.persistence.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

    boolean existsByIdentificacion(String identificacion);

}
