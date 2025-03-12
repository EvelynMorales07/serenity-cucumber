Feature: Compra de productos en SauceDemo
  Background:
    * url 'https://www.saucedemo.com/'

  Scenario Outline: Comprar un producto exitosamente
    Given el usuario inicia sesión con usuario "<usuario>" y contraseña "<contraseña>"
    When agrega el producto "<producto>" al carrito
    And procede al checkout con nombre "<nombre>", apellido "<apellido>" y código postal "<codigo_postal>"
    Then debería ver el mensaje de confirmación "Thank you for your order!"

    Examples:
      | usuario      | contraseña  | producto           | nombre  | apellido | codigo_postal |
      | standard_user | secret_sauce | Sauce Labs Backpack | Juan    | Pérez    | 12345         |
      | problem_user  | secret_sauce | Sauce Labs Bolt T-Shirt | María  | López    | 67890         |
