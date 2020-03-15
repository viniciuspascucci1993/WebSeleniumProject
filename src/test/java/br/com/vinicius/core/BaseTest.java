package br.com.vinicius.core;

import static br.com.vinicius.core.DriverFactory.getDriver;
import static br.com.vinicius.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.vinicius.pages.LoginPage;

/**
 * Classe BaseTest responsável por utilizar metodos para tirar screenshot dos testes e pelo loginPage.
 * @author Vinicius-PC.
 */
public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	private LoginPage loginPage = new LoginPage();
	
	@Before
	public void inicializa() {
		// Acessar a tela inicial
		loginPage.acessarTelaInicial();
		
		loginPage.setEmail("vinicius.pascucci1@gmail.com");
		loginPage.setSenha("vinicius0105");
		
		loginPage.acessar();
	}
	
	@After
	public void afterInitSelenium() throws IOException {
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();    
		File arquivo = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(arquivo, new File("target" + File.separator +"screenshotTest" + 
					File.separator + testName.getMethodName() + 
				".jpg"));
		
		if (Propriedades.CLOSE_BROWSER) {
			
			killDriver();
		}
	}
}
