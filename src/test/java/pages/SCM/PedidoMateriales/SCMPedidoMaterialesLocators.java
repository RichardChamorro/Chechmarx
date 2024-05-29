package pages.SCM.PedidoMateriales;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SCMPedidoMaterialesLocators {


    //CREAR PEDIDO DE MATERIALES
    @FindBy (xpath = "//*[@id='txtNomPM']")
    WebElement inputNombrePedido;

    @FindBy (xpath = "//*[@id='txtComentarios']")
    WebElement inputNotas;

    @FindBy(xpath = "//*[@id='chkRecibirOfertas']" )
    WebElement checkPmVisible;

    @FindBy(xpath = "//*[@id='chkUrgente']")
    WebElement checkUrgente ;

    @FindBy(xpath = "//a[@id='ctrLineaPedido_lnkCodigo']")
    WebElement btnLupaCodigo;

    //Ventana Emergente Busqueda de producto por lupa
    @FindBy(xpath = "//*[@id='txtCodigo']")
    WebElement inputCodigo;

    @FindBy(xpath = "//*[@id='txtDescripcion']")
    WebElement inputDescripcion;

    @FindBy(xpath = "//a[@id='btnBuscar']")
    WebElement btnBuscarProd;
    ///

    //Ventana Emergente Busqueda de producto por Maestro

    @FindBy(xpath = "//a[@id='lnkSeleccionar']")
    WebElement btnSeleccionar;
    @FindBy(xpath = "//a[@id='lnkBuscar']")
    WebElement btnLnkBuscar;
    @FindBy(xpath = "//a[@id='lnkCerrar']")
    WebElement btnLnkCerrar;

    @FindBy(xpath = "//*[@id='btnGrabar']")
    WebElement btnGuardarPedidoMaestro;

    @FindBy(xpath = "//*[@id='btnVolver']")
    WebElement btnVolver;

    ///

    @FindBy(xpath = "//input[@id=\"ctrLineaPedido_txtLINCantidad\"]")
    WebElement inputCantidadProd;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_txtLINGlosa']")
    WebElement inputGlosa;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_rdbVerCalendario']" )
    WebElement checkVerCalendario;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_lnkCalendario']")
    WebElement btnCalendario;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_txtLINFechaEntrega']" )
    WebElement inputFechaEntrega;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_rdbVerDiasDespacho']")
    WebElement checkDiaDespacho;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_txtDiasDespacho']")
    WebElement inputDiaDespacho;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_txtLINComentario']" )
    WebElement inputComentariosProd;

    @FindBy(xpath ="//*[@id='ctrLineaPedido_lnkAnexosLinea']" )
    WebElement btnAdjuntarAnexos;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_txtCCosto']")
    WebElement inputCuentasCosto;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_lnkDistribucion']")
    WebElement btnDistribuirCuentaCosto;

    //Ventana emergente distribucion de costos

    @FindBy (xpath = "//*[@id='btnBuscar']")
    WebElement btnBuscarCuentaCosto;

    @FindBy (xpath = "//*[@id='ctrAcumulador_idccosto_item_28']")
    WebElement checkDistribucion1;

    @FindBy(xpath = "//*[@id='ctrAcumulador_idccosto_item_555']")
    WebElement checkDistribucion2;

    @FindBy (xpath = "//a[@id='btnSeleccionar']")
    WebElement btnSeleccionarDistribucion;

    @FindBy (xpath = "//*[@id='valor_1']")
    WebElement inputPorcentajeDistribucion1;

    @FindBy (xpath = "//*[@id='valor_2']")
    WebElement inputPorcentajeDistribucion2;

    @FindBy (xpath = "//*[@id='btnGrabar']")
    WebElement btnGuardarDistribucion;

    @FindBy (xpath = "//a[@id='lnkCerrar']")
    WebElement btnCerrarDistribucion;

    @FindBy (xpath = "//div[@id=\"wootric-close\"]")
    WebElement btnCerrarPop;
    //

    @FindBy(xpath = "//*[@id='ctrLineaPedido_btnAgregarLinea']")
    WebElement btnAgregarProd;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_btnLimpiar']")
    WebElement btnLimpiar;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_lnkMaestro']")
    WebElement btnMaestro ;

    @FindBy(xpath = "//*[@id='ctrLineaPedido_lnkExcel']")
    WebElement btnExcel;

    @FindBy(xpath = "//*[@id='btnBorrarPedido']")
    WebElement btnBorrarPedido;

    @FindBy(xpath = "//*[@id='btnEditarLineas']")
    WebElement btnEditarLineas;

    @FindBy(xpath = "//*[@id='btnGrabarPedido']")
    WebElement btnGuardarPedido;

    @FindBy(xpath = "//*[@id='btnEnviarPedido']")
    WebElement btnEnviarPedido;



    //EDITAR PEDIDO DE MATERIALES
    @FindBy(xpath = "//*[@id='txtNumero']")
    WebElement inputNroPedido;

    @FindBy(xpath = "//*[@id='txtNombre']")
    WebElement inputNomPedido;

    @FindBy(xpath = "//*[@id='txtSolicitante']")
    WebElement inputCampoSolicitante;

    @FindBy(xpath = "//*[@id='lstUrgente']")
    WebElement lstUrgente;

    @FindBy(xpath = "//option[@value='-1']")
    WebElement lstUrgenteTodos;

    @FindBy(xpath = "//option[@value='0']")
    WebElement lstUrgenteNo;

    @FindBy(xpath = "//option[@value='1']")
    WebElement lstUrgenteSi;

    @FindBy(xpath = "//*[@id='rngFechaCreacionFECHADESDE']")
    WebElement inputFechaCreaDesde;

    @FindBy(xpath = "//*[@id='rngFechaCreacionFECHAHASTA']")
    WebElement inputFechaCreaHasta;

    @FindBy(xpath = "//a[@id='rngFechaCreacionlnkCalendarioFechaDESDE']/img[@title='Seleccione una fecha']")
    WebElement btnCalendarioDesde;

    @FindBy(xpath = "//a[@id='rngFechaCreacionlnkCalendarioFechaHASTA']/img[@title='Seleccione una fecha']")
    WebElement btnCalendarioHasta;

    @FindBy(xpath = "//*[@id='txtCodigo']")
    WebElement inputCodigoProducto;

    @FindBy(xpath = "//*[@id='txtPalabra']")
    WebElement inputCalabraClave;

    @FindBy(xpath = "//select[@id='lstOrgC']")
    WebElement lstCentroGestion;

    @FindBy(xpath = "//option[contains(text(),'Todos los centros de gestion')]")
    WebElement lstCentroGestionTodos;

    @FindBy(xpath = "//option[contains(text(),'CG TestCafe')]")
    WebElement lstCentroGestionTC;

    @FindBy(xpath = "//option[contains(text(),'CompradorSelenium')]")
    WebElement lstCentroGestionComprador;

    @FindBy(xpath = "//option[contains(text(),'Selenium CG')]")
    WebElement lstCentroGestionSelenium;

    @FindBy(xpath = "//*[@id='btnBuscar']")
    WebElement btnBuscar;

    @FindBy(xpath = "//*[@id='btnEnviar']")
    WebElement btnEnviar;

    //Consultar pedido materiales

    @FindBy (xpath = "//*[@id='txtNombre']")
    WebElement inputNombrePedidoConsultarPedido;

    @FindBy (xpath = "//a[text()='Consultar Estado por Pedido']")
    WebElement tabConsultarEstadoPorPedido;

    //CONSULTAR ESTA PARTE
    @FindBy(xpath = "//a[@title='Editar el pedido']")
    WebElement btnEditarPedido;
    @FindBy(xpath = "//a[@title='Eliminar el pedido']")
    WebElement btnEliminarPedido;
    @FindBy(xpath = "//a[@title='Copiar el pedido']")
    WebElement btnCopiarPedido;
    @FindBy(xpath = "//a[@title='Historial del pedido']")
    WebElement btnHistorialPedido;








}
