package steps.SCM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.Cotizacion.SCMCotizacionesPage;
import util.JsonDataProcessor;
import util.MetodosGenericos;

import java.util.Objects;

import static steps.SCM.SCMAdministradorPedidoMaterialesStep.tipoPedido;

public class SCMCotizacionesStep {
    String env = System.getProperty("env", "qa");

    SCMCotizacionesPage scmCotizacionesPage = new SCMCotizacionesPage();
    SCMAdministradorPedidoMaterialesStep scmAdministradorPedidoMaterialesStep = new SCMAdministradorPedidoMaterialesStep();

    String dataJson = "src/test/data/SCM/administracionPM_Data.json";

    @When("Se modifica la cotizacion que esta en Estado Guardado por linea")
    public void seModificaLaCotizacionQueEstaEnEstadoGuardadoPorLinea() {
        scmAdministradorPedidoMaterialesStep.seCreaUnPedidoConProductoYSeEstableceUnDespachoDeDías("1","7");
        scmAdministradorPedidoMaterialesStep.seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoCotizacionSinDesignacion("1");
        scmCotizacionesPage.ingresoConsultaCotizaciones(SCMAdministradorPedidoMaterialesStep.nCotizacion);
    }

    @When("Se modifica la cotizacion que esta en Estado Guardado por maestro")
    public void seModificaLaCotizacionQueEstaEnEstadoGuardadoPorMaestro() {
        scmAdministradorPedidoMaterialesStep.seCreaUnPedidoConProductosPorMaestroYSeEstableceUnDespachoDeDías("3","7");
        scmAdministradorPedidoMaterialesStep.seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoCotizacionSinDesignacion("1");
        scmCotizacionesPage.ingresoConsultaCotizaciones(SCMAdministradorPedidoMaterialesStep.nCotizacion);
    }

    @And("Se agrega la descripcion del proyecto y se selecciona el proveedor {string}")
    public void seAgregaLaDescripcionDelProyectoYSeSeleccionaElProveedor(String proveedor) {
        scmCotizacionesPage.modificarCotizacion(SCMAdministradorPedidoMaterialesStep.nCotizacion,proveedor);
    }


    @Then("Se guarda, se verifica y se envia la cotizacion")
    public void seGuardaSeVerificaYSeEnviaLaCotizacion() {
        scmCotizacionesPage.envioCotizacion(SCMAdministradorPedidoMaterialesStep.nCotizacion,"proveedor");
    }


    @When("Se crea nueva cotizacion")
    public void seCreaNuevaCotizacion() {
        SCMAdministradorPedidoMaterialesStep.nCotizacion = JsonDataProcessor.getJsonValue(dataJson, "nombreCotizacion") + " " + (Objects.equals(tipoPedido, "maestro") ? tipoPedido : "")  + " " + MetodosGenericos.obtenerFechaConAleatorio();
        scmCotizacionesPage.crearCotizacion(SCMAdministradorPedidoMaterialesStep.nCotizacion );
    }


}


