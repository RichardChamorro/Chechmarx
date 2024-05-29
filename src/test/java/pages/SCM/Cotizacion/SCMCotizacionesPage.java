package pages.SCM.Cotizacion;

import driverConfig.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Home.SCMHomeLocators;
import pages.SCM.PedidoMateriales.SCMPedidoMaterialesPage;
import util.JsonDataProcessor;
import util.MetodosGenericos;

public class SCMCotizacionesPage {

    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMPedidoMaterialesPage.class);

    private SCMCotizacionesLocators pageElements;
    public SCMHomeLocators pageElementsHome;

    public SCMCotizacionesPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMCotizacionesLocators.class);
        pageElementsHome = PageFactory.initElements(this.driver, SCMHomeLocators.class);

    }

    public void ingresoConsultaCotizaciones(String cotizacion){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(10);
            boolean visualizarBtnSubMenuCotizaciones = MetodosGenericos.visualizarObjeto(pageElementsHome.btnSubMenuCotizaciones, 90);
            if (visualizarBtnSubMenuCotizaciones) {
                pageElementsHome.btnSubMenuCotizaciones.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.btnSubMenuConsulta.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.esperar(2);
                pageElements.inputNombreCotizacion.sendKeys(cotizacion);
                pageElements.btnBuscarCotizacion.click();
                System.out.println("llegue " + "//td[text()=\"" + cotizacion + "\"]//following-sibling::td[text()=\"COT Guardada\"]");
                MetodosGenericos.esperar(5);
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td[text()=\"COT Guardada\"]")), 30));
            }
            else {
                Assertions.fail("No se pudo interactuar con el botón Consultar estado de cotizacion");
            }
        }catch (Exception e){
            Assertions.fail("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
            log.error("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
        }

    }

    public void modificarCotizacion(String cotizacion, String proveedor){
        MetodosGenericos.esperarPaginaCargada();
        try {
            boolean visualizarBtnEditarCotizacion = MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td//descendant::a[@title=\"Editar Cotización\"]")), 90);
            if (visualizarBtnEditarCotizacion) {
                MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td//descendant::a[@title=\"Editar Cotización\"]")).click();
                MetodosGenericos.esperar(3);
                MetodosGenericos.volverAVentanaPrincipal();
                MetodosGenericos.cambiarIFrame("ventana");
                MetodosGenericos.esperar(5);
                MetodosGenericos.visualizarObjeto(pageElements.btnFechaCierre,90);
                pageElements.btnFechaCierre.sendKeys(MetodosGenericos.calcularFechaFutura(10));
                pageElements.btnFechaAdjudicacion.sendKeys(MetodosGenericos.calcularFechaFutura(15));
                } else {
                Assertions.fail("No se pudo interactuar con el botón Consultar estado de pedido");
                }
        }catch (Exception e){
            log.error("No se pudo modificar la cotizacion " + e);
        }
    }

    public void envioCotizacion(String cotizacion, String proveedor){
        MetodosGenericos.esperarPaginaCargada();
        try {
            boolean visualizarBtnInvitarProv = MetodosGenericos.visualizarObjeto(pageElements.btnInvitarProv, 90);
            if (visualizarBtnInvitarProv ) {
                pageElements.btnInvitarProv.click();
                MetodosGenericos.esperar(3);
                pageElements.btnNombreProveedor.click();
                pageElements.inputNombreProveedor.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/cotizacionPM_Data.json", proveedor));
                MetodosGenericos.esperar(5);
                pageElements.btnBuscarProveedor.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.crearElemento(By.xpath( "//input[contains(@id,\""+JsonDataProcessor.getJsonValue("src/test/data/SCM/cotizacionPM_Data.json", proveedor)+"\")]")).click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.visualizarObjeto(pageElements.btnAgregarProveedor,30);
                pageElements.btnAgregarProveedor.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.visualizarObjeto(pageElements.btnFechaCierre,90);
                pageElements.btnFechaCierre.sendKeys(MetodosGenericos.calcularFechaFutura(10));
                pageElements.btnFechaAdjudicacion.sendKeys(MetodosGenericos.calcularFechaFutura(15));
                pageElements.btnVerificarCotizacion.click();
                MetodosGenericos.esperar(5);
                pageElements.btnEnviarCotizacion.click();
                MetodosGenericos.interactuarAlerta(true);
                MetodosGenericos.esperar(5);
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td[text()=\"COT Abierta\"]")), 30));
            } else {
                Assertions.fail("No se pudo interactuar con el botón Consultar estado de pedido");
            }
        }catch (Exception e){
            log.error("No se pudo modificar la cotizacion " + e);
        }
    }

    public void verificoOfertasCotizaciones(String cotizacion){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(5);
            boolean visualizarBtnSubMenuCotizaciones = MetodosGenericos.visualizarObjeto(pageElementsHome.btnSubMenuCotizaciones, 90);
            if (visualizarBtnSubMenuCotizaciones) {
                pageElementsHome.btnSubMenuCotizaciones.click();
                MetodosGenericos.esperar(5);
                pageElementsHome.btnSubMenuConsulta.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.cambiarIFrame("ventana");
                pageElements.inputNombreCotizacion.sendKeys(cotizacion);
                pageElements.btnBuscarCotizacion.click();
                MetodosGenericos.esperar(5);
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td[text()=\"COT Abierta\"]")), 30));
                int nOferta = Integer.parseInt(MetodosGenericos.accionGetText(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td[@class=\"ofertaLabel\"]"))));
                if (nOferta>=1){
                    MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td//following-sibling::a[@title=\"Ver Ofertas\"]")).click();
                }
                else{
                    Assertions.fail("No se encontraron ofertas para cotizacion");
                }
            }
            else {
                Assertions.fail("No se pudo interactuar con el botón Consultar estado de cotizacion");
            }
        }catch (Exception e){
            Assertions.fail("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
            log.error("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
        }

    }

    public void aceptoOfertasCotizaciones(String cotizacion){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(5);
            boolean visualizarTxtTituloCotizacion = MetodosGenericos.visualizarObjeto(pageElements.txtTituloCotizacion, 90);
            if (visualizarTxtTituloCotizacion) {
                pageElements.btnOfertaCotizacion.click();
                MetodosGenericos.esperar(2);
                pageElements.btnCompararOferta.click();
                MetodosGenericos.esperar(2);
                pageElements.btnOfertaMejorPrecio.click();
                MetodosGenericos.esperar(5);
                pageElements.btnSeleccionarOferta.click();
                MetodosGenericos.esperar(5);
                pageElements.btnAgregarCarro.click();
                MetodosGenericos.esperar(5);
                pageElements.btnComprar.click();
                MetodosGenericos.esperar(5);
                pageElements.btnGenerarComprar.click();
            }
            else {
                Assertions.fail("No se pudo interactuar con el botón Consultar estado de cotizacion");
            }
        }catch (Exception e){
            Assertions.fail("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
            log.error("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
        }
    }

    public void verificarOrdenCompra(String cotizacion){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(10);
            boolean visualizarBtnEnviarOC = MetodosGenericos.visualizarObjeto(pageElements.btnVerificarOC, 30);
            if (visualizarBtnEnviarOC) {
                pageElements.btnVerificarOC.click();
                MetodosGenericos.esperar(2);
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(pageElements.txtOcVerificada,180));
                MetodosGenericos.esperar(2);
                pageElements.btnEnviarOC.click();
                MetodosGenericos.esperar(5);
                pageElements.btnGuardarOC.click();
                MetodosGenericos.esperar(5);
                MetodosGenericos.volverAVentanaPrincipal();
                pageElementsHome.btnSubMenuCotizaciones.click();
                MetodosGenericos.esperar(2);
                pageElementsHome.btnSubMenuConsulta.click();
                MetodosGenericos.esperar(2);
                MetodosGenericos.cambiarIFrame("ventana");
                pageElements.inputNombreCotizacion.sendKeys(cotizacion);
                pageElements.btnBuscarCotizacion.click();
                System.out.println("llegue " + "//td[text()=\"" + cotizacion + "\"]//following-sibling::td[text()=\"COT Enviada a Compra\"]");
                MetodosGenericos.esperar(5);
                Assertions.assertTrue(MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//td[text()=\"" + cotizacion + "\"]//following-sibling::td[text()=\"COT Enviada a Compra\"]")), 30));

            }
            else {
                Assertions.fail("No se pudo interactuar con el botón Consultar estado de cotizacion");
            }
        }catch (Exception e){
            Assertions.fail("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
            log.error("No se pudo consultar la cotizacion creada: " + cotizacion +  " error: " + e);
        }
    }


    public void crearCotizacion(String nCotizacion){
        try {
            boolean visualizarBtnSubMenuCotizaciones = MetodosGenericos.visualizarObjeto(pageElementsHome.btnSubMenuCotizaciones, 90);
            if (visualizarBtnSubMenuCotizaciones) {
            pageElementsHome.btnSubMenuCotizaciones.click();
            MetodosGenericos.esperar(2);
            pageElementsHome.btnSubMenuCrearCot.click();
            MetodosGenericos.cambiarIFrame("ventana");
            MetodosGenericos.esperar(3);
            pageElements.inputNombreCot.sendKeys(nCotizacion);
            pageElements.btnFechaCierre.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/cotizacionPM_Data.json","fechaCierre"));
            pageElements.btnFechaAdjudicacion.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/cotizacionPM_Data.json","fechaAdjudicacion"));
            pageElements.btnLupaProd.click();
            MetodosGenericos.esperar(3);
            MetodosGenericos.cambiarVentana(1);
            pageElements.inputDescripcionProd.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/pedidoMateriales_Data.json","agregar","filtroDescripcion"));
            pageElements.btnBuscarProd.click();
            MetodosGenericos.crearElemento(By.xpath("(//a[contains(@href,\""+JsonDataProcessor.getJsonValue("src/test/data/SCM/pedidoMateriales_Data.json", "agregar", "filtroDescripcion")+"\")])[1]")).click();
            MetodosGenericos.esperar(5);
            MetodosGenericos.cambiarVentana(0);
            MetodosGenericos.cambiarIFrame("ventana");
            pageElements.cantidadProd.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/pedidoMateriales_Data.json","agregar","cantidad"));
            pageElements.glosaProd.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/pedidoMateriales_Data.json","agregar","glosa"));
            pageElements.fechaEntrega.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/cotizacionPM_Data.json","fechaEntrega"));
            pageElements.btnCuentaCosto.click();
            MetodosGenericos.esperar(15);
            MetodosGenericos.cambiarVentana(1);
            MetodosGenericos.esperar(2);
            pageElements.btnBuscarCuentaCosto.click();
            MetodosGenericos.esperar(2);
            pageElements.checkCosto28.click();
            pageElements.checkCosto555.click();
            pageElements.btnSeleccionar.click();
            pageElements.inputPorcentaje1.clear();
            pageElements.inputPorcentaje1.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/pedidoMateriales_Data.json","agregar","porcentaje1"));
            pageElements.inputPorcentaje2.clear();
            pageElements.inputPorcentaje2.sendKeys(JsonDataProcessor.getJsonValue("src/test/data/SCM/pedidoMateriales_Data.json","agregar","porcentaje2"));
            pageElements.btnGuardarPorcentaje.click();
            pageElements.btnCerrar.click();
            MetodosGenericos.cambiarVentana(0);
            MetodosGenericos.cambiarIFrame("ventana");
            pageElements.btnAgregarProd.click();
            MetodosGenericos.esperar(5);
            pageElements.btnGuardarCrearCOT.click();
            }
            else {
                Assertions.fail("No se pudo interactuar con el botón Crear cotizacion");
            }
        }catch (Exception e){
            log.error("No se pudo interactuar con el botón Crear cotizacion");
        }
        }
}








