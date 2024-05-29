package steps.SCM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import util.JsonDataProcessor;
import util.MetodosGenericos;

import java.io.IOException;

public class SCMPedidoMaterialesStep {

    String env = System.getProperty("env", "qa");

    public static String nPedido;
    public static String nProductos;
    String dataJson = "src/test/data/SCM/pedidoMateriales_Data.json";

    SCMLoginStep scmLoginStep = new SCMLoginStep();
    SCMPedidoMaterialesPage scmPedidoMaterialesPage = new SCMPedidoMaterialesPage();

    @Given("el usuario {string} está autenticado en iConstruye")
    public void elUsuarioEstáAutenticadoEnIConstruye(String userType) throws IOException {
        if(userType.equals("proveedor")) {
            MetodosGenericos.volverAVentanaPrincipal();
            scmLoginStep.cierroSesionEnIConstruye();
            MetodosGenericos.esperar(10);
            scmLoginStep.estoyLogueadoComoUsuario(userType);
        }
        else {
            scmLoginStep.estoyLogueadoComoUsuario(userType);
        }
    }

    @When("Se crea un nuevo pedido de materiales seleccionando {string} productos por codigo")
    public void seCreaUnNuevoPedidoDeMaterialesSeleccionandoProductosPorCodigo(String nProd) {
        nPedido = JsonDataProcessor.getJsonValue(dataJson, "agregar", "nombrePedido") + " " + MetodosGenericos.obtenerFechaConAleatorio();
        scmPedidoMaterialesPage.ingresoCrearPedidodeMateriales(nProd,nPedido);
    }

    @And("Se agregan detalles de dias de despacho {string} y se guarda el pedido de materiales")
    public void seAgreganDetallesDeDiasDeDespachoYSeGuardaElPedidoDeMateriales(String nDias) {
        scmPedidoMaterialesPage.agregarDetallePedidoMateriales(nDias);
    }

    @When("el usuario crea un nuevo pedido de materiales")
    public void elUsuarioCreaUnNuevoPedidoDeMateriales() {

    }

    @Then("Se consulta el pedido de materiales esperando que la cantidad de lineas sea {string}")
    public void seConsultaElPedidoDeMaterialesEsperandoQueLaCantidadDeLineasSea(String nProd) {
        nProductos = nProd;
        scmPedidoMaterialesPage.consultarEstadoPedido(nPedido,nProductos);
    }


    @When("Se crea un nuevo pedido de materiales con opcion maestro seleccionando {string} productos")
    public void seCreaUnNuevoPedidoDeMaterialesConOpcionMaestroSeleccionandoProductos(String nProd) {
        nProductos = nProd;
        nPedido = JsonDataProcessor.getJsonValue(dataJson, "maestro", "nombrePedido") + " " + MetodosGenericos.obtenerFechaConAleatorio();
        scmPedidoMaterialesPage.ingresoCrearPedidodeMaterialesMaestro(nProductos,nPedido);

    }

    @And("Se agregan detalles de dias de despacho {string} con opcion de maestro y se guarda el pedido de materiales")
    public void seAgreganDetallesDeDiasDeDespachoConOpcionDeMaestroYSeGuardaElPedidoDeMateriales(String nDias) {
        scmPedidoMaterialesPage.agregarDetallePedidoMaterialesMaestro(nDias, nProductos);
    }



}
