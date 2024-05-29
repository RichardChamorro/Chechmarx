package steps.SCM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.LadoProveedor.SCMLadoProveedorPage;
import util.MetodosGenericos;

import java.io.IOException;

public class SCMLadoProveedorStep {
    String env = System.getProperty("env", "qa");

    SCMLadoProveedorPage scmLadoProveedorPage = new SCMLadoProveedorPage();
    SCMLoginStep scmLoginStep = new SCMLoginStep();
    SCMCotizacionesStep scmCotizacionesStep = new SCMCotizacionesStep();
    SCMPedidoMaterialesStep scmPedidoMaterialesStep = new SCMPedidoMaterialesStep();

    @When("Se ingresa al submenu Consultar Cotizaciones y se filtra por nombre")
    public void seIngresaAlSubmenuConsultarCotizacionesYSeFiltraPorNombre() {
        scmLadoProveedorPage.ingConsultaCotizaciones();
    }


    @And("Se selecciona una cotizacion, se ingresa nombre y motivo de la oferta, se valida la linea del producto y se completan los campos")
    public void seSeleccionaUnaCotizacionSeIngresaNombreYMotivoDeLaOfertaSeValidaLaLineaDelProductoYSeCompletanLosCampos() {
        scmLadoProveedorPage.seleccionarCotizacion("1");
    }

    @Then("Se hace click en Verificar y se valida Cotizacion en estado Enviada")
    public void seHaceClickEnVerificarYSeValidaCotizacionEnEstadoEnviada() {
        scmLadoProveedorPage.verificarCotizacion();
    }

    @When("Se ingresa al submenu Consultar Ordenes de Compra y se valida que se visualice la pagina Buscar Ordenes de Compra")
    public void seIngresaAlSubmenuConsultarOrdenesDeCompraYSeValidaQueSeVisualiceLaPaginaBuscarOrdenesDeCompra() {
        scmLadoProveedorPage.ingConsultarOrdenesdeCompra();

    }

    @And("Se filtra por empresa, sucursal, estado y en Proceso y click en Buscar")
    public void seFiltraPorEmpresaSucursalEstadoYEnProcesoYClickEnBuscar() {
        scmLadoProveedorPage.filtroBusquedaOC();
    }

    @Then("Se valida la grilla con ordenes de compra")
    public void seValidaLaGrillaConOrdenesDeCompra() {

    }

    @And("Se selecciona una cotizacion abierta con al menos una oferta en el icono $ y click en Comparar")
    public void seSeleccionaUnaCotizacionAbiertaConAlMenosUnaOfertaEnElIcono$YClickEnComparar() {
        
    }

    @Then("Se valida que se muestre el Cuadro Comparativo")
    public void seValidaQueSeMuestreElCuadroComparativo() {
    }

    @And("Se genera cotizacion por {string} desde el lado {string}")
    public void seGeneraCotizacionPorDesdeElLado(String pmType, String userType) throws IOException {
        scmLoginStep.ingresoLasCredencialesDeUsuario(userType);
        if(pmType.equals("maestro")){
            scmCotizacionesStep.seModificaLaCotizacionQueEstaEnEstadoGuardadoPorMaestro();
        }
        else {
            scmCotizacionesStep.seModificaLaCotizacionQueEstaEnEstadoGuardadoPorLinea();
        }
        scmCotizacionesStep.seAgregaLaDescripcionDelProyectoYSeSeleccionaElProveedor("proveedor");
        scmCotizacionesStep.seGuardaSeVerificaYSeEnviaLaCotizacion();
    }


    @And("Se oferta la cotizacion con usuario {string}")
    public void seOfertaLaCotizacionConUsuario(String userType) throws IOException {
        scmPedidoMaterialesStep.elUsuarioEstáAutenticadoEnIConstruye(userType);
        seIngresaAlSubmenuConsultarCotizacionesYSeFiltraPorNombre();
        seSeleccionaUnaCotizacionSeIngresaNombreYMotivoDeLaOfertaSeValidaLaLineaDelProductoYSeCompletanLosCampos();
        seHaceClickEnVerificarYSeValidaCotizacionEnEstadoEnviada();
    }


    @And("Se genera cotizacion desde pedido de materiales por {string} desde el lado {string}")
    public void seGeneraCotizacionDesdePedidoDeMaterialesPorDesdeElLado(String pmType, String userType) throws IOException {
        scmLoginStep.ingresoLasCredencialesDeUsuario(userType);
        if(pmType.equals("maestro")){
            scmCotizacionesStep.seModificaLaCotizacionQueEstaEnEstadoGuardadoPorMaestro();
        }
        else {
            scmCotizacionesStep.seModificaLaCotizacionQueEstaEnEstadoGuardadoPorLinea();
        }
        scmCotizacionesStep.seAgregaLaDescripcionDelProyectoYSeSeleccionaElProveedor("proveedor");
        scmCotizacionesStep.seGuardaSeVerificaYSeEnviaLaCotizacion();
    }
}
