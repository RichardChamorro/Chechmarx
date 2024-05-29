package pages.SCM.SubContrato;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCMSubContratoLocators {

    @FindBy(xpath = "//span[text()='Creación de SubContrato']")
    WebElement tituloCreacionSC;

    @FindBy (xpath = "//input[@id='txtNombreSC']")
    WebElement inputNombreSubContrato;

    @FindBy (xpath = "//input[@id='txtNumeroSC']")
    WebElement inputNumSubContrato;

    @FindBy (xpath = "//input[@id='txtPeriodicidad']")
    WebElement inputPeriodicidad;

    @FindBy (xpath = "//input[@id='txtFechaFirmaFECHA']")
    WebElement inputFechaFirma ;

    @FindBy (xpath = "//input[@id='txtFechaInicioFECHA']")
    WebElement inputFechaInicio;

    @FindBy (xpath = "//input[@id='txtFechaTerminoFECHA']")
    WebElement inputFechaTermino;

    @FindBy (xpath = "//*[@id='lnkAdjuntarS']")
    WebElement btnAdjuntarDocumento;

    @FindBy (xpath = "//*[@id='txtComentarios']")
    WebElement inputComentarios;

    @FindBy (xpath = "//input[@id='lnkProveedor']")
    WebElement btnProveedor;

    @FindBy (xpath = "//input[@id='txtProveedor']")
    WebElement inputProveedor;

    @FindBy (xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarProv;

    @FindBy (xpath = "//a[@title=\"Seleccionar Proveedor\"]")
    WebElement btnSelProveedor;

    @FindBy(xpath = "//select[@id='lstSucursal']")
    WebElement selectSucursal;

    @FindBy(xpath = "//input[@id='lnkListarRepresentatesLegales']")
    WebElement btnListarRepre;

    @FindBy(xpath = "//a[@id='btnGrabar']")
    WebElement btnGuardarRepre;

    @FindBy(xpath = "//input[@id='rbtEmiteFactura_0']")
    WebElement selectEmitirFactura;

    @FindBy(xpath = "//input[@id='txtMontoAnticipoNeto']")
    WebElement inputAnticipo ;

    @FindBy(xpath = "//input[@id='txtMontoRetencionNeta']")
    WebElement inputMontoRetencion;

    @FindBy(xpath = "//input[@id='CtrLinea_lnkMaestro']")
    WebElement btnIngMaestro;

    @FindBy(xpath = "//input[@id='txtCodigo']")
    WebElement inputCodigoProd;

    @FindBy(xpath = "//a[@id='lnkBuscar']")
    WebElement btnBuscarProd;

    @FindBy(xpath = "//a[@id='lnkSeleccionar']")
    WebElement btnSeleccionarProd;

    @FindBy(xpath = "//a[@id='lnkCerrar']")
    WebElement btnCerrar;

    @FindBy(xpath = "//input[@id='btnEditarLineas']")
    WebElement btnEditarLineas;

    @FindBy(xpath = "//input[@id='cnt_1']")
    WebElement inputCantidad1;

    @FindBy(xpath = "//input[@id='pre_1']")
    WebElement inputPrecio1;

    @FindBy(xpath = "//input[@id='glo_1']")
    WebElement inputGlosa1;

    @FindBy(xpath = "//input[@id='cnt_2']")
    WebElement inputCantidad2;

    @FindBy(xpath = "//input[@id='pre_2']")
    WebElement inputPrecio2;

    @FindBy(xpath = "//input[@id='glo_2']")
    WebElement inputGlosa2;

    @FindBy(xpath = "//a[@title=\"Distribución\"]")
    WebElement btnDistCuentaCosto;

    @FindBy (xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarCuentaCosto;

    @FindBy (xpath = "//a[@id='btnSeleccionar']")
    WebElement btnSelCuentaCosto;

    @FindBy (xpath = "//a[@id='btnGrabar']")
    WebElement btnGuardarCuentaCosto;

    @FindBy (xpath = "//a[@id='lnkCerrar']")
    WebElement getBtnCerrarCuentaCosto;

    @FindBy (xpath = "//input[@id='dis_1']")
    WebElement inputCuentaCosto2;

    @FindBy(xpath = "//a[@id='lnkVolver']")
    WebElement btnVolver;

    @FindBy(xpath = "//input[@id='btnVerificar']")
    WebElement btnVerificarSubContrato;
















}
