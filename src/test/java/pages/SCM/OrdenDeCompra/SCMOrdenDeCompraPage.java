package pages.SCM.OrdenDeCompra;

import driverConfig.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Home.SCMHomeLocators;
import util.JsonDataProcessor;
import util.MetodosGenericos;


public class SCMOrdenDeCompraPage {
    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMOrdenDeCompraPage.class);

    private SCMOrdenDeCompraLocators pageElements;

    public SCMHomeLocators pageElementsHome;

    public SCMOrdenDeCompraPage() {
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMOrdenDeCompraLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);
    }

    public void ingresoConsultaEstadodeOrden(String nOC){
        try {
            MetodosGenericos.volverAVentanaPrincipal();
            boolean visualizarbtnCompras = MetodosGenericos.visualizarObjeto(pageElementsHome.btnCompras, 90);
            if (visualizarbtnCompras) {
                MetodosGenericos.esperar(5);
                pageElementsHome.btnCompras.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.btnSubMenuConsultarEstadoOC.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.cambiarIFrame("ventana");
                pageElements.inputOc.sendKeys(nOC);
                MetodosGenericos.esperar(2);
                pageElements.btnBuscarOC.click();
                //pageElements.btnEditarOC.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.crearElemento(By.xpath("//td[text()=\""+nOC+"\"]//following-sibling::td//following-sibling::a[@title='Editar la orden de compra']")).click();
                MetodosGenericos.esperar(5);
                pageElements.inputRutProveedor1.click();
                //MetodosGenericos.esperar(5);
                pageElements.inputRutProveedor.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/ordenCompra_Data.json","rut"));
                MetodosGenericos.esperar(5);
                pageElements.btnSeleccionProveedor.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.selectOptionByValue(pageElements.selectSucursal, "267970");
                MetodosGenericos.esperar(5);
                pageElements.btnEditarDatosOC.click();
                MetodosGenericos.esperar(5);
                pageElements.inputEditarPrecioUnitario.clear();
                pageElements.inputEditarPrecioUnitario.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/cotizacionPM_Data.json","precio"));
                pageElements.btnAgregarCambios.click();
                MetodosGenericos.esperar(5);
                pageElements.btnGuardarOC.click();
                MetodosGenericos.esperar(2);
                pageElements.btnVerificarOC.click();
                MetodosGenericos.esperar(15);
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(pageElements.msgValidacion,90));
                pageElements.btnEnviarOC.click();
                MetodosGenericos.esperar(2);
                pageElements.btnEnviarOCJS.click();
                MetodosGenericos.volverAVentanaPrincipal();
            } else {
                Assertions.fail("no se pudo interacturar con el btn subMenuConsultarEstadoOC");
            }
        } catch (Exception e) {
            log.error("No se pudo ingresar al sub menu Consultar Estado de Orden " + e);
        }
    }

    public void crearOc(String nOC){
        MetodosGenericos.esperarPaginaCargada();
        try{
            MetodosGenericos.cambiarIFrame("ventana");
            boolean visualizarInputOC = MetodosGenericos.visualizarObjeto(pageElements.inputNombreOrdenCompra, 90);
            if (visualizarInputOC) {
                pageElements.inputNombreOrdenCompra.sendKeys(nOC);
                MetodosGenericos.esperar(2);
                pageElements.btnGenerarOC.click();
                MetodosGenericos.volverAVentanaPrincipal();
            }
            else {
                Assertions.fail("No se pudo interactuar con el botón Consultar estado de pedido");
            }
        }
        catch (Exception e){
            log.error("No se pudo consultar el estado del pedido de materiales " + e);
        }
    }


}

