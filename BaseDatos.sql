CREATE DATABASE clientes_db;
CREATE DATABASE cuentas_db;

CREATE TABLE clientes (
    cliente_id VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(20),
    edad INT,
    identificacion VARCHAR(50) UNIQUE NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(50),
    password VARCHAR(255) NOT NULL,
    estado BOOLEAN
);

CREATE TABLE cuentas (
    numero_cuenta VARCHAR(20) PRIMARY KEY,
    tipo_cuenta VARCHAR(20) NOT NULL,
    saldo_inicial DECIMAL(15,2) NOT NULL,
    estado BOOLEAN NOT NULL,
    cliente_id VARCHAR(50) NOT NULL
);

CREATE TABLE movimientos (
    id UUID PRIMARY KEY,
    numero_cuenta VARCHAR(20) NOT NULL,
    tipo_movimiento VARCHAR(20),
    valor DECIMAL(15,2) NOT NULL,
    saldo DECIMAL(15,2) NOT NULL,
    saldo_inicial DECIMAL(15,2) NOT NULL,
    fecha TIMESTAMP NOT NULL,

    CONSTRAINT fk_cuenta
    FOREIGN KEY (numero_cuenta)
    REFERENCES cuentas(numero_cuenta)
);

INSERT INTO clientes (
    cliente_id,
    nombre,
    genero,
    edad,
    identificacion,
    direccion,
    telefono,
    password,
    estado
) VALUES (
    'cliente-1',
    'Jose Lema',
    'M',
    30,
    '123456',
    'Quito',
    '099999999',
    '$2a$10$encryptedpassword',
    true
);

INSERT INTO cuentas (
    numero_cuenta,
    tipo_cuenta,
    saldo_inicial,
    estado,
    cliente_id
) VALUES (
    '478758',
    'AHORROS',
    2000,
    true,
    'cliente-1'
);

INSERT INTO movimientos (
    id,
    numero_cuenta,
    tipo_movimiento,
    valor,
    saldo,
    saldo_inicial,
    fecha
) VALUES (
    gen_random_uuid(),
    '478758',
    'DEPOSITO',
    2000,
    4000,
    2000
    NOW()
);