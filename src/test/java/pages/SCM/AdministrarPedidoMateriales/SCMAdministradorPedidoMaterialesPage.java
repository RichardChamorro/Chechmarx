package pages.SCM.AdministrarPedidoMateriales;

import driverConfig.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Home.SCMHomeLocators;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import util.JsonDataProcessor;
import util.MetodosGenericos;

public class SCMAdministradorPedidoMaterialesPage {

    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMPedidoMaterialesPage.class);

    private SCMAdministradorPedidoMaterialesLocators pageElements;
    public SCMHomeLocators pageElementsHome;

    public SCMAdministradorPedidoMaterialesPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMAdministradorPedidoMaterialesLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);
    }

    public void ingresoAdmdePedidos(String pedido,String cotizacion){
        try{
            MetodosGenericos.esperarPaginaCargada();
            boolean visualizarBtnSubMenuPM = MetodosGenericos.visualizarObjeto(pageElementsHome.subMenuPM, 90);
            if (visualizarBtnSubMenuPM) {
                pageElementsHome.subMenuPM.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.btnsubMenuPMAdministrar.click();
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.visualizarObjeto(pageElements.inputNombrePedido, 30);
                pageElements.inputNombrePedido.sendKeys(pedido);
                MetodosGenericos.esperar(2);
                pageElements.selectDesignacion.click();
                pageElements.selectDesignacion.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/administracionPM_Data.json", "opcion"));
                pageElements.btnBuscarPedido.click();
                MetodosGenericos.crearElemento(By.xpath("//td[text()=\""+pedido+"\"]//following-sibling::td//descendant::input")).click();
                pageElements.btnCotizar.click();
                MetodosGenericos.volverAVentanaPrincipal();
                MetodosGenericos.esperar(5);
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.esperar(5);
                pageElements.inputNombreCotizacion.sendKeys(cotizacion);
                MetodosGenericos.esperar(7);
                pageElements.btnGenerarCotizacion.click();
                MetodosGenericos.esperar(15);
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

    public void ingresoAdmdePedidosOC(String pedido){
        MetodosGenericos.esperarPaginaCargada();
        try{
            MetodosGenericos.volverAVentanaPrincipal();
            boolean visualizarBtnSubMenuPM = MetodosGenericos.visualizarObjeto(pageElementsHome.subMenuPM, 90);
            if (visualizarBtnSubMenuPM) {
                pageElementsHome.subMenuPM.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.btnsubMenuPMAdministrar.click();
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.visualizarObjeto(pageElements.inputNombrePedido, 30);
                pageElements.inputNombrePedido.sendKeys(pedido);
                MetodosGenericos.esperar(2);
                pageElements.selectDesignacion.click();
                pageElements.selectDesignacion.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/administracionPM_Data.json", "opcion"));
                pageElements.btnBuscarPedido.click();
                MetodosGenericos.crearElemento(By.xpath("//td[text()=\""+pedido+"\"]//following-sibling::td//descendant::input")).click();
                pageElements.btnComprar.click();
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

    public void IngresoAdministracionPedidodeMateriales() {
        try {
            boolean visualizarbtnsubMenuPMAdministrar = MetodosGenericos.visualizarObjeto(pageElementsHome.btnsubMenuPMAdministrar, 30);
            if (visualizarbtnsubMenuPMAdministrar) {
                pageElementsHome.subMenuPM.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.btnsubMenuPMAdministrar.click();
                MetodosGenericos.cambiarIFrame("ventana");


            } else {
                Assertions.fail("no se pudo interacturar con el btn subMenuPM");
            }
        } catch (Exception e) {
            log.error("No se pudo realizar la administracion de pedido de materiales " + e);
        }
    }


}
