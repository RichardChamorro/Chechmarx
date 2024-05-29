Feature:Suite Aprobación Desde Lado Proveedor

  Background:
    Given estoy en la página de inicio de iConstruye



  @PROV-01 @SmokeTest
    Scenario: Crear oferta desde lado Proveedor por linea
    And Se genera cotizacion por "linea" desde el lado "comprador"
    And el usuario "proveedor" está autenticado en iConstruye
    When Se ingresa al submenu Consultar Cotizaciones y se filtra por nombre
    And Se selecciona una cotizacion, se ingresa nombre y motivo de la oferta, se valida la linea del producto y se completan los campos
    Then Se hace click en Verificar y se valida Cotizacion en estado Enviada

  @PROV-02 @SmokeTest
  Scenario: Crear oferta desde lado Proveedor por maestro
    And Se genera cotizacion por "maestro" desde el lado "comprador"
    And el usuario "proveedor" está autenticado en iConstruye
    When Se ingresa al submenu Consultar Cotizaciones y se filtra por nombre
    And Se selecciona una cotizacion, se ingresa nombre y motivo de la oferta, se valida la linea del producto y se completan los campos
    Then Se hace click en Verificar y se valida Cotizacion en estado Enviada

