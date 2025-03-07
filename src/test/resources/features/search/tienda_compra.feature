Feature: Realizar compra en la tienda

  Scenario: Completar una compra exitosa
    Given que el usuario está autenticado
    When agrega productos al carrito
    And visualiza el carrito
    And completa el formulario de compra
    Then el usuario debería ver la confirmación "THANK YOU FOR YOUR ORDER"