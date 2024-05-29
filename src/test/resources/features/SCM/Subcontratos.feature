Feature: Suite Creacion y modificacion de subcontratos

    Background:
        Given estoy en la página de inicio de iConstruye
        And el usuario "comprador" está autenticado en iConstruye

    Scenario: Crear Subcontrato
        When Se ingresa al submenu Crear Subcontrato y se completan los datos de subcontrato
        And Se selecciona el subcontratista el representante legal la sucursal y si emite factura
        Then Se ingresa el anticipo y el porcentaje de retencion
        And Se ingresan productos por maestro y se edita la linea de productos
        Then Se verifica y se envia el subcontrato

    Scenario: Ingresar Pago de Anticipo
        When Se ingresa al submenu Consultar Subcontrato
        And Se ingresa a la opcion Ingresar Pago de Anticipo y se coloca el monto a pagar
        Then Se verifica y se envia el subcontrato
        And Se valida en Consultar Estados de Pago


    Scenario: Ingresar Pago de Avance
        When Se ingresa al submenu Consultar Subcontrato
        And Se ingresa a la opcion Ingresar Pago de Avance se colocan los montos a pagar y se hace click en Calcular
        And Se ingresa Descuento
        Then Se verifica y se envia el subcontrato
        And Se valida en Consultar Estados de Pago

    Scenario: Ingresar Pago de Retenciones
        When Se ingresa al submenu Consultar Subcontrato
        And Se ingresa a la opcion Ingresar Pago de Retenciones
        And Se verifica el monto a pagar y se Verifica
        Then Se verifica y se envia el subcontrato