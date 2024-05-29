Feature: Suite Cotizacion

    Background:
        Given estoy en la página de inicio de iConstruye
        And el usuario "comprador" está autenticado en iConstruye

  @COT-01 @SmokeTest
    Scenario: Enviar Cotizacion PM por linea
      When Se modifica la cotizacion que esta en Estado Guardado por linea
      And Se agrega la descripcion del proyecto y se selecciona el proveedor "proveedor"
      Then Se guarda, se verifica y se envia la cotizacion

  @COT-02 @SmokeTest
  Scenario: Enviar Cotizacion PM por maestro
    When Se modifica la cotizacion que esta en Estado Guardado por maestro
    And Se agrega la descripcion del proyecto y se selecciona el proveedor "proveedor"
    Then Se guarda, se verifica y se envia la cotizacion


@COT @Prueba
  Scenario: Creacion Cotizacion
    When Se crea nueva cotizacion
    And Se guarda, se verifica y se envia la cotizacion
    And Se oferta la cotizacion con usuario "proveedor"
    And Como "comprador" genero orden de compra
    And Se recepciona en bodega "5" Productos
    When Se genera la facturacion de la orden de compra
    And Se completan los montos de la factura
    Then Se comprueba Factura



