Feature: Flujo de compra en SauceDemo

  Como usuario de SauceDemo
  Quiero poder realizar una compra exitosa
  Para verificar que el flujo de compra funciona correctamente

  Scenario: Comprar productos exitosamente
    Given que el usuario ingresa a SauceDemo
    When se autentica con el usuario "standard_user" y password "secret_sauce"
    And agrega dos productos al carrito
    And visualiza el carrito
    And completa el formulario de compra con:
      | nombre       | apellido    | codigoPostal |
      | Juan         | Pérez       | 12345        |
    And finaliza la compra
    Then debería ver el mensaje de confirmación "THANK YOU FOR YOUR ORDER"
