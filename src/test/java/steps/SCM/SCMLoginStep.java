package steps.SCM;

import com.google.gson.JsonObject;
import driverConfig.DriverContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SCM.Home.SCMHomePage;
import pages.SCM.Login.SCMLoginPage;
import util.JsonDataProcessor;

import java.io.IOException;

import static constants.Constant.URL_Iconstruye_PROD;

import static org.junit.Assert.assertEquals;

public class SCMLoginStep {


    String rutaJson = "src/test/data/SCM/loginUser_Data.json";
    String env=System.getProperty("env", "qa");
    SCMLoginPage scmLoginPage = new SCMLoginPage();
    SCMHomePage scmHomePage = new SCMHomePage();
    private JsonObject user;


    @When("ingreso las credenciales de usuario {string}")
    public void ingresoLasCredencialesDeUsuario(String userType) throws IOException {
        this.user = JsonDataProcessor.getObjectFromJson(rutaJson, env, userType);
        scmLoginPage.loginUser(user.get("usuario").getAsString(),user.get("organizacion").getAsString(),user.get("password").getAsString());
    }

    @And("selecciono el centro de gestión")
    public void seleccionoElCentroDeGestión() {
        scmHomePage.cambiarCentroGestion(user.get("centroGestion").getAsString());
    }

    @Then("debo ver el icono de Mi Escritorio en la página principal de iConstruye")
    public void deboVerElIconoDeMiEscritorioEnLaPáginaPrincipalDeIConstruye() {
        scmHomePage.validarMiEscritorio();
    }

    @When("ingreso las credenciales de usuario por correo {string}")
    public void ingresoLasCredencialesDeUsuarioPorCorreo(String userType) throws IOException {
        this.user = JsonDataProcessor.getObjectFromJson(rutaJson, env, userType);
        scmLoginPage.loginEmail(user.get("correo").getAsString(),user.get("password").getAsString());
    }

    @And("estoy logueado como usuario {string}")
    public void estoyLogueadoComoUsuario(String userType) throws IOException {
        ingresoLasCredencialesDeUsuario(userType);
        seleccionoElCentroDeGestión();
        deboVerElIconoDeMiEscritorioEnLaPáginaPrincipalDeIConstruye();
    }

    @When("cierro sesion en iConstruye")
    public void cierroSesionEnIConstruye() {
        scmHomePage.logout();
    }

    @Then("debo ver la página de bienvenida de iConstruye")
    public void deboVerLaPáginaDeBienvenidaDeIConstruye() {
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(env.equals("qa") ?  "https://webpp.iconstruye.cl/" : ("https://cl.iconstruye.com/includes/default.aspx".equals(url)
                ? "https://cl.iconstruye.com/includes/default.aspx"
                : URL_Iconstruye_PROD), url);
    }

    @When("selecciono la opción de olvidé mi contraseña")
    public void seleccionoLaOpciónDeOlvidéMiContraseña() {
        scmLoginPage.olvideMiContrasena();
    }

    @And("ingreso el correo de usuario {string} para recuperar la contraseña")
    public void ingresoElCorreoDeUsuarioParaRecuperarLaContraseña(String userType) throws IOException {
        this.user = JsonDataProcessor.getObjectFromJson(rutaJson, env, userType);
        scmLoginPage.IngresoUsarioOlvidadoSSO(user.get("correo").getAsString());
    }

    @Then("debo ver la página de Cambio de Clave")
    public void deboVerLaPáginaDeCambioDeClave() {
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(env.equals("qa") ?  "https://web-stage-scm.iconstruye.cl/loginSso.aspx?ReturnUrl=%2f#" : URL_Iconstruye_PROD, url);
    }

    @When("regreso al login e ingreso las credenciales de usuario por correo {string}")
    public void regresoAlLoginEIngresoLasCredencialesDeUsuarioPorCorreo(String userType) throws IOException {
       scmLoginPage.volverLogin();
       ingresoLasCredencialesDeUsuarioPorCorreo(userType);

    }


}
