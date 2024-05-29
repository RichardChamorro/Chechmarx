package pages.SCM.LadoProveedor;

import driverConfig.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Cotizacion.SCMCotizacionesLocators;
import pages.SCM.Home.SCMHomeLocators;
import pages.SCM.Home.SCMHomePage;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import steps.SCM.SCMAdministradorPedidoMaterialesStep;
import util.JsonDataProcessor;
import util.MetodosGenericos;

import java.lang.reflect.Member;

public class SCMLadoProveedorPage {
    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMPedidoMaterialesPage.class);

    private SCMLadoProveedorLocators pageElements;

    public SCMHomeLocators pageElementsHome;
    public SCMLadoProveedorPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMLadoProveedorLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);
    }

    String dataJson = "src/test/data/SCM/cotizacionPM_Data.json";
    public void ingConsultaCotizaciones(){
        pageElementsHome.btnSubMenuCotizaciones.click();
        MetodosGenericos.esperar(2);
        pageElements.btnConsultaCotizaciones.click();
        MetodosGenericos.esperar(3);
        MetodosGenericos.cambiarIFrame("ventana");
        pageElements.inputNombreCotizacion.sendKeys(SCMAdministradorPedidoMaterialesStep.nCotizacion);
        pageElements.btnBuscarCotizacion.click();
    }

    public void seleccionarCotizacion(String nLineas){
        MetodosGenericos.esperarPaginaCargada();
        try{
            MetodosGenericos.esperar(2);
            pageElements.btnCrearOferta.click();
            MetodosGenericos.esperar(5);
            pageElements.inputNombreOferta.sendKeys(JsonDataProcessor.getJsonValue(dataJson,"nombreOferta"));
            pageElements.inputMotivoOferta.sendKeys(JsonDataProcessor.getJsonValue(dataJson,"motivoOferta"));
            Assertions.assertEquals(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//tr[contains(@class,\"fila\")]//following-sibling::td[text()=\""+nLineas+"\"]")),30),true);
            pageElements.inputPrecioUni.sendKeys(JsonDataProcessor.getJsonValue(dataJson,"precio"));
            pageElements.inputDescuento.sendKeys(JsonDataProcessor.getJsonValue(dataJson,"descuento"));
            pageElements.inputFechaDespacho.sendKeys(MetodosGenericos.calcularFechaFutura(180));
            MetodosGenericos.esperar(5);
        } catch (Exception e){}

    }

    public void verificarCotizacion(){
        MetodosGenericos.esperarPaginaCargada();
        try {
            pageElements.btnVerificarCotizacion.click();
            MetodosGenericos.esperar(5);
            MetodosGenericos.bajarScroll();
            pageElements.btnEnviarCotizacion.click();
            MetodosGenericos.interactuarAlerta(true);
        }catch (Exception e){}
    }


    public void ingConsultarOrdenesdeCompra(){
        MetodosGenericos.esperarPaginaCargada();
        try {
            pageElementsHome.btnMenuVentas.click();
            MetodosGenericos.esperar(2);
            pageElementsHome.btnSubMenuConsultarOC.click();
            MetodosGenericos.visualizarObjeto(pageElements.buscarOCTxt, 30);
        }catch (Exception e){}
    }

    public void filtroBusquedaOC(){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.cambiarIFrame("ventana");
            pageElements.btnListaEmpresa.click();
            pageElements.btnListaEmpresa.sendKeys(JsonDataProcessor.getJsonValue(dataJson,"empresa"));
            pageElements.btnListaSucursal.click();
            pageElements.btnListaSucursal.sendKeys(JsonDataProcessor.getJsonValue(dataJson,"sucursal"));
            pageElements.btnListaEstado.click();
            pageElements.btnListaEstado.sendKeys(JsonDataProcessor.getJsonValue(dataJson,"estado"));

            pageElements.btnBuscarOC.click();
            MetodosGenericos.esperar(5);
        }catch (Exception e){}
    }


}
