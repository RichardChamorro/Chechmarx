Feature: Suite Facturacion

    Background:
        Given estoy en la página de inicio de iConstruye


   @FAC-01 @SmokeTest
     # Objetivo:
  Scenario: Generar Factura con pedido de materiales buscado por lupa y cotizado por linea
    And Se genera cotizacion por "lupa" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura

  @FAC-02 @SmokeTest
  Scenario: Generar Factura con pedido de materiales buscado por maestro y cotizado por maestro
    And Se genera cotizacion por "maestro" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura

  @FAC-03 @SmokeTest
  Scenario: Generar Factura con pedido de materiales buscado por lupa y generar orden de compra por linea
    And Se genera oc por "lupa" desde el lado "comprador"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


  @FAC-04 @SmokeTest
  Scenario:  Generar Factura desde una cotizacion directa buscado por maestro
    And Se genera oc por "maestro" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


  @FAC-05 @SmokeTest
  Scenario: Generar Factura OC Bodega PM oc por lupa
    And Se genera oc por "lupa" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura

  @FAC-06 @SmokeTest
  Scenario: Generar Factura OC Bodega PM oc por maestro
    And Se genera oc por "maestro" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


  @FAC-06 @SmokeTest
  Scenario: Generar Factura OC Bodega OC por maestro
    And Se genera oc por "maestro" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


