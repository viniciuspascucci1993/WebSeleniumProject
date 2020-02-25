package br.com.vinicius.suites;

import static br.com.vinicius.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.vinicius.pages.LoginPage;
import br.com.vinicius.tests.ContaTest;
import br.com.vinicius.tests.MovimentacaoTest;
import br.com.vinicius.tests.RemoverMovimentacaoContaTest;
import br.com.vinicius.tests.ResumoTest;
import br.com.vinicius.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteTest {
	
	private static LoginPage loginPage = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		// Acessar a tela inicial
		loginPage.acessarTelaInicial();
		
		loginPage.setEmail("vinicius.pascucci1@gmail.com");
		loginPage.setSenha("vinicius0105");
		
		loginPage.acessar();
	}
	
	@AfterClass
	public static void finaliza() {
		killDriver();
	}
}
