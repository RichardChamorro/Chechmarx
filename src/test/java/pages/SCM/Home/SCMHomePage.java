package pages.SCM.Home;

import driverConfig.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.SCM.Login.SCMLoginLocators;
import pages.SCM.Login.SCMLoginPage;
import util.MetodosGenericos;

import java.time.Duration;

import static org.junit.Assert.fail;

public class SCMHomePage {


    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(SCMHomePage.class);

    private SCMHomeLocators pageElements;

    public SCMHomePage(){
        this.driver = DriverContext.getDriver();
        pageElements = PageFactory.initElements(this.driver, SCMHomeLocators.class);
    }

    public void cambiarCentroGestion(String cGestion){
        try {
            MetodosGenericos.esperarPaginaCargada();
            MetodosGenericos.esperar(5);
            boolean validarCentroGestion = MetodosGenericos.visualizarObjeto(pageElements.centroGestionIcons, 180);
            if(validarCentroGestion){
                pageElements.centroGestionIcons.click();
                MetodosGenericos.esperarPaginaCargada();
                try{
                    MetodosGenericos.cambiarIFrame("ventana");
                    MetodosGenericos.esperar(5);
                    MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//a[contains(text(),\""+cGestion+"\")]")), 360);
                    MetodosGenericos.crearElemento(By.xpath("//a[contains(text(),\""+cGestion+"\")]")).click();
                }
                catch (NoSuchElementException e){
                    System.out.println("reintento ingresar a centro de gestion");
                    MetodosGenericos.volverAVentanaPrincipal();
                    pageElements.centroGestionIcons.click();
                    MetodosGenericos.esperarPaginaCargada();
                    MetodosGenericos.cambiarIFrame("ventana");
                    MetodosGenericos.esperar(5);
                    MetodosGenericos.visualizarObjeto(MetodosGenericos.crearElemento(By.xpath("//a[contains(text(),\""+cGestion+"\")]")), 360);
                    MetodosGenericos.crearElemento(By.xpath("//a[contains(text(),\""+cGestion+"\")]")).click();
                }
                MetodosGenericos.esperar(5);
                MetodosGenericos.volverAVentanaPrincipal();
            }
            else {
                fail("no se logro visualizar el Centro de Gestion");
            }
        }catch (Exception e){
            fail("no fue posible ingresar al centro de gestion" + e);
        }
    }

    public boolean validarMiEscritorio(){
        return MetodosGenericos.visualizarObjeto(pageElements.miEscritorioIcons, 90);
    }

    public void logout() {
        MetodosGenericos.esperarPaginaCargada();
        try {
            MetodosGenericos.esperar(5);
            boolean validarLogout = MetodosGenericos.visualizarObjeto(pageElements.logoutIcons, 180);
            if (validarLogout) {
                pageElements.logoutIcons.click();
            } else {
                fail("no se logro visualizar el botón cerrar sesión");
            }
        } catch (Exception e) {
            fail("no fue posible cerrar sesión");
        }
    }
}
