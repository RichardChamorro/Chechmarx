Feature: Suite Bodega

    Background:
        Given estoy en la página de inicio de iConstruye



    @BOD-01 @SmokeTest
    Scenario: Recepcion OC desde cotizacion por linea
      And Se genera cotizacion por "linea" desde el lado "comprador"
      And Se oferta la cotizacion con usuario "proveedor"
      And Como "comprador" genero orden de compra
      When Se recibe la Orden de Compra en Bodega
      And Se busca la Orden de Compra creada y se hace click en recibir recursos
      Then Se coloca el Numero Documento de Transporte, se agrega la Cantidad "5" Recibida Conforme y se Confirma Recepcion

    @BOD-02 @SmokeTest
    Scenario: Recepcion OC desde cotizacion por maestro
      And Se genera cotizacion por "maestro" desde el lado "comprador"
      And Se oferta la cotizacion con usuario "proveedor"
      And Como "comprador" genero orden de compra
      When Se recibe la Orden de Compra en Bodega
      And Se busca la Orden de Compra creada y se hace click en recibir recursos
      Then Se coloca el Numero Documento de Transporte, se agrega la Cantidad "5" Recibida Conforme y se Confirma Recepcion
