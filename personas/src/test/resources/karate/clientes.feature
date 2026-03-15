Feature: Clientes API

Scenario: Crear cliente

Given url 'http://localhost:8081/clientes'
And request
"""
{
  "nombre": "Jose Lema",
  "genero": "M",
  "edad": 30,
  "identificacion": "123456",
  "direccion": "Quito",
  "telefono": "099999999",
  "password": "1234",
  "estado": true
}
"""
When method post
Then status 200
And match response.clienteId != null