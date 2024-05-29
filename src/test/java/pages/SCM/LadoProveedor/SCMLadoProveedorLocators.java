package pages.SCM.LadoProveedor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCMLadoProveedorLocators {

    @FindBy (xpath = "//span[contains(text(),'Consultar Cotizaciones')]")
    WebElement btnConsultaCotizaciones;

    @FindBy(xpath = "//*[@id='txtNombre']")
    WebElement inputNombreCotizacion;

    @FindBy(xpath = "//*[@id='txtNumero']")
    WebElement inputNumCotizacion;
    @FindBy(xpath = "//input[@id='btnBuscar']")
    WebElement btnBuscarCotizacion;

    @FindBy(xpath = "(//a[@title=\"Crear Oferta\"])[1]")
    WebElement btnCrearOferta;

    @FindBy(xpath = "//input[@id='txtNombreOferta']")
    WebElement inputNombreOferta;

    @FindBy(xpath = "//textarea[@id=\"txtMotivoOfertaVacia\"]")
    WebElement inputMotivoOferta;

    @FindBy(xpath = "//input[@id='PrecioUnitario_1']")
    WebElement inputPrecioUni;

    @FindBy(xpath = "//input[@id='Descuento_1']")
    WebElement inputDescuento;

    @FindBy(xpath = "//*[@id='FechaDespachoProveedor_1']")
    WebElement inputFechaDespacho;

    @FindBy(xpath = "//input[@id=\"btnEnviar\"]")
    WebElement btnVerificarCotizacion;

    @FindBy(xpath = "//input[@id=\"btnEnviar\"]")
    WebElement btnEnviarCotizacion;

    @FindBy(xpath = "//select[@id='respuesta_1']")
    WebElement btnselectRespuesta;

    @FindBy(xpath = "(//option[text()=\"Hay Stock\"])")
    WebElement selectStock;



    @FindBy (xpath = "//*[text()=\"Buscar ordenes de compra\"]")
    WebElement buscarOCTxt;

    @FindBy(xpath = "//*[@id=\"lstEmpresa\"]")
    WebElement btnListaEmpresa;

    @FindBy(xpath = "//*[@id=\"lstSucursal\"]")
    WebElement btnListaSucursal;

    @FindBy(xpath = "//*[@id=\"lstEstados\"]")
    WebElement btnListaEstado;

    @FindBy(xpath = "//a[@id=\"btnBuscar\"]")
    WebElement btnBuscarOC;


    @FindBy (xpath = "//a[@title=\"Ver Ofertas\"]")
    WebElement btnVerOferta;


}
