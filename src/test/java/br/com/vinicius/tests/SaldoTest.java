package br.com.vinicius.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.vinicius.core.BaseTest;
import br.com.vinicius.pages.HomePage;
import br.com.vinicius.pages.MenuPage;

public class SaldoTest extends BaseTest {

	private HomePage homePage = new HomePage();
	
	private MenuPage menuPage = new MenuPage();
	
	@Test
	public void saldoContaTest() {
		
		menuPage.acessarTelaHome();
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
	}
}
