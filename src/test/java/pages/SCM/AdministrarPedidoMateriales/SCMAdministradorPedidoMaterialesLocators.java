package pages.SCM.AdministrarPedidoMateriales;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCMAdministradorPedidoMaterialesLocators {

    //Administracion de Pedido de Materiales

    @FindBy(xpath = "//*[@id='txtNombre']")
    public
    WebElement inputNombrePedido;

    @FindBy (xpath = "//*[@id='btnBuscar']")
    public
    WebElement btnBuscarPedido;

    @FindBy(xpath = "//*[@id='lstDesignado']")
    public
    WebElement selectDesignacion;

    @FindBy(xpath = "//*[@id='lnkCotizar']")
    public
    WebElement btnCotizar;

    @FindBy(xpath = "//*[@id='lnkComprar']")
    public
    WebElement btnComprar;

    @FindBy (xpath = "//*[@id='txtNombre']")
    public
    WebElement inputNombreCotizacion;

    @FindBy (xpath = "//*[@id='btnGenerar']")
    public
    WebElement btnGenerarCotizacion;


    @FindBy (xpath = "//a[contains(text(),'Administrar por Pedido')]")
    WebElement seccionAdmporPedido;

}
