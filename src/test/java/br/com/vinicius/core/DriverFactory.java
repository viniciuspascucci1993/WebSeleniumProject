package br.com.vinicius.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.vinicius.core.Propriedades.TipoExecucao;

public class DriverFactory {

//	private static WebDriver driver;
	
	// Instancia de ThreadLocal para termos um driver por thread.
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() {  }
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		
		WebDriver driver = null;
		
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			System.setProperty("webdriver.chrome.driver", "C:\\driversSE\\chromedriver.exe");
				switch (Propriedades.BROWSER) {
				case FIREFOX:driver = new FirefoxDriver(); break;
				case CHROME: driver = new ChromeDriver(); break;
				}
			}
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			
			DesiredCapabilities capabilities = null;
			switch (Propriedades.BROWSER) {
				case FIREFOX: capabilities = DesiredCapabilities.firefox(); break;
				case CHROME: capabilities = DesiredCapabilities.chrome(); break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.0.27:4444/wd/hub"), 
						capabilities);
			} catch (MalformedURLException e) {
				System.out.println("Falha na conexão com GRID");
				e.printStackTrace();
			}
		}
		driver.manage().window().setSize(new Dimension(1200, 765));
		return driver;
	}
	
	public static void killDriver() {
		
		WebDriver driver = getDriver();
		if (driver != null) {
			
			driver.quit();
			driver = null;
		}
		
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}
	
	
}
