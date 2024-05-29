package steps.SCM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.Bodega.SCMBodegaPage;
import pages.SCM.Cotizacion.SCMCotizacionesPage;
import util.JsonDataProcessor;
import util.MetodosGenericos;

import java.io.IOException;


public class SCMBodegaStep {

    SCMBodegaPage scmBodegaPage = new SCMBodegaPage();
    SCMOrdenCompraStep scmOrdenCompraStep = new SCMOrdenCompraStep();
    public static String nRecepcion;
    public static String nTransporte;

    @When("Se recibe la Orden de Compra en Bodega")
    public void seRecibeLaOrdenDeCompraEnBodega() {
        scmBodegaPage.ingresoBodega();
    }

    @And("Se busca la Orden de Compra creada y se hace click en recibir recursos")
    public void seBuscaLaOrdenDeCompraCreadaYSeHaceClickEnRecibirRecursos() {
        String OC = (SCMOrdenCompraStep.ocType == null || SCMOrdenCompraStep.ocType.isEmpty())
                ? SCMAdministradorPedidoMaterialesStep.nCotizacion
                : SCMOrdenCompraStep.ocType.equals("oc")
                ? SCMOrdenCompraStep.nOC
                : null;
        scmBodegaPage.recepcionOrdenDeCompra(OC);
    }

    @Then("Se coloca el Numero Documento de Transporte, se agrega la Cantidad {string} Recibida Conforme y se Confirma Recepcion")
    public void seColocaElNumeroDocumentoDeTransporteYSeAgregaLaCantidadRecibidaConformeYSeConfirmaRecepcion(String cantidad) {
        nRecepcion = cantidad;
        nTransporte = MetodosGenericos.obtenerFechaConAleatorio();
        scmBodegaPage.completarCamposyConfirmar(nTransporte,nRecepcion);
    }


    @And("Como {string} genero orden de compra")
    public void comoGeneroOrdenDeCompra(String userType) throws IOException {
       scmOrdenCompraStep.reingresoComo(userType);
       scmOrdenCompraStep.seIngresaAOfertasDeCotizacion();
       scmOrdenCompraStep.seAceptaOfertaDeCotizacion(SCMAdministradorPedidoMaterialesStep.nCotizacion);
       scmOrdenCompraStep.seGeneraOrdenDeCompra();
    }

    @And("Se recepciona en bodega {string} Productos")
    public void seRecepcionaEnBodegaProductos(String cantidad) {
        seRecibeLaOrdenDeCompraEnBodega();
        seBuscaLaOrdenDeCompraCreadaYSeHaceClickEnRecibirRecursos();
        seColocaElNumeroDocumentoDeTransporteYSeAgregaLaCantidadRecibidaConformeYSeConfirmaRecepcion(cantidad);
    }
}
