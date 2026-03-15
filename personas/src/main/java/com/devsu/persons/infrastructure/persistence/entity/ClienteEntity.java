package com.devsu.persons.infrastructure.persistence.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "clientes",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "identificacion")
    }    
)
@Getter
@Setter
public class ClienteEntity extends PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String clienteId;

    private String password;

    private Boolean estado;

}
