Feature: Suite Generacion Orden de Compra

  Background:
    Given estoy en la página de inicio de iConstruye
    And el usuario "comprador" está autenticado en iConstruye



  Scenario: Se consulta y edita OC
   # When el usuario "comprador" está autenticado en iConstruye
    And Se ingresa al submenu Consultar Ordenes de Compra y se edita la orden de compra
    #Then Se guarda y se envia



    @OC-01 @SmokeTest @OC
    Scenario: Genero Orden de compra desde cotizacion por linea
      And Se genera cotizacion por "linea" desde el lado "comprador"
      And Se oferta la cotizacion con usuario "proveedor"
      And reingreso como "comprador"
      When Se ingresa a ofertas de cotizacion
      And Se acepta oferta de cotizacion "Mejor precio"
      Then Se genera orden de compra


    @OC-02 @SmokeTest @OC
    Scenario: Genero Orden de compra desde cotizacion por maestro
      And Se genera cotizacion por "maestro" desde el lado "comprador"
      And Se oferta la cotizacion con usuario "proveedor"
      And reingreso como "comprador"
      When Se ingresa a ofertas de cotizacion
      And Se acepta oferta de cotizacion "Mejor precio"
      Then Se genera orden de compra

  @OC-03 @SmokeTest @OC
  Scenario: Genero Orden de compra desde pedido de materiales por lupa
    And Se genera oc por "lupa" desde pedido de materiales
    When Se ingresa al submenu Consultar Ordenes de Compra y se edita la orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura
