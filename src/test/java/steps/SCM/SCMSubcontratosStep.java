package steps.SCM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.SubContrato.SCMSubcontratoPage;

public class SCMSubcontratosStep {

    SCMSubcontratoPage scmSubContratospage = new SCMSubcontratoPage();


    @When("Se ingresa al submenu Crear Subcontrato y se completan los datos de subcontrato")
    public void seIngresaAlSubmenuCrearSubcontratoYSeCompletanLosDatosDeSubcontrato() {
        scmSubContratospage.ingresoCrearSubContrato();
        scmSubContratospage.completarDatosSubContrato();
    }

    @And("Se selecciona el subcontratista el representante legal la sucursal y si emite factura")
    public void seSeleccionaElSubcontratistaElRepresentanteLegalLaSucursalYSiEmiteFactura() {
        scmSubContratospage.seleccionSubContratistayRepresentante();
    }

    @Then("Se ingresa el anticipo y el porcentaje de retencion")
    public void seIngresaElAnticipoYElPorcentajeDeRetencion() {
        scmSubContratospage.anticipoyRetencion();
    }

    @And("Se ingresan productos por maestro y se edita la linea de productos")
    public void seIngresanProductosPorMaestroYSeEditaLaLineaDeProductos() {
        scmSubContratospage.ingresoProductosMaestro();
    }

    @Then("Se verifica y se envia el subcontrato")
    public void seVerificaYSeEnviaElSubcontrato() {
    }

    @When("Se ingresa al submenu Consultar Subcontrato")
    public void seIngresaAlSubmenuConsultarSubcontrato() {
    }

    @And("Se ingresa a la opcion Ingresar Pago de Anticipo y se coloca el monto a pagar")
    public void seIngresaALaOpcionIngresarPagoDeAnticipoYSeColocaElMontoAPagar() {
    }

    @And("Se valida en Consultar Estados de Pago")
    public void seValidaEnConsultarEstadosDePago() {
    }

}
