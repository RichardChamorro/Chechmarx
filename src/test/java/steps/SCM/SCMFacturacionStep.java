package steps.SCM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.Facturacion.SCMFacturacionPage;
import util.MetodosGenericos;

import java.lang.reflect.Member;

public class SCMFacturacionStep {

    String env = System.getProperty("env", "qa");

    SCMFacturacionPage scmFacturacionPage = new SCMFacturacionPage();
    public static String nFactura;

    @When("Se genera la facturacion de la orden de compra")
    public void seGeneraLaFacturacionDeLaOrdenDeCompra() {
        nFactura = MetodosGenericos.obtenerFechaConAleatorio();
        scmFacturacionPage.IngresoFacturacion(nFactura);

    }


    @And("Se completan los montos de la factura")
    public void seCompletanLosMontosDeLaFactura() {
        scmFacturacionPage.IngresoMontosFactura(SCMBodegaStep.nRecepcion);
        scmFacturacionPage.AgregarDocumentoTransporte(SCMBodegaStep.nTransporte);
    }

    @Then("Se comprueba Factura")
    public void seCompruebaFactura() {
        scmFacturacionPage.validarFactura(nFactura);
    }


}
