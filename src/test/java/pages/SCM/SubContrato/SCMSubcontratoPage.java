package pages.SCM.SubContrato;

import driverConfig.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Bodega.SCMBodegaLocators;
import pages.SCM.Bodega.SCMBodegaPage;
import pages.SCM.Home.SCMHomeLocators;
import util.JsonDataProcessor;
import util.MetodosGenericos;

public class SCMSubcontratoPage {

    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMSubcontratoPage.class);

    public SCMSubContratoLocators pageElements;

    public SCMHomeLocators pageElementsHome;

    public SCMSubcontratoPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMSubContratoLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);
    }


    public void ingresoCrearSubContrato(){
        MetodosGenericos.esperarPaginaCargada();
    try{
        boolean visualizarBtnSubMenuSC = MetodosGenericos.visualizarObjeto(pageElementsHome.btnSubContratos, 90);
        if (visualizarBtnSubMenuSC){
            MetodosGenericos.esperar(3);
            pageElementsHome.btnSubContratos.click();
            MetodosGenericos.esperar(2);
            pageElementsHome.btnSubMenuCrearSubContrato.click();
            MetodosGenericos.esperar(3);
        } else {
            Assertions.fail("no se pudo interacturar con el btn subMenuSubContrato");
        }
    } catch (Exception e) {
        log.error("No se pudo realizar el Sub Contrato" + e);
    }
}

    public void completarDatosSubContrato() {
        try {
            boolean visualizarBtnSubMenuSC = MetodosGenericos.visualizarObjeto(pageElementsHome.btnSubContratos, 90);
            if (visualizarBtnSubMenuSC) {
            MetodosGenericos.cambiarIFrame("ventana");
            MetodosGenericos.esperar(2);
            pageElements.inputNombreSubContrato.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/subcontrato_Data.json", "data1", "nombreSubcontrato"));
            pageElements.inputNumSubContrato.sendKeys("12312");
            pageElements.inputPeriodicidad.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/subcontrato_Data.json", "data1", "periocidad"));
            pageElements.inputFechaFirma.sendKeys(MetodosGenericos.obtenerFechaActual());
            pageElements.inputFechaInicio.sendKeys(MetodosGenericos.obtenerFechaActual());
            pageElements.inputFechaTermino.sendKeys(MetodosGenericos.calcularFechaFutura(30));
            pageElements.inputComentarios.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/subcontrato_Data.json", "data1", "comentario"));
            } else {
        Assertions.fail("no se pudo interacturar con completar los datos del SubContrato");
    }
    } catch (Exception e) {
        log.error("No se pudo realizar el Sub Contrato" + e);
        }
    }

    public void seleccionSubContratistayRepresentante(){
        try {
            boolean visualizarBtnSubMenuSC = MetodosGenericos.visualizarObjeto(pageElementsHome.btnSubContratos, 90);
            if (visualizarBtnSubMenuSC) {
            pageElements.btnProveedor.click();
            MetodosGenericos.esperar(3);
            MetodosGenericos.cambiarVentana(1);
            pageElements.inputProveedor.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/subcontrato_Data.json","data1","nombreProveedor"));
            pageElements.btnBuscarProv.click();
            pageElements.btnSelProveedor.click();
            MetodosGenericos.cambiarVentana(0);
            MetodosGenericos.cambiarIFrame("ventana");
            pageElements.selectSucursal.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/subcontrato_Data.json","data1","sucursal"));
            pageElements.btnListarRepre.click();
            MetodosGenericos.cambiarVentana(1);
            MetodosGenericos.crearElemento(By.xpath("//td[text()='16121876-6']//preceding-sibling::td//descendant::input")).click();
            pageElements.btnGuardarRepre.click();
            MetodosGenericos.cambiarVentana(0);
            MetodosGenericos.cambiarIFrame("ventana");
            pageElements.selectEmitirFactura.click();
    } else {
        Assertions.fail("no se pudo interacturar con completar los datos del SubContrato");
    }
} catch (Exception e) {
        log.error("No se pudo realizar el Sub Contrato" + e);
        }
    }

    public void anticipoyRetencion(){
        try {
            boolean visualizarBtnSubMenuSC = MetodosGenericos.visualizarObjeto(pageElementsHome.btnSubContratos, 90);
            if (visualizarBtnSubMenuSC) {
                pageElements.inputAnticipo.sendKeys("1000");
                pageElements.inputMontoRetencion.sendKeys("5");
        } else {
        Assertions.fail("no se pudo interacturar con completar los datos del SubContrato");
        }
        } catch (Exception e) {
        log.error("No se pudo realizar el Sub Contrato" + e);
        }
    }

    public void ingresoProductosMaestro(){
        try {
            boolean visualizarBtnMaestro = MetodosGenericos.visualizarObjeto(pageElements.btnIngMaestro, 90);
            if (visualizarBtnMaestro) {
            pageElements.btnIngMaestro.click();
            MetodosGenericos.cambiarVentana(1);
            pageElements.inputCodigoProd.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/productos_Data.json","producto"));
            pageElements.btnBuscarProd.click();

            MetodosGenericos.esperar(1000);


    } else {
        Assertions.fail("no se pudo interacturar con completar los datos del SubContrato");
        }
    } catch (Exception e) {
        log.error("No se pudo realizar el Sub Contrato" + e);
        }


    }








}




