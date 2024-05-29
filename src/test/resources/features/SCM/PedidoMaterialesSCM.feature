Feature: Suite Crear Pedido de Materiales

  Background:
    Given estoy en la página de inicio de iConstruye
    And el usuario "comprador" está autenticado en iConstruye

  @PM-01 @Smoketest
  Scenario: Crear Pedido de Materiales con opcion linea
    When Se crea un nuevo pedido de materiales seleccionando "1" productos por codigo
    And Se agregan detalles de dias de despacho "7" y se guarda el pedido de materiales
    Then Se consulta el pedido de materiales esperando que la cantidad de lineas sea "1"


  @PM-02 @Smoketest
  Scenario: Crear Pedido de Materiales con opcion maestro
    When Se crea un nuevo pedido de materiales con opcion maestro seleccionando "3" productos
    And Se agregan detalles de dias de despacho "7" con opcion de maestro y se guarda el pedido de materiales
    Then Se consulta el pedido de materiales esperando que la cantidad de lineas sea "3"

