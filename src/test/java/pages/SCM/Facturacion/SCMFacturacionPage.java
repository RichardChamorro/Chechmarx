package pages.SCM.Facturacion;

import driverConfig.DriverContext;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Cotizacion.SCMCotizacionesLocators;
import pages.SCM.Home.SCMHomeLocators;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import steps.SCM.SCMAdministradorPedidoMaterialesStep;
import steps.SCM.SCMOrdenCompraStep;
import util.JsonDataProcessor;
import util.MetodosGenericos;

public class SCMFacturacionPage {
    private WebDriver driver;
    String dataJson = "src/test/data/SCM/cotizacionPM_Data.json";
    private static final Logger log = LoggerFactory.getLogger(SCMFacturacionPage.class);

    private SCMFacturacionLocators pageElements;
    public SCMHomeLocators pageElementsHome;

    public SCMFacturacionPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMFacturacionLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);

    }

    public void IngresoFacturacion(String nFactura){
        MetodosGenericos.esperarPaginaCargada();
        MetodosGenericos.volverAVentanaPrincipal();
        MetodosGenericos.esperar(10);
        try {
            boolean visualizarbtnFacturacion = MetodosGenericos.visualizarObjeto(pageElementsHome.btnFacturacion, 30);
            if (visualizarbtnFacturacion) {
                MetodosGenericos.mouseHoverElement(pageElementsHome.btnFacturacion);
                MetodosGenericos.esperar(2);
                pageElementsHome.btnSubMenuFacturacionIngresoFactura.click();
                MetodosGenericos.esperar(3);
                MetodosGenericos.cambiarIFrame("ventana");
                pageElements.btnProveedor.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.cambiarVentana(1);
                pageElements.inputProveedor.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/cotizacionPM_Data.json","proveedor"));
                pageElements.btnBuscarProveedor.click();
                MetodosGenericos.esperar(2);
                pageElements.selecProveedor.click();
                MetodosGenericos.cambiarVentana(0);
                MetodosGenericos.cambiarIFrame("ventana");
                pageElements.inputNumFactura.sendKeys(nFactura);
                pageElements.inputFolio.sendKeys(nFactura);
                pageElements.inputFechaEmision.sendKeys(MetodosGenericos.obtenerFechaActual());
            } else {
                Assertions.fail("no se pudo interacturar con el btn subMenuPM");
            }
        } catch (Exception e) {
            log.error("No se pudo realizar la administracion de pedido de materiales " + e);
        }

    }

    public void IngresoMontosFactura(String nRecepcion){
        MetodosGenericos.esperarPaginaCargada();
        int cantidadRecepcion = Integer.parseInt(nRecepcion);
        //arreglar null
        int valorProducto = (SCMOrdenCompraStep.ocType == null || SCMOrdenCompraStep.ocType.isEmpty())
                ? Integer.parseInt(JsonDataProcessor.getJsonValue(dataJson,"precio")) - Integer.parseInt(JsonDataProcessor.getJsonValue(dataJson,"descuento"))
                : SCMOrdenCompraStep.ocType.equals("oc")
                ? Integer.parseInt(JsonDataProcessor.getJsonValue(dataJson,"precio"))
                : null;
        String montoNeto = String.valueOf(cantidadRecepcion * valorProducto);
        String montoIva = String.valueOf(Math.round((cantidadRecepcion * valorProducto)*0.19));
        try {
            boolean visualizarInputMonto = MetodosGenericos.visualizarObjeto(pageElements.inputMontoNeto, 90);
            if (visualizarInputMonto) {
                pageElements.inputMontoNeto.sendKeys(montoNeto);
                MetodosGenericos.esperar(1);
                pageElements.inputIva.sendKeys(montoIva);
                pageElements.btnAceptarFacturacion.click();
            } else {
                Assertions.fail("no se pudo interacturar con el btn subMenuPM");
            }
        } catch (Exception e) {
            log.error("No se pudo realizar la administracion de pedido de materiales " + e);
        }

    }

    public void AgregarDocumentoTransporte(String nTransporte){
        MetodosGenericos.esperarPaginaCargada();
        try {
            boolean visualizarInputTransporte = MetodosGenericos.visualizarObjeto(pageElements.inputNumTransporte, 90);
            if (visualizarInputTransporte) {
                pageElements.inputNumTransporte.sendKeys(nTransporte);
                MetodosGenericos.esperar(1);
                pageElements.btnBuscarFactura.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.volverAVentanaPrincipal();
                MetodosGenericos.cerrarPopUp(pageElements.btnCerrarPop, "qa");
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.crearElemento(By.xpath("//a[text()=\""+nTransporte+"\"]//ancestor::td[@class=\"celdascampos\"]//following-sibling::td//descendant::input")).click();
                MetodosGenericos.esperar(2);
                pageElements.btnAsociarFacturacion.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.interactuarAlerta(false);
                MetodosGenericos.esperar(5);
                pageElements.btnAceptarAsociarFacturacion.click();
                MetodosGenericos.esperar(5);
                pageElements.btnAjusteSaldoAsociar.click();
                MetodosGenericos.esperar(5);
                pageElements.inputMotivoAjuste.sendKeys("Ajuste Prueba Automatizada");
                MetodosGenericos.esperar(2);
                pageElements.btnGuardarAjuste.click();
                MetodosGenericos.esperar(2);
                pageElements.btnVolver.click();
                MetodosGenericos.esperar(5);
                pageElements.btnAceptarFacturacion.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.scrollElement(pageElements.btnValidarEnvio);
                pageElements.btnValidarEnvio.click();
                MetodosGenericos.esperar(7);
            } else {
                Assertions.fail("no se pudo interacturar con el btn subMenuPM");
            }
        } catch (Exception e) {
            log.error("No se pudo realizar la administracion de pedido de materiales " + e);
        }

    }

    public void validarFactura(String nFactura){
        MetodosGenericos.esperarPaginaCargada();
        MetodosGenericos.esperar(10);
        MetodosGenericos.volverAVentanaPrincipal();
        MetodosGenericos.cambiarIFrame("ventana");
        try {
            boolean visualizarFormBusquedaFactura = MetodosGenericos.visualizarObjeto(pageElements.formBusquedaFactura, 90);
            if (visualizarFormBusquedaFactura) {
                pageElements.inputNumFactura.sendKeys(nFactura);
                MetodosGenericos.esperar(1);
                pageElements.btnBuscarFactura.click();
                MetodosGenericos.esperar(5);
                Assertions.assertEquals("Aprobada", MetodosGenericos.crearElemento(By.xpath("//td[text()=\""+nFactura+"\"]//following-sibling::td[@id=\"gridResultados_tccell0_17\"]//descendant::span")).getText());
                MetodosGenericos.esperar(2);
                Assertions.assertEquals("Totalmente Asociada", MetodosGenericos.crearElemento(By.xpath("//td[text()=\""+nFactura+"\"]//following-sibling::td[@id=\"gridResultados_tccell0_18\"]//descendant::span")).getText());
            } else {
                Assertions.fail("no se pudo interacturar con el btn subMenuPM");
            }
        } catch (Exception e) {
            log.error("No se pudo realizar la administracion de pedido de materiales " + e);
        }

    }



}







