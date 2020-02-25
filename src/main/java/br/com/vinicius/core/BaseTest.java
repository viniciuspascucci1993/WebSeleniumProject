package br.com.vinicius.core;

import static br.com.vinicius.core.DriverFactory.getDriver;
import static br.com.vinicius.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Classe BaseTest respons�vel por utilizar o m�todo para finalizar o Driver.
 * @author Vinicius-PC
 */
public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
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
