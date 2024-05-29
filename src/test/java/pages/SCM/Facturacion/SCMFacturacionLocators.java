package pages.SCM.Facturacion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCMFacturacionLocators {

    @FindBy (xpath = "//div[@id=\"wootric-close\"]")
    WebElement btnCerrarPop;

    @FindBy (xpath = "//*[@id=\"imgRutProveedor\"]")
    WebElement btnProveedor;

    @FindBy (xpath = "//input[@id='txtProveedor']")
    WebElement inputProveedor;

    @FindBy (xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarProveedor;

    @FindBy(xpath = "//a[@title=\"Seleccionar Proveedor\"]")
    WebElement selecProveedor;

    @FindBy(xpath = "//input[@id='txtNumFactura']")
    WebElement inputNumFactura;

    @FindBy(xpath = "//input[@id='txtFolioUnico']")
    WebElement inputFolio;

    @FindBy(xpath = "//input[@id='txtFecEmiFacturaFECHA']")
    WebElement inputFechaEmision;

    @FindBy(xpath = "//input[@id='txtMontoAfecto']")
    WebElement inputMontoNeto;

    @FindBy(xpath = "//input[@id='txtMontoIVA']")
    WebElement inputIva;

    @FindBy (xpath = "//a[@id='btnAceptar1']")
    WebElement btnAceptarFacturacion;

    @FindBy (xpath = "//a[@id='btnAceptar']")
    WebElement btnAceptarAsociarFacturacion;

    @FindBy (xpath = "//a[@id='btnValidar']")
    WebElement btnValidarEnvio;

    @FindBy (xpath = "//input[@id='txtNumTransporte']")
    WebElement inputNumTransporte;

    @FindBy (xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarFactura;

    @FindBy(xpath = "//a[@id='btnAsociar']")
    WebElement btnAsociarFacturacion;

    @FindBy (xpath = "//a[@id='btnAceptar']")
    WebElement btnAceptarAsociacion;

    @FindBy (xpath = "//a[@id='ctrFacturaVista_btnSolAjuste']")
    WebElement btnAjusteSaldoAsociar;

    @FindBy(xpath = "//*[@id='txtMotivo']")
    WebElement inputMotivoAjuste;

    @FindBy(xpath = "//a[@id='btnGuardarAjuste']")
    WebElement btnGuardarAjuste;

    @FindBy(xpath = "//a[@id='btnVolver']")
    WebElement btnVolver;

    @FindBy(xpath = "//input[@id='btnVerificaBuscar']")
    WebElement btnBusquedaFactura;

    // Busqueda factura validar

    @FindBy(xpath = "//td[@class=\"lgazulmedio\"]")
    WebElement formBusquedaFactura;



    
}
