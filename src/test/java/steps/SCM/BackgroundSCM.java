package steps.SCM;

import constants.Navegador;
import driverConfig.DriverContext;
import driverConfig.NavSelector;
import io.cucumber.java.en.Given;
import util.MetodosGenericos;

import java.net.MalformedURLException;

import static constants.Constant.*;
import static org.junit.Assert.assertEquals;

public class BackgroundSCM {


    @Given("estoy en la página de inicio de iConstruye")
    public void estoyEnLaPáginaDeInicioDeIConstruye() throws MalformedURLException {
        String env=System.getProperty("env", "qa");
        String navegador = System.getProperty("nav", "default");
        Navegador nav = NavSelector.seleccionNavegador(navegador);
        DriverContext.setUp(nav, env.equals("qa") ?  URL_Iconstruye_QA : URL_Iconstruye_PROD);
        MetodosGenericos.esperar(2);
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(env.equals("qa") ?  URL_Iconstruye_QA+"/loginSso.aspx?ReturnUrl=%2f" : URL_Iconstruye_PROD, url);
    }

}
