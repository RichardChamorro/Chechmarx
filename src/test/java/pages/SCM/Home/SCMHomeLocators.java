package pages.SCM.Home;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class SCMHomeLocators {


    public WebElement tituloCreacionSC;
    @FindBy(xpath = "//img[@name='Image4']")
    WebElement logoutIcons;

    @FindBy(xpath = "//img[@name='Image5']")
    WebElement centroGestionIcons;

    @FindBy(xpath = "//img[@name='Image1']")
    WebElement miEscritorioIcons;

    //Pedido de Materiales
    @FindBy(xpath = "//span[text()='Pedido Materiales']")
   public WebElement subMenuPM;

    @FindBy(xpath = "//span[@title='Crear Pedido de Materiales']")
    public WebElement subMenuPMCrear;

    @FindBy(xpath = "//span[@title='Editar Pedido de Materiales']")
    WebElement btnsubMenuPMEditar;

    @FindBy(xpath = "//span[@title='Consultar Estado de Pedidos']")
    public WebElement btnsubMenuPMConsultar;

    @FindBy(xpath = "//span[@title='Regularizacion']")
    WebElement btnsubMenuPMRegularizacion;

    @FindBy(xpath = "//span[@title='Aprobar Pedido de Materiales']")
    WebElement btnsubMenuPMAprobar;

    @FindBy(xpath = "//span[@title='Administración de Pedidos']")
    public
    WebElement btnsubMenuPMAdministrar;

    @FindBy(xpath = "//span[@title='Autorizar Solicitudes de PM']")
    WebElement btnsubMenuPMAutorizar;

    @FindBy(xpath = "//span[@title='Pendientes Valorizados']")
    WebElement btnsubMenuPMPendientes;

    @FindBy(xpath = "//span[@title='Consolidación de Líneas']")
    WebElement btnsubMenuPMConsolidacion;

    //  Cotizaciones
    @FindBy (xpath = "//*[text()='Cotizaciones']")
    public
    WebElement btnSubMenuCotizaciones;

    @FindBy (xpath = "//span[@title='Panel de Cotizaciones']")
    WebElement btnSubMenuPanelCotizaciones;

    @FindBy (xpath = "//span[@title='Crear Cotización']")
    public
    WebElement btnSubMenuCrearCot;

    @FindBy (xpath = "//span[@title='Consultar Estado de Cotizaciones']")
    public
    WebElement btnSubMenuConsulta;

    @FindBy (xpath = "//span[@title='Administrar grupos']")
    WebElement btnSubMenuAdministrarGrupos;

    @FindBy (xpath = "(//span[@title='Listar Proveedores'])[2]")
    WebElement btnSubMenuListarProveedores;

    //Proveedor

    @FindBy (xpath = "//*[text()=\"Ventas\"]")
            public
    WebElement btnMenuVentas;

    @FindBy (xpath = "//span[@title=\"Consultar Ordenes de Compra\"]")
    public
    WebElement btnSubMenuConsultarOC;

    //Compras

    @FindBy(xpath = "//span[text()=\"Compras\"]")
    public WebElement btnCompras;

    @FindBy(xpath = "//span[text()=\"Compras\"]//ancestor::div[contains(@class,\"SubMenuParent\")]//following-sibling::div//descendant::span[text()=\"Consultar Estado de Orden\"]")
    public WebElement btnSubMenuConsultarEstadoOC;

    //Bodega
    @FindBy (xpath = "//*[text()='Bodega']")
            public
    WebElement btnBodega;
    @FindBy(xpath = "//span[text()=\"Bodega\"]//ancestor::div[contains(@class,\"SubMenuParent\")]//following-sibling::div//descendant::span[text()=\"Ingreso\"]")
            public
    WebElement btnSubMenuBodegaIngreso;

    @FindBy(xpath = "//span[text()=\"Ingreso\"]//ancestor::div[contains(@class,\"SubMenuParent\")]//following-sibling::div//descendant::span[text()=\"Recibir Ordenes de Compra\"]")
            public
    WebElement btnSubMenuBodegaIngresoRecibirOC;


    //Facturacion

    @FindBy(xpath = "//*[text()='Facturación']")
    public
    WebElement btnFacturacion;

    @FindBy(xpath = "//*[@title=\"Ingreso de Facturas\"]")
    public
    WebElement btnSubMenuFacturacionIngresoFactura;

    //SubContrato

   @FindBy(xpath = "//*[text()='Subcontratos']")
   public
   WebElement btnSubContratos;

   @FindBy(xpath = "//*[@title=\"Crear Subcontrato\"]")
   public
   WebElement btnSubMenuCrearSubContrato;





















}
