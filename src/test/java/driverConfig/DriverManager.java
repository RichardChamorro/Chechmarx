package driverConfig;

import constants.Navegador;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {
private WebDriver driver;
private DesiredCapabilities capabilities = new DesiredCapabilities();
private File root = new File("src/driver/chromedriver");
private String extensionDriver = "";

       protected void resolveDriver(Navegador nav, String ambURL) throws MalformedURLException {
    	    File driverPath;
    	    String os = System.getProperty("os.name").toLowerCase();
    	    System.out.println("\nSistema operativo ->" + System.getProperty("os.name").toLowerCase() + " " +System.getProperty("os.version").toLowerCase() +"\n");
    	    if (os.contains("windows"))
    	      this.extensionDriver = ".exe";
    	    System.out.println(nav);

    	    switch (nav) {
				case Chrome:
					System.out.println("Se selecciona Chrome");
					ChromeOptions chromeOptions = new ChromeOptions();
					if (os.contains("linux")){
						System.out.println("entre a linux");
						System.out.println(System.getProperty("user.name"));
						chromeOptions.addArguments("--disable-dev-shm-usage");
						chromeOptions.addArguments("--no-sandbox");
						chromeOptions.addArguments("--disable-gpu");
						chromeOptions.addArguments("--headless");
						chromeOptions.addArguments("--ignore-ssl-errors=yes");
						chromeOptions.addArguments("--window-size=1920x1080");
					}
					WebDriverManager.chromedriver().clearDriverCache().setup();
					//System.setProperty("webdriver.chrome.driver", root + extensionDriver);
					chromeOptions.addArguments("--disable-features=RemoteAllowOrigins");
					//chromeOptions.addArguments("--remote-allow-origins=*");
					this.driver = (WebDriver)new ChromeDriver(chromeOptions);
					this.driver.manage().deleteAllCookies();
				break;
				case Firefox:
					System.out.println("Se selecciona Firefox");
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					if (os.contains("linux")) {
						System.out.println("entre a linux");
						System.out.println(System.getProperty("user.name"));
						firefoxOptions.addArguments("--headless");
						firefoxOptions.addArguments("--window-size=1920x1080");
					}
					WebDriverManager.firefoxdriver().setup();
					this.driver = new FirefoxDriver(firefoxOptions);
					this.driver.manage().deleteAllCookies();
				break;
				case Edge:
					System.out.println("Se selecciona Edge");
					EdgeOptions edgeOptions = new EdgeOptions();
					if (os.contains("linux")) {
						System.out.println("entre a linux");
						System.out.println(System.getProperty("user.name"));
						edgeOptions.addArguments("--disable-dev-shm-usage");
						edgeOptions.addArguments("--no-sandbox");
						edgeOptions.addArguments("--disable-gpu");
						edgeOptions.addArguments("--headless");
						edgeOptions.addArguments("--ignore-ssl-errors=yes");
						edgeOptions.addArguments("--window-size=1920x1080");
					}
					WebDriverManager.edgedriver().setup();
					//edgeOptions.addArguments("--remote-allow-origins=*");
					this.driver = new EdgeDriver(edgeOptions);
					this.driver.manage().deleteAllCookies();
					break;
					default:
    	        	System.out.println("No es posible lanzar el navegador, no se reconoce el navegador: " + nav);
    	        	break;
			}
    	    this.driver.manage().window().maximize();
    		this.driver.get(ambURL);
    	  }

    protected WebDriver getDriver() {
    	if (driver == null) {
			return driver;
		} else {
			return driver;
		}
    }

}
