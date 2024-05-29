package pages.SCM.PedidoMateriales;

import driverConfig.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.AdministrarPedidoMateriales.SCMAdministradorPedidoMaterialesLocators;
import pages.SCM.Cotizacion.SCMCotizacionesLocators;
import pages.SCM.Home.SCMHomeLocators;
import util.JsonDataProcessor;
import util.MetodosGenericos;


public class SCMPedidoMaterialesPage {
    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMPedidoMaterialesPage.class);

    private SCMPedidoMaterialesLocators pageElements;
    public SCMHomeLocators pageElementsHome;
    public SCMAdministradorPedidoMaterialesLocators pageElementsAdm;
    public SCMCotizacionesLocators pageElementsCot;

    public SCMPedidoMaterialesPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMPedidoMaterialesLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);
        pageElementsAdm = PageFactory.initElements(this.driver, SCMAdministradorPedidoMaterialesLocators.class);
        pageElementsCot = PageFactory.initElements(this.driver, SCMCotizacionesLocators.class);
    }

    String dataJson = "src/test/data/SCM/pedidoMateriales_Data.json";

    public void ingresoCrearPedidodeMateriales(String nProd, String pedido){
        MetodosGenericos.esperarPaginaCargada();
        MetodosGenericos.esperar(10);
        try{
        boolean visualizarBtnSubMenuPM = MetodosGenericos.visualizarObjeto(pageElementsHome.subMenuPM, 90);
        if (visualizarBtnSubMenuPM){
            MetodosGenericos.esperar(5);
            pageElementsHome.subMenuPM.click();
            MetodosGenericos.esperar(2);
            pageElementsHome.subMenuPMCrear.click();
            MetodosGenericos.cambiarIFrame("ventana");
            MetodosGenericos.visualizarObjeto(pageElements.inputNombrePedido, 30);
            pageElements.inputNombrePedido.sendKeys(pedido);
            pageElements.inputNotas.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "notasPedido"));
            pageElements.btnLupaCodigo.click();
            MetodosGenericos.esperar(5);
            MetodosGenericos.cambiarVentana(1);
            pageElements.inputDescripcion.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "filtroDescripcion"));
            pageElements.btnBuscar.click();
            WebElement primerResultadoBusqueda = driver.findElement(By.xpath("(//a[contains(@href,\""+JsonDataProcessor.getJsonValue(dataJson, "agregar", "filtroDescripcion")+"\")])[1]"));
            MetodosGenericos.esperar(5);
            primerResultadoBusqueda.click();
            MetodosGenericos.esperar(5);
            MetodosGenericos.cambiarVentana(0);
            MetodosGenericos.cambiarIFrame("ventana");
        }
        else {
            Assertions.fail("no se pudo interacturar con el btn subMenuPM");
        }}
        catch (Exception e)
        {
            log.error("No se pudo realizar la creación de pedido de materiales " + e);
        }
    }

    public void ingresoCrearPedidodeMaterialesMaestro(String nProd, String pedido){
        MetodosGenericos.esperarPaginaCargada();
        try{
            boolean visualizarBtnSubMenuPM = MetodosGenericos.visualizarObjeto(pageElementsHome.subMenuPM, 90);
            if (visualizarBtnSubMenuPM){
                MetodosGenericos.esperar(5);
                pageElementsHome.subMenuPM.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.subMenuPMCrear.click();
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.visualizarObjeto(pageElements.inputNombrePedido, 30);
                pageElements.inputNombrePedido.sendKeys(pedido);
                pageElements.inputNotas.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "maestro", "notasPedido"));
                pageElements.btnMaestro.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.cambiarVentana(1);
                for (int i = 1; i <= Integer.parseInt(nProd); i++) {
                    if(i>1){
                        pageElements.inputDescripcion.clear();
                    }
                    pageElements.inputDescripcion.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "maestro", "filtroDescripcion"+i));
                    MetodosGenericos.esperar(1);
                    pageElements.btnLnkBuscar.click();
                    MetodosGenericos.crearElemento(By.xpath("//td[contains(text(),\""+JsonDataProcessor.getJsonValue(dataJson, "maestro", "filtroDescripcion"+i)+"\")]//following-sibling::td//descendant::input")).click();
                    MetodosGenericos.esperar(1);
                    pageElements.btnSeleccionar.click();
                    MetodosGenericos.esperar(5);
                    MetodosGenericos.interactuarAlerta(true);
                }
                MetodosGenericos.esperar(5);
                pageElements.btnLnkCerrar.click();
                MetodosGenericos.cambiarVentana(0);
                MetodosGenericos.cambiarIFrame("ventana");
            }
            else {
                Assertions.fail("no se pudo interacturar con el btn subMenuPM");
            }}
        catch (Exception e)
        {
            log.error("No se pudo realizar la creación de pedido de materiales " + e);
        }
    }

    public void agregarDetallePedidoMateriales(String dDespacho){
        MetodosGenericos.esperarPaginaCargada();
        try{
            boolean visualizarInputCantidadProd = MetodosGenericos.visualizarObjeto(pageElements.inputCantidadProd, 90);
            if (visualizarInputCantidadProd) {
                MetodosGenericos.visualizarObjeto(pageElements.inputCantidadProd, 30);
                pageElements.inputCantidadProd.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "cantidad"));
                pageElements.inputGlosa.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "glosa"));
                pageElements.checkDiaDespacho.click();
                pageElements.inputDiaDespacho.sendKeys(dDespacho);
                pageElements.inputComentariosProd.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "comentarios"));
                pageElements.btnDistribuirCuentaCosto.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.cambiarVentana(1);
                pageElements.btnBuscarCuentaCosto.click();
                By cuentaCosto1 = By.xpath("//input[@id=\"ctrAcumulador_idccosto_item_28\"]");
                By cuentaCosto2 = By.xpath("//input[@id=\"ctrAcumulador_idccosto_item_555\"]");
                MetodosGenericos.seleccionarCheckIterativo(cuentaCosto1, cuentaCosto2);
                pageElements.btnSeleccionarDistribucion.click();
                MetodosGenericos.cambiarVentana(1);
                pageElements.inputPorcentajeDistribucion1.clear();
                pageElements.inputPorcentajeDistribucion1.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "porcentaje1"));
                pageElements.inputPorcentajeDistribucion2.clear();
                pageElements.inputPorcentajeDistribucion2.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "porcentaje2"));
                MetodosGenericos.esperar(2);
                pageElements.btnGuardarDistribucion.click();
                MetodosGenericos.esperar(2);
                pageElements.btnCerrarDistribucion.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.cambiarVentana(0);
                MetodosGenericos.cambiarIFrame("ventana");
                pageElements.btnAgregarProd.click();
                MetodosGenericos.esperar(2);
                pageElements.btnGuardarPedido.click();
                MetodosGenericos.volverAVentanaPrincipal();
            }
            else {
                Assertions.fail("No se encontró el elemento para ingresar cantidad de productos");
            }
        }
        catch (Exception e)
        {
            log.error("No se pudo añadir detalles a la creación de pedido de materiales " + e);
        }
    }

    public void consultarEstadoPedido(String pedido, String nLineas){
        MetodosGenericos.esperarPaginaCargada();
        MetodosGenericos.volverAVentanaPrincipal();
        try{
            boolean visualizarBtnSubMenuPM = MetodosGenericos.visualizarObjeto(pageElementsHome.subMenuPM, 180);
            if (visualizarBtnSubMenuPM){
                pageElementsHome.subMenuPM.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.btnsubMenuPMConsultar.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.cambiarIFrame("ventana");
                pageElements.inputNombrePedidoConsultarPedido.sendKeys(pedido);
                pageElements.btnBuscar.click();
                pageElements.tabConsultarEstadoPorPedido.click();
                MetodosGenericos.esperar(5);
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + pedido + "\"]")), 30));
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + pedido + "\"]//following-sibling::td//descendant::span[text()=\""+nLineas+"\"]")), 30));
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + pedido + "\"]//following-sibling::td[text()=\"Pedido Guardado\"]")), 30));
                MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + pedido + "\"]//following-sibling::td//a[@title=\"Editar el pedido\"]")).click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.volverAVentanaPrincipal();
                MetodosGenericos.cerrarPopUp(pageElements.btnCerrarPop, "qa");
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.esperar(2);
                pageElements.btnEnviarPedido.click();
                MetodosGenericos.visualizarObjeto(pageElements.btnEnviar,30);
                pageElements.btnEnviar.click();
                MetodosGenericos.interactuarAlerta(true);
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

    public void agregarDetallePedidoMaterialesMaestro(String dDespacho, String nProd) {
        MetodosGenericos.esperarPaginaCargada();
        try{
            boolean visualizarBtnEditarLineas= MetodosGenericos.visualizarObjeto(pageElements.btnEditarLineas, 90);
            if (visualizarBtnEditarLineas) {
                MetodosGenericos.visualizarObjeto(pageElements.btnEditarLineas, 30);
                pageElements.btnEditarLineas.click();
                MetodosGenericos.esperar(5);
                for (int i = 1; i <= Integer.parseInt(nProd); i++) {
                    MetodosGenericos.crearElemento(By.xpath("//input[@name=\"cnt_"+i+"\"]")).clear();
                    MetodosGenericos.crearElemento(By.xpath("//input[@name=\"cnt_"+i+"\"]")).sendKeys(JsonDataProcessor.getJsonValue(dataJson, "maestro", "cantidad"+i));
                    MetodosGenericos.esperar(1);
                    MetodosGenericos.crearElemento(By.xpath("//input[@name=\"glo_"+i+"\"]")).sendKeys(JsonDataProcessor.getJsonValue(dataJson, "maestro", "glosa"));
                    MetodosGenericos.esperar(1);
                    MetodosGenericos.crearElemento(By.xpath("//input[@name=\"diaDes_"+i+"\"]")).sendKeys( dDespacho);
                    MetodosGenericos.esperar(1);
                    MetodosGenericos.crearElemento(By.xpath("//input[@name=\"dis_"+i+"\"]//following-sibling::a")).click();
                    MetodosGenericos.esperar(5);
                    MetodosGenericos.cambiarVentana(1);
                    pageElements.btnBuscarCuentaCosto.click();
                    By cuentaCosto1 = By.xpath("//input[@id=\"ctrAcumulador_idccosto_item_28\"]");
                    By cuentaCosto2 = By.xpath("//input[@id=\"ctrAcumulador_idccosto_item_555\"]");
                    MetodosGenericos.seleccionarCheckIterativo(cuentaCosto1, cuentaCosto2);
                    pageElements.btnSeleccionarDistribucion.click();
                    MetodosGenericos.cambiarVentana(1);
                    pageElements.inputPorcentajeDistribucion1.clear();
                    pageElements.inputPorcentajeDistribucion1.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "porcentaje1"));
                    pageElements.inputPorcentajeDistribucion2.clear();
                    pageElements.inputPorcentajeDistribucion2.sendKeys(JsonDataProcessor.getJsonValue(dataJson, "agregar", "porcentaje2"));
                    MetodosGenericos.esperar(5);
                    pageElements.btnGuardarDistribucion.click();
                    MetodosGenericos.esperar(2);
                    pageElements.btnCerrarDistribucion.click();
                    MetodosGenericos.esperar(2);
                    MetodosGenericos.cambiarVentana(0);
                    MetodosGenericos.esperar(5);
                    MetodosGenericos.cambiarIFrame("ventana");
                }
                MetodosGenericos.esperar(2);
                pageElements.btnGuardarPedidoMaestro.click();
                pageElements.btnVolver.click();
                MetodosGenericos.volverAVentanaPrincipal();
            }
            else {
                Assertions.fail("No se encontró el elemento para ingresar cantidad de productos");
            }
        }
        catch (Exception e)
        {
            log.error("No se pudo añadir detalles a la creación de pedido de materiales " + e);
        }
    }
}


