package br.com.vinicius.suites;

import static br.com.vinicius.core.DriverFactory.killDriver;

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

	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		
		page.setEmail("vinicius.pascucci1@gmail.com");
		page.setSenha("vinicius0105");
		
		page.acessar();
		
		page.clickResetBtn();
		
		killDriver();
	}
}
