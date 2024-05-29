Feature: Suite Administrar Pedido de Materiales

  Background:
    Given estoy en la página de inicio de iConstruye
    And el usuario "comprador" está autenticado en iConstruye


  @APM-01 @SmokeTest
  Scenario: Administrar pedido por linea para crear cotizacion
      And se crea un pedido con "1" producto y se establece un despacho de "7" días
      When Se selecciona "1" pedido de materiales utilizando el filtro de busqueda y creo cotizacion sin designacion
      Then Se consulta la cotizacion creada

  @APM-02 @SmokeTest
  Scenario: Administrar pedido por maestro para crear cotizacion
    And se crea un pedido con "3" productos por maestro y se establece un despacho de "7" días
    When Se selecciona "1" pedido de materiales utilizando el filtro de busqueda y creo cotizacion sin designacion
    Then Se consulta la cotizacion creada

  Scenario: Administrar pedido por linea para crear oc
    And se crea un pedido con "1" producto y se establece un despacho de "7" días
    When Se selecciona "1" pedido de materiales utilizando el filtro de busqueda y creo oc sin designacion
    Then Se consulta la oc creada

  Scenario: Administrar pedido por maestro para crear oc
    And se crea un pedido con "3" productos por maestro y se establece un despacho de "7" días
    When Se selecciona "1" pedido de materiales utilizando el filtro de busqueda y creo oc sin designacion
    Then Se consulta la oc creada




