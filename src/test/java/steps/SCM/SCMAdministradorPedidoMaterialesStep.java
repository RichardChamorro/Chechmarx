package steps.SCM;

import org.openqa.selenium.WebDriver;
import pages.SCM.AdministrarPedidoMateriales.SCMAdministradorPedidoMaterialesPage;
import pages.SCM.Cotizacion.SCMCotizacionesPage;
import pages.SCM.Home.SCMHomeLocators;
import pages.SCM.Login.SCMLoginLocators;
import pages.SCM.OrdenDeCompra.SCMOrdenDeCompraPage;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import util.JsonDataProcessor;
import util.MetodosGenericos;

import java.io.IOException;
import java.util.Objects;

public class SCMAdministradorPedidoMaterialesStep {

    String env = System.getProperty("env", "qa");


    SCMPedidoMaterialesStep scmPedidoMaterialesStep = new SCMPedidoMaterialesStep();
    SCMAdministradorPedidoMaterialesPage scmAdministradorPedidoMaterialesPage = new SCMAdministradorPedidoMaterialesPage();
    SCMCotizacionesPage scmCotizacionesPage = new SCMCotizacionesPage();
    SCMOrdenCompraStep scmOrdenCompraStep = new SCMOrdenCompraStep();
    public static String nCotizacion;
    String dataJson = "src/test/data/SCM/administracionPM_Data.json";
    public String nLineas;
    public static String tipoPedido;

    @And("se crea un pedido con {string} producto y se establece un despacho de {string} días")
    public void seCreaUnPedidoConProductoYSeEstableceUnDespachoDeDías(String nLineasStep, String nDias) {
        SCMAdministradorPedidoMaterialesStep.nCotizacion = JsonDataProcessor.getJsonValue(dataJson, "nombreCotizacion") + " " + (Objects.equals(tipoPedido, "maestro") ? tipoPedido : "")  + " " + MetodosGenericos.obtenerFechaConAleatorio();
        nLineas = nLineasStep;
        scmPedidoMaterialesStep.seCreaUnNuevoPedidoDeMaterialesSeleccionandoProductosPorCodigo(nLineas);
        scmPedidoMaterialesStep.seAgreganDetallesDeDiasDeDespachoYSeGuardaElPedidoDeMateriales(nDias);
        scmPedidoMaterialesStep.seConsultaElPedidoDeMaterialesEsperandoQueLaCantidadDeLineasSea(nLineas);
    }

    @When("Se selecciona {string} pedido de materiales utilizando el filtro de busqueda y creo cotizacion sin designacion")
    public void seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoCotizacionSinDesignacion(String nLineas) {
        scmAdministradorPedidoMaterialesPage.ingresoAdmdePedidos(SCMPedidoMaterialesStep.nPedido, SCMAdministradorPedidoMaterialesStep.nCotizacion);
    }

    @When("Se selecciona {string} pedido de materiales utilizando el filtro de busqueda y creo orden de compra sin designacion")
    public void seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoOrdenDeCompraSinDesignacion(String nLineas) {
        scmAdministradorPedidoMaterialesPage.ingresoAdmdePedidosOC(SCMPedidoMaterialesStep.nPedido);
    }


    @Then("Se consulta la cotizacion creada")
    public void seConsultaLaCotizacionCreada() {
       scmCotizacionesPage.ingresoConsultaCotizaciones(nCotizacion);
    }

    @And("se crea un pedido con {string} productos por maestro y se establece un despacho de {string} días")
    public void seCreaUnPedidoConProductosPorMaestroYSeEstableceUnDespachoDeDías(String nLineasStep, String nDias) {
        nLineas = nLineasStep;
        tipoPedido = "maestro";
        scmPedidoMaterialesStep.seCreaUnNuevoPedidoDeMaterialesConOpcionMaestroSeleccionandoProductos(nLineas);
        scmPedidoMaterialesStep.seAgreganDetallesDeDiasDeDespachoConOpcionDeMaestroYSeGuardaElPedidoDeMateriales(nDias);
        scmPedidoMaterialesStep.seConsultaElPedidoDeMaterialesEsperandoQueLaCantidadDeLineasSea(nLineas);
    }


    @And("Se genera oc por {string} desde pedido de materiales")
    public void seGeneraOcPorDesdePedidoDeMateriales(String pmType) {
        SCMOrdenCompraStep.ocType = "oc";
        if(pmType.equals("maestro")){
            seCreaUnPedidoConProductosPorMaestroYSeEstableceUnDespachoDeDías("3","7");
            seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoOrdenDeCompraSinDesignacion ("1");
        }
        else {
            seCreaUnPedidoConProductoYSeEstableceUnDespachoDeDías("1","7");
            seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoOrdenDeCompraSinDesignacion("1");
        }
        scmOrdenCompraStep.seGeneraOrdenDeCompraDesdePedidoDeMateriales();
    }

    @And("Se genera oc por {string} desde crear orden de compra")
    public void seGeneraOcPorDesdeCrearOrdenDeCompra(String pmType) {
        SCMOrdenCompraStep.ocType = "oc";
        if(pmType.equals("maestro")){
            seCreaUnPedidoConProductosPorMaestroYSeEstableceUnDespachoDeDías("3","7");
            seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoOrdenDeCompraSinDesignacion ("1");
        }
        else {
            seCreaUnPedidoConProductoYSeEstableceUnDespachoDeDías("1","7");
            seSeleccionaPedidoDeMaterialesUtilizandoElFiltroDeBusquedaYCreoOrdenDeCompraSinDesignacion("1");
        }
        scmOrdenCompraStep.seGeneraOrdenDeCompraDesdePedidoDeMateriales();
    }


}
