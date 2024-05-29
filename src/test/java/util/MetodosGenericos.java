package util;

import driverConfig.DriverContext;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetodosGenericos {

	// Método que devuelve la fecha actual en formato ddmmaa
	public static String obtenerFechaActual() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fecha = LocalDate.now();
		return fecha.format(formatter);
	}

	public static void selectOptionByValue(WebElement element, String optionValue) {
		Select select = new Select(element);
		select.selectByValue(optionValue);
	}

	public static void interactuarAlerta(boolean acceptAlert) {
		int intentos = 0;
		while (intentos < 3) {
			try {
				Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverContext.getDriver())
						.withTimeout(Duration.ofSeconds(20))
						.pollingEvery(Duration.ofSeconds(1))
						.ignoring(NoAlertPresentException.class);

				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				String alertText = alert.getText();
				System.out.println("Alerta presente: " + alertText);

				if (acceptAlert) {
					alert.accept();
					System.out.println("Alerta aceptada");
				} else {
					alert.dismiss();
					System.out.println("Alerta descartada");
				}

				System.out.println("Se interactuó correctamente con la alerta en el intento " + (intentos + 1));
				break;
			} catch (NoAlertPresentException e) {
				intentos++;
				System.out.println("Intento " + intentos + ": No fue posible interactuar con la alerta. Esperando y reintentando...");
			} catch (UnhandledAlertException e) {
				intentos++;
				System.out.println("Intento " + intentos + ": Alerta no manejada presente. Ignorando y reintentando...");
				DriverContext.getDriver().switchTo().alert().dismiss();
			}
		}

		if (intentos == 3) {
			Assertions.fail("No fue posible interactuar con la alerta después de " + intentos + " intentos");
		}
	}


	// Método que recibe un número de días y devuelve la fecha actual más ese número de días en formato dd, mm, aa
	public static String[] calcularFechaFutura(int dias) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate fechaFutura = LocalDate.now().plusDays(dias);
		String fechaFuturaFormateada = fechaFutura.format(formatter);
		return fechaFuturaFormateada.split(",");
	}

	// Método que devuelve la fecha actual más un número aleatorio de 0 a 99 en formato ddmmaahhmmrr
	public static String obtenerFechaConAleatorio() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyymm");
		LocalDateTime fechaHora = LocalDateTime.now(ZoneId.of("America/Santiago"));
		String fechaHoraFormateada = fechaHora.format(formatter);

		Random rand = new Random();
		int numeroAleatorio = rand.nextInt(100); // genera un número entre 0 y 99

		// Añadir el número aleatorio a la fecha y hora actual
		if (numeroAleatorio < 10) {
			return fechaHoraFormateada + "0" + numeroAleatorio; // Agrega un 0 antes del número si es menor a 10
		} else {
			return fechaHoraFormateada + numeroAleatorio;
		}
	}

	public static WebElement crearElemento(By localizador){
		return DriverContext.getDriver().findElement(localizador);
	}

	public static void seleccionarCheckIterativo(By... localizadores){
		for (By localizador: localizadores) {
			WebElement elemento = DriverContext.getDriver().findElement(localizador);
			elemento.click();
		}
	}


	public static void mostrarElemento(WebElement element) {
		((JavascriptExecutor) DriverContext.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static boolean seleccionCombo(WebElement comboBox, String descripcion) {
		boolean selec = visualizarObjeto(comboBox, 10);
		if (selec) {
			try {
				Select box = new Select(comboBox);
				box.selectByVisibleText(descripcion);
			} catch (Exception e) {

			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarExpresionesRegulares(String expresionRegular, String entrada) {
		Pattern patron = Pattern.compile(expresionRegular);
		Matcher palabra = patron.matcher(entrada);
		return palabra.find();
	}

	public static void mouseHoverElement(WebElement element) {
		Actions act = new Actions(DriverContext.getDriver());
		act.moveToElement(element).perform();
	}

	public static boolean visualizarObjeto(WebElement elementName, int timeout) {
		try {
			System.out.println("Valida si Es visible el elemento a validar.");
			WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(elementName));
			System.out.println("Es visible el elemento a validar: " + elementName.getText());
			System.out.println("==============================================");
			System.out.println();
			return true;
		} catch (Exception var3) {
			System.out.println("No es visible el elemento a validar.");
			return false;
		}
	}

	public static void esperar(int tiempo) {
		try {
			System.out.println("Esperando: " + tiempo + "s");
			Thread.sleep(tiempo * 1000L);
		} catch (InterruptedException io) {
			System.out.println(">>> " + io);
		}
	}

	public static int obtenerMinutos(String tiempo) {
		int i = 0;
		try {
			SimpleDateFormat f = new SimpleDateFormat("HH:mm");
			Date d = f.parse(tiempo);
			long tiempoInicial = d.getTime();

			DateFormat dateFormat = new SimpleDateFormat("HH:mm");
			Date date = new Date();

			String horaActual = dateFormat.format(date);
			Date e = f.parse(horaActual);
			long tiempofinal = e.getTime();

			long resta = tiempoInicial - tiempofinal;
			resta = resta / (1000 * 60);
			i = (int) resta;

		} catch (Exception var3) {
			System.out.print(var3);
		}

		return i;
	}

	public static void bajarScrollRobot() throws AWTException {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



	public static void waitImplicit(int time) {
		try {
			System.out.println("Esperando elemento");
			DriverContext.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		} catch (Exception var3) {

			System.out.println("Espera no cumplida");
		}
	}

	public static void waitExplicit(WebElement elementName, int time) {
			try {
				System.out.println("Esperando elemento");
				WebDriverWait myWaitVar = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(time));
				myWaitVar.until(ExpectedConditions.visibilityOfAllElements(elementName));
			} catch (Exception var3) {
				System.out.println("Espera no cumplida");
			}
	}

	public static void cambiarVentana(int pantalla) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(DriverContext.getDriver().getWindowHandles());
			DriverContext.getDriver().switchTo().window(tabs.get(pantalla));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public static void cambiarIFrame(String nombreIFrame) {
		try {
			DriverContext.getDriver().switchTo().frame(nombreIFrame);
		} catch (Exception e) {
			Assert.fail("No se pudo cambiar al iframe: " + nombreIFrame);
		}
	}

	public static void volverAVentanaPrincipal() {
		try {
			DriverContext.getDriver().switchTo().defaultContent();
		} catch (Exception e) {
			Assert.fail("No se pudo volver a la ventana principal");
		}
	}

	public static void validarDatosContraApi(String datoApi, WebElement elementName) {

		if (datoApi.equals(elementName.getText())) {
			System.out.println("Validacion OK: " + datoApi);
		} else {
			Assert.fail("El " + datoApi + " no corresponde al registrado en la API");
		}

	}

	public static void accionClic(WebElement element, String nombreElemento) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail();
		}

	}

	public static void accionClicJS(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverContext.getDriver();
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			Assert.fail();
		}

	}

	public static void accionSenkeys(WebElement element, String nombreElemento, String dato) {
		try {
			element.sendKeys(dato);
		} catch (Exception e) {
			Assert.fail();
		}

	}

	public static void accionClear(WebElement element, String nombreElemento) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail();
		}

	}

	public static String accionGetText(WebElement element) {
		String dato = null;
		try {
			dato = element.getText();
		} catch (Exception e) {

		}
		return dato;
	}

	public static String accionGetAtributo(WebElement element, String atributo, String nombreElemento) {
		String dato = null;
		try {
			dato = element.getAttribute(atributo);
		} catch (Exception e) {
			Assert.fail();
		}
		return dato;
	}

	public static String[] getColorBorder(WebElement element, String nombreElemento) {
		String[] color = null;
		try {
			color = element.getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))", "")
					.split(",");
		} catch (Exception e) {
			Assert.fail();
		}
		return color;
	}

	public static String convertirColorBorder(String[] colorBorder) {
		String color = null;
		try {
			color = String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(colorBorder[0])),
					toBrowserHexValue(Integer.parseInt(colorBorder[1])),
					toBrowserHexValue(Integer.parseInt(colorBorder[2])));
		} catch (Exception e) {
			Assert.fail();
		}
		return color;
	}

	private static String toBrowserHexValue(int number) {
		StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}
		return builder.toString().toUpperCase();
	}

	public static void validarFormatoColor(String colorFormat, String codigoValidacion, String nombreColor,
			String nombreCampo) {

		try {
			if (colorFormat.equals(codigoValidacion)) {

			} else {
				Assert.fail();
			}

		} catch (Exception e) {

		}

	}

	public static boolean validarEstadoBotones(WebElement element, String validacion) {
		boolean estado = false;
		try {
			estado = element.isEnabled();
		} catch (Exception e) {
			Assert.fail();
		}

		return estado;
	}

	public static List<LogEntry> retornaTrazaNetwork() {

		List<LogEntry> entries = DriverContext.getDriver().manage().logs().get(LogType.PERFORMANCE).getAll();
		System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");

		return entries;

	}

	public static void cerrarVentana() {
		DriverContext.getDriver().close();
	}

	public static void refresh() {
		DriverContext.getDriver().navigate().refresh();
	}

	public static void moverPantalla(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void bajarScroll() {

		JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
		js.executeScript("window.scrollBy(0,250)");

	}
	public static void subirScroll() {

		JavascriptExecutor js = (JavascriptExecutor) DriverContext.getDriver();
		js.executeScript("window.scrollTop()");

	}

	public static void cambiarUrl(String url){
		DriverContext.getDriver().get(url);
	}

	public static void scrollElement(WebElement element){
		Actions actions = new Actions(DriverContext.getDriver());
		actions.moveToElement(element);
		actions.perform();
	}

	public static void esperarPaginaCargada() {
		ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		try {
			MetodosGenericos.esperar(1); // Para dar un pequeño margen inicial
			WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(90));
			wait.until(expectation);
		} catch (Throwable error) {
			System.err.println("La página no se cargó en 30 segundos!");
		}
	}

	public static void verificarTexto(WebElement element, String mensaje){
		try{
			String dato = element.getText();
			if(dato.equals(mensaje)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT " + mensaje, true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT " + mensaje);
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
	}
	public static void verificarTextoporAtributo(WebElement element, String mensaje, String atributo){
		try{
			if(element.getAttribute(atributo).equals(mensaje)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT " + mensaje, true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT " + mensaje);
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}


	}



	public static int mostrarLargoList(List<WebElement> list) {
		int valor = 0;
		try {
			valor = list.size();
			System.out.println("El largo de la lista tiene un total de "+ valor + "Resultados");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
		return valor;

	}

	public static void verificarTextoConExpresionRegular(String expresion, WebElement element, String entrada){
		String dato = "";
		try{

			/*Pattern patron = Pattern.compile(expresion);
			Matcher palabra = patron.matcher(entrada);
			if (palabra.find()){
				dato = palabra.group();
			}*/
			Pattern patternName = Pattern.compile(expresion);
			Matcher matcher = patternName.matcher(entrada);
			if (matcher.find()){
				dato = matcher.group();
			}

			if(element.getText().equals(dato)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT ", true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT ");
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
	}

	public static void compararTextos(String txtElemento, String textoComparar){
		try {
			if (txtElemento.equals(textoComparar)){
				Assert.assertTrue("Se comprueba que texto corresponde al mostrado en FRONT ", true);
			}else {
				Assert.fail("El texto no corresponde al que se encontro en el FRONT ");
			}
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println(MetodosGenericos.obtenerFechaActual());
		String[] fechaFutura = MetodosGenericos.calcularFechaFutura(5);
		System.out.println(fechaFutura[0] + "," + fechaFutura[1] + "," + fechaFutura[2]);
		System.out.println(MetodosGenericos.obtenerFechaConAleatorio());
	}


	public static void cerrarPopUp(WebElement btnCerrarPop, String enva) {
		String env=System.getProperty("env", "qa");
		if(env.equals(enva)){
			MetodosGenericos.visualizarObjeto(btnCerrarPop, 60);
			btnCerrarPop.click();
		}
		else {
			System.out.println("No se debe cerrar ningún popup");
		}
	}
}
