package pages.SCM.Cotizacion;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCMCotizacionesLocators {

    @FindBy (xpath = "//*[@id='txtNombreCotizacion']")
    public
    WebElement inputNombreCotizacion;
    @FindBy(xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarCotizacion;

    @FindBy(xpath = "\"//td[text()=\\\"\" + cotizacion + \"\\\"]//following-sibling::td[text()=\\\"COT Guardada\\\"]\"")
    WebElement validarCotizacion;


    @FindBy (xpath = "//input[@id=\"ctrFechaCierre_I\"]")
    WebElement btnFechaCierre;

    @FindBy (xpath = "//input[@id=\"ctrFechaDecision_I\"]")
    WebElement btnFechaAdjudicacion;

    @FindBy(xpath = "//a[@id='btnInvitar']")
    WebElement btnInvitarProv;

    @FindBy(xpath = "//span[contains(text(),'Escribe el nombre, RUT o palabra clave')]")
    WebElement btnNombreProveedor;

    @FindBy(xpath = "(//input[@class=\"form-control\"])[1]")
    WebElement inputNombreProveedor;

    @FindBy(xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarProveedor;


    @FindBy(xpath = "//*[@id='lnkAgregar']")
    WebElement btnAgregarProveedor;

    @FindBy(xpath = "//a[@id='btnEnviarCotizacion']")
    WebElement btnVerificarCotizacion;

    @FindBy(xpath = "//a[@id='btnEnviar']")
    WebElement btnEnviarCotizacion;

    @FindBy(xpath = "//a[@id='addEmailContacto']")
    WebElement btnAgregarMailContacto;

    @FindBy(xpath = "//span[@id=\"lblTotuloCotizacion\"]")
    WebElement txtTituloCotizacion;

    @FindBy(xpath = "//input[contains(@value,\"Proveedor PRUEBA Selenium\")]")
    WebElement btnOfertaCotizacion;

    @FindBy(xpath = "//input[@name=\"btnComparativas\"]")
    WebElement btnCompararOferta;

    @FindBy(xpath = "//input[@id=\"chkMejorPrecio\"]")
    WebElement btnOfertaMejorPrecio;

    @FindBy(xpath = "//input[@id=\"chkMejorDespacho\"]")
    WebElement btnOfertaMejorTiempoDespacho;
    @FindBy(xpath = "//span[@class=\"icon\"]")
    WebElement btnSeleccionarOferta;

    @FindBy(xpath = "//a[@id=\"iralcarro\"]")
    WebElement btnAgregarCarro;

    @FindBy(xpath = "//a[@id=\"btnComprar\"]")
    WebElement btnComprar;

    @FindBy(xpath = "//button[@id=\"GenerarCompra\"]")
    WebElement btnGenerarComprar;

    @FindBy(xpath = "//a[@id='btnEnviar']")
    WebElement btnVerificarOC;

    @FindBy(xpath = "//div[@class=\"exito\"]")
    WebElement txtOcVerificada;

    @FindBy(xpath = "//input[@name=\"btnEnviarOC\"]")
    WebElement btnEnviarOC;

    @FindBy(xpath = "//button[@id=\"btnGuardarJs\"]")
    WebElement btnGuardarOC;

    @FindBy (xpath = "//input[@id='txtNomCZ']")
    WebElement inputNombreCot;

    @FindBy(xpath = "//a[@id='ctrLineaCotizacion_lnkCodigo']")
    WebElement btnLupaProd;

    @FindBy(xpath = "//input[@id='txtDescripcion']")
    WebElement inputDescripcionProd;

    @FindBy(xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarProd;

    @FindBy(xpath = "//input[@id='ctrLineaCotizacion_txtLINCantidad']")
    WebElement cantidadProd;

    @FindBy(xpath = "//textarea[@id='ctrLineaCotizacion_txtLINGlosa']")
    WebElement glosaProd;

    @FindBy(xpath = "//input[@id='ctrLineaCotizacion_txtLINFechaEntrega']")
    WebElement fechaEntrega;

    @FindBy(xpath = "//a[@id='ctrLineaCotizacion_lnkDistribucion']")
    WebElement btnCuentaCosto;

    @FindBy(xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarCuentaCosto;

    @FindBy(xpath = "//input[@id='ctrAcumulador_idccosto_item_28']")
    WebElement checkCosto28;

    @FindBy(xpath = "//input[@id='ctrAcumulador_idccosto_item_555']")
    WebElement checkCosto555;

    @FindBy(xpath = "//a[@id='btnSeleccionar']")
    WebElement btnSeleccionar;

    @FindBy(xpath = "//input[@id='valor_1']")
    WebElement inputPorcentaje1;

    @FindBy(xpath = "//input[@id='valor_2']")
    WebElement inputPorcentaje2;

    @FindBy(xpath = "//a[@id='btnGrabar']")
    WebElement btnGuardarPorcentaje;

    @FindBy(xpath = "//a[@id='lnkCerrar']")
    WebElement btnCerrar;

    @FindBy(xpath = "//a[@class=\"linkazul\" and text()=\"Guardar\"]")
    WebElement btnGuardarCrearCOT;







    @FindBy (xpath = "//a[@id='ctrLineaCotizacion_btnAgregarLinea']")
    WebElement btnAgregarProd;

    @FindBy(xpath = "//a[@id='ctrLineaCotizacion_lnkMaestro']")
    WebElement btnMaestroCot;































}
