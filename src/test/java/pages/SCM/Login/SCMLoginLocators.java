package pages.SCM.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCMLoginLocators {

    @FindBy(xpath = "//a[@title=\"Iniciar sesión\"]")
    WebElement accesoClientesBtn;

    @FindBy(xpath = "//*[text()='Te damos la bienvenida a']/parent::p")
    WebElement bienvenidaLabel;

    @FindBy (css = "#iframeTabLoginOld")
    WebElement LoginIframe;

    @FindBy(css = "#txtUsuarioUOC")
    WebElement usuarioTxt;

    @FindBy(css = "#txtOrganizacionUOC")
    WebElement organizacionTxt;

    @FindBy(css = "#txtPasswordUOC")
    WebElement passwordTxt;

    @FindBy(css = "#btnIniciaSessionUOC")
    WebElement ingresarBtn;

    @FindBy(css = "#liTabLoginSso")
    WebElement ingresaConTuUsuarioTab;

    @FindBy(css = "#txtUsuarioSso")
    WebElement correoInput;

    @FindBy(css = "#txtPasswordSso")
    WebElement passwordSsoInput;

    @FindBy(css = "#btnIniciaSessionSso")
    WebElement iniciaSesionSsoBtn;

    @FindBy(id = "btnOlvideMiPasswordUOC")
    WebElement olvideMiContrasennaLink;

    @FindBy (id= "txtUsuarioRecuperaPasswordUOC")
    WebElement inputOlvideUsuarioSSO;

    @FindBy (id= "btnVolverAlLoginTrpUOC")
    WebElement btnVolverLogin;

    @FindBy(id = "lblMensajeErrorTloUOC")
    WebElement mensajeClaveIncorrectaLabel;




}
