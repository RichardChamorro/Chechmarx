package pages.SCM.OrdenDeCompra;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class SCMOrdenDeCompraLocators {

    @FindBy(xpath = "//a[@id=\"btnBuscar\"]")
    WebElement btnBuscarOC;

    @FindBy(xpath = "//input[@id=\"txtNomOc\"]")
    WebElement inputOc;

    @FindBy(xpath = "//span[@title=\"PROVEEDOR PRUEBA SELENIUM\"]")
    WebElement btnSeleccionProveedor;

    @FindBy(xpath = "//select[@id=\"lstSucursal\"]")
    WebElement selectSucursal;

    @FindBy (xpath = "//a[@id=\"btnGrabar\"]")
    WebElement btnGuardarOC;

    @FindBy (xpath = "//a[@id=\"btnEnviar\"]")
    WebElement btnVerificarOC;

    @FindBy (xpath = "//div[@id=\"wootric-close\"]")
    WebElement btnCerrarPop;

    @FindBy(xpath = "(//input[@placeholder=\"Nombre proveedor o rut\"])[1]")
    WebElement inputRutProveedor1;
    @FindBy(xpath = "(//input[@placeholder=\"Nombre proveedor o rut\"])[2]")
    WebElement inputRutProveedor;

    @FindBy(xpath = "(//a[@title=\"Editar la orden de compra\"])[2]")
    WebElement btnEditarOC;

    @FindBy(xpath = "//a[@title=\"Editar la línea de la orden de compra\"]")
    WebElement btnEditarDatosOC;

    @FindBy(xpath = "//input[@id=\"ctrLineaOrdenCompra_txtLINPrecioUnit\"]")
    WebElement inputEditarPrecioUnitario;

    @FindBy(xpath = "//a[@id=\"ctrLineaOrdenCompra_btnAgregarLinea\"]")
    WebElement btnAgregarCambios;

    @FindBy(xpath = " //div[@class=\"exito\"]")
    WebElement msgValidacion;

    @FindBy(xpath = "//input[@id=\"btnEnviarOC\"]")
    WebElement btnEnviarOC;

    @FindBy(xpath = "//button[@id=\"btnGuardarJs\"]")
    WebElement btnEnviarOCJS;





    // geneara oc
    @FindBy(xpath = "//input[@id=\"txtNombre\"]")
    WebElement inputNombreOrdenCompra;

    @FindBy(xpath = "//a[@id=\"btnGenerar\"]")
    WebElement btnGenerarOC;







}
