package pages.SCM.Login;

import driverConfig.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MetodosGenericos;


import java.time.Duration;

import static org.junit.Assert.fail;

public class SCMLoginPage {
    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMLoginPage.class);

    private SCMLoginLocators pageElements;

    public SCMLoginPage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMLoginLocators.class);
    }

    public void loginUser(String usr, String org, String pass){
        MetodosGenericos.esperarPaginaCargada();
        MetodosGenericos.esperar(5);
        String env=System.getProperty("env", "qa");
        if(env.equals("prod")){
            pageElements.accesoClientesBtn.click();
            MetodosGenericos.visualizarObjeto(pageElements.usuarioTxt, 30);
        }
        pageElements.usuarioTxt.sendKeys(usr);
        pageElements.organizacionTxt.sendKeys(org);
        pageElements.passwordTxt.sendKeys(pass);
        pageElements.ingresarBtn.click();
        if (MetodosGenericos.visualizarObjeto(pageElements.mensajeClaveIncorrectaLabel,10)){
            MetodosGenericos.esperar(5);
            System.out.println("reintento login");
            pageElements.ingresarBtn.click();
        }
    }

    public void loginEmail(String email, String pass){
        MetodosGenericos.esperarPaginaCargada();
        MetodosGenericos.esperar(5);
        String env=System.getProperty("env", "qa");
        if(env.equals("prod")){
            pageElements.accesoClientesBtn.click();
            MetodosGenericos.visualizarObjeto(pageElements.ingresaConTuUsuarioTab, 30);
        }
        pageElements.ingresaConTuUsuarioTab.click();
        pageElements.correoInput.sendKeys(email);
        pageElements.passwordSsoInput.sendKeys(pass);
        pageElements.iniciaSesionSsoBtn.click();
        if (MetodosGenericos.visualizarObjeto(pageElements.mensajeClaveIncorrectaLabel,10)){
            MetodosGenericos.esperar(5);
            System.out.println("reintento login");
            pageElements.iniciaSesionSsoBtn.click();
        }
    }

    public void olvideMiContrasena(){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(5);
            boolean validarOlvideMiContrasena = MetodosGenericos.visualizarObjeto(pageElements.olvideMiContrasennaLink, 30);
            if(validarOlvideMiContrasena){
                pageElements.olvideMiContrasennaLink.click();
            }
            else {
                fail("no se logro visualizar el botón olvide mi contraseña");
            }
        }catch (Exception e){
            fail("no fue posible acceder a olvide mi contraseña");
        }
    }

    public void IngresoUsarioOlvidadoSSO(String usuario){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(5);
            boolean validarOlvideMiContrasena = MetodosGenericos.visualizarObjeto(pageElements.inputOlvideUsuarioSSO, 30);
            if(validarOlvideMiContrasena){
                pageElements.inputOlvideUsuarioSSO.sendKeys(usuario);
            }
            else {
                fail("no se logro visualizar el campo usuario dentro de olvide mi contraseña");
            }
        }catch (Exception e){
            fail("no fue posible interactuar con campo usuario dentro de olvide mi contraseña");
        }
    }

    public void volverLogin(){
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(5);
            boolean validarOlvideMiContrasena = MetodosGenericos.visualizarObjeto(pageElements.btnVolverLogin, 30);
            if(validarOlvideMiContrasena){
                pageElements.btnVolverLogin.click();
            }
            else {
                fail("no se logro visualizar el botón olvide mi contraseña");
            }
        }catch (Exception e){
            fail("no fue posible acceder a olvide mi contraseña");
        }
    }




}
