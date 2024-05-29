package pages.SCM.Bodega;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCMBodegaLocators {

    @FindBy(xpath = "//input[@id='txtNombre']")
    WebElement inputNombre;

    @FindBy(xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarOrdenCompra;

    @FindBy(xpath = "//input[@id=\"txtNumeroOC\"]")
    WebElement inputNumeroOC;

    @FindBy(xpath = "//input[@id=\"txtNombreOC\"]")
    WebElement inputNombreOC;


    @FindBy(xpath = "//a[@title=\"Recibir Recursos\"]")
    WebElement btnRecibirRecursos;

    @FindBy(xpath = "//input[@name='ctrRecepcionOC$txtNumeroDocumento']")
    WebElement inputNroDocTransporte;

    @FindBy(xpath = "//input[@id=\"txtROC_Recibida_1\"]")
    WebElement inputCantidadRecibida;

    @FindBy(xpath = "//input[@id=\"txtROC_Rechazada_1\"]")
    WebElement inputCantidadRechazada;

    @FindBy(xpath = "//a[@id=\"btnRecepcionar\"]")
    WebElement btnConfirmarRecepcion;

    @FindBy (xpath = "//div[@id=\"wootric-close\"]")
    WebElement btnCerrarPop;

}
