Feature: Petstore API tests

  Background:
    * url 'https://petstore.swagger.io/'  # Definir la URL base de la API de Petstore

  Scenario: Añadir una mascota a la tienda
    Given path 'pet'
    And request { "id": 0, "name": "Doggie", "photoUrls": ["string"], "tags": [{"id": 1, "name": "dog"}], "status": "available" }
    When method post
    Then status 200
    And match response.id == 0
    And match response.name == 'Doggie'
    And match response.status == 'available'

  Scenario: Consultar la mascota ingresada previamente por ID
    Given path 'pet', 0  # Usamos el ID que asignamos en el escenario anterior
    When method get
    Then status 200
    And match response.name == 'Doggie'
    And match response.status == 'available'

  Scenario: Actualizar el nombre y estatus de la mascota
    Given path 'pet'
    And request { "id": 0, "name": "DoggieUpdated", "photoUrls": ["string"], "tags": [{"id": 1, "name": "dog"}], "status": "sold" }
    When method put
    Then status 200
    And match response.name == 'DoggieUpdated'
    And match response.status == 'sold'

  Scenario: Consultar la mascota modificada por estatus
    Given path 'pet/findByStatus'
    And param status = 'sold'
    When method get
    Then status 200
    And match response[0].name == 'DoggieUpdated'
    And match response[0].status == 'sold'
