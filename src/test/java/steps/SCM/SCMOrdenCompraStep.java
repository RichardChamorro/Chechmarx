package steps.SCM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.AdministrarPedidoMateriales.SCMAdministradorPedidoMaterialesPage;
import pages.SCM.Cotizacion.SCMCotizacionesPage;
import pages.SCM.OrdenDeCompra.SCMOrdenDeCompraPage;
import util.MetodosGenericos;

import java.io.IOException;
import java.util.Objects;

public class SCMOrdenCompraStep {

    SCMLoginStep scmLoginStep = new SCMLoginStep();
    SCMCotizacionesPage scmCotizacionesPage = new SCMCotizacionesPage();
    SCMAdministradorPedidoMaterialesPage scmAdministradorPedidoMaterialesPage = new SCMAdministradorPedidoMaterialesPage();
    SCMOrdenDeCompraPage scmOrdenDeCompraPage = new SCMOrdenDeCompraPage();
    public static String nOC;
    public static String ocType;

    @And("reingreso como {string}")
    public void reingresoComo(String userType) throws IOException {
        MetodosGenericos.volverAVentanaPrincipal();
        scmLoginStep.cierroSesionEnIConstruye();
        MetodosGenericos.esperar(10);
        scmLoginStep.estoyLogueadoComoUsuario(userType);
    }

    @When("Se ingresa a ofertas de cotizacion")
    public void seIngresaAOfertasDeCotizacion() {
        scmCotizacionesPage.verificoOfertasCotizaciones(SCMAdministradorPedidoMaterialesStep.nCotizacion);
    }

    @And("Se acepta oferta de cotizacion {string}")
    public void seAceptaOfertaDeCotizacion(String arg0) {
        scmCotizacionesPage.aceptoOfertasCotizaciones(SCMAdministradorPedidoMaterialesStep.nCotizacion);
    }

    @Then("Se genera orden de compra")
    public void seGeneraOrdenDeCompra() {
        scmCotizacionesPage.verificarOrdenCompra(SCMAdministradorPedidoMaterialesStep.nCotizacion);
    }

    @When("Se selecciona {string} pedido de materiales utilizando el filtro de busqueda y creo oc sin designacion")
    public void seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoOcSinDesignacion(String nLineas) {
        nOC= "PM OC" + " " + (Objects.equals(SCMAdministradorPedidoMaterialesStep.tipoPedido, "maestro") ? SCMAdministradorPedidoMaterialesStep.tipoPedido : "")  + " " + MetodosGenericos.obtenerFechaConAleatorio();
        scmAdministradorPedidoMaterialesPage.ingresoAdmdePedidosOC(SCMPedidoMaterialesStep.nPedido);
    }


    @And("Se ingresa al submenu Consultar Ordenes de Compra y se edita la orden de compra")
    public void seIngresaAlSubmenuConsultarOrdenesDeCompraYSeEditaLaOrdenDeCompra() {
        scmOrdenDeCompraPage.ingresoConsultaEstadodeOrden(nOC);
    }

    @When("Se genera orden de compra desde pedido de materiales")
    public void seGeneraOrdenDeCompraDesdePedidoDeMateriales() {
        nOC= "PM OC" + " " + (Objects.equals(SCMAdministradorPedidoMaterialesStep.tipoPedido, "maestro") ? SCMAdministradorPedidoMaterialesStep.tipoPedido : "")  + " " + MetodosGenericos.obtenerFechaConAleatorio();
        scmOrdenDeCompraPage.crearOc(nOC);
    }
}
