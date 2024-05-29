package pages.SCM.Bodega;


import driverConfig.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Home.SCMHomeLocators;
import pages.SCM.LadoProveedor.SCMLadoProveedorLocators;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import util.JsonDataProcessor;
import util.MetodosGenericos;

import java.util.Random;

public class SCMBodegaPage {
    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMBodegaPage.class);

    private SCMBodegaLocators pageElements;

    public SCMHomeLocators pageElementsHome;
    public SCMBodegaPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMBodegaLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);
    }

    public void ingresoBodega() {
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.volverAVentanaPrincipal();
            boolean visualizarbtnBodega = MetodosGenericos.visualizarObjeto(pageElementsHome.btnBodega, 90);
            if (visualizarbtnBodega) {
                MetodosGenericos.esperar(5);
                pageElementsHome.btnBodega.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.mouseHoverElement(pageElementsHome.btnSubMenuBodegaIngreso);
                MetodosGenericos.esperar(2);
                pageElementsHome.btnSubMenuBodegaIngresoRecibirOC.click();
                MetodosGenericos.esperar(2);
            } else {
                Assertions.fail("no se pudo interacturar con el btn subMenuPM");
            }
        } catch (Exception e) {
            log.error("No se pudo realizar la administracion de pedido de materiales " + e);
        }
    }

    public void recepcionOrdenDeCompra(String nOC){
        MetodosGenericos.esperarPaginaCargada();
        MetodosGenericos.volverAVentanaPrincipal();
        try {
            MetodosGenericos.esperar(5);
            MetodosGenericos.cambiarIFrame("ventana");
            boolean visualizarNombreOC = MetodosGenericos.visualizarObjeto(pageElements.inputNombreOC,10);
            if (visualizarNombreOC) {
                MetodosGenericos.esperar(2);
                pageElements.inputNombreOC.sendKeys(nOC);
                pageElements.btnBuscarOrdenCompra.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.crearElemento(By.xpath("(//td[contains(text(),\""+nOC+"\")]//following-sibling::td[text()=\"Sin Recepciones\"]//following-sibling::td//descendant::a[@title=\"Recibir Recursos\"])[1]")).click();
                MetodosGenericos.esperar(3);
            } else {
                Assertions.fail("No se pudo interactuar con el botón Buscar Orden de Compra");
            }
        }catch (Exception e){
            log.error("No se pudo modificar la Orden de Compra " + e);
        }
    }

    public void completarCamposyConfirmar(String nTrasnporte, String cantidad){
        MetodosGenericos.esperarPaginaCargada();
        try {
            boolean visualizartitulo = MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//span[contains(text(),\"Ingreso por Orden de Compra\")]")),10);
            if (visualizartitulo) {
                MetodosGenericos.volverAVentanaPrincipal();
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.esperar(2);
                pageElements.inputNroDocTransporte.sendKeys(nTrasnporte);
                pageElements.inputCantidadRecibida.clear();
                MetodosGenericos.esperar(2);
                MetodosGenericos.volverAVentanaPrincipal();
                MetodosGenericos.cerrarPopUp(pageElements.btnCerrarPop, "qa");
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.esperar(2);
                pageElements.inputCantidadRecibida.sendKeys(cantidad);
                pageElements.btnConfirmarRecepcion.click();
                MetodosGenericos.interactuarAlerta(true);
                MetodosGenericos.volverAVentanaPrincipal();
                MetodosGenericos.esperar(5);
            } else {
                Assertions.fail("No se pudo interactuar con el elemento");
            }
        }catch (Exception e){
            log.error("No se pudo confirmar la recepción " + e);
        }
    }

}
