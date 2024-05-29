Feature: Flujo E2E Ciclo Abastecimiento y logistico

  Background:
    Given estoy en la página de inicio de iConstruye



  @E2E-01 @E2E @Regresion @Prueba
  Scenario: Generar Factura recepcionado en recepcion con pedido de materiales buscado por lupa y cotizado por pedido
    And Se genera cotizacion desde pedido de materiales por "lupa" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


  @E2E-02 @E2E @Regresion
  Scenario: Generar Factura recepcionado en bodega con pedido de materiales buscado por maestro y cotizado por linea
    And Se genera cotizacion desde pedido de materiales por "maestro" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura

  @E2E-03 @E2E @Regresion
  Scenario: Generar Factura recepcionado en bodega desde crear cotizacion por lupa seleccionado por linea
    And el usuario "comprador" está autenticado en iConstruye
    And Se crea nueva cotizacion
    And Se guarda, se verifica y se envia la cotizacion
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


  @E2E-04 @E2E
  Scenario: Generar Factura recepcionado en bodega desde crear cotizacion por maestro seleccionado por linea
    And Se genera cotizacion por "maestro" desde el lado "comprador"
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


  @E2E-05 @E2E @Regresion @Prueba
  Scenario: Generar Factura recepcionado en bodega generando orden de compra desde pedido de materiales buscado por lupa seleccionado por linea
    And el usuario "comprador" está autenticado en iConstruye
    And Se genera oc por "lupa" desde pedido de materiales
    When Se ingresa al submenu Consultar Ordenes de Compra y se edita la orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura

  @E2E-06 @E2E @Regresion
  Scenario: Generar Factura recepcionado en bodega generando orden de compra desde pedido de materiales buscado por maestro seleccionado por linea
    And el usuario "comprador" está autenticado en iConstruye
    And Se genera oc por "lupa" desde pedido de materiales
    When Se ingresa al submenu Consultar Ordenes de Compra y se edita la orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


  @E2E-07 @E2E @Regresion
  Scenario: Generar Factura recepcionado en bodega generando orden de compra desde crear orden de compra buscado por lupa seleccionado por linea
    And el usuario "comprador" está autenticado en iConstruye
    And Se genera oc por "lupa" desde crear orden de compra
    When Se ingresa al submenu Consultar Ordenes de Compra y se edita la orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura

  @E2E-08 @E2E @Regresion
  Scenario: Generar Factura recepcionado en bodega generando orden de compra desde crear orden de compra buscado por maestro seleccionado por linea
    And el usuario "comprador" está autenticado en iConstruye
    And Se genera oc por "maestro" desde crear orden de compra
    When Se ingresa al submenu Consultar Ordenes de Compra y se edita la orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura


