package br.com.vinicius.tests;

import static br.com.vinicius.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.vinicius.core.BaseTest;
import br.com.vinicius.core.DriverFactory;
import br.com.vinicius.pages.MenuPage;
import br.com.vinicius.pages.ResumoPage;

public class ResumoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void teste_1ExcluirResumoMovimentacao() {
		
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", 
					resumoPage.obterMensagemSucesso());
	}
	
	@Test
	public void teste_2ResumoMensal() {
		
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resumoPage.selecionarAno("2019");
		resumoPage.buscar();
		
		// DESAFIO: TESTE DO RESUMNO MENSAL VAZIO.
		List<WebElement> elementosEncontrados = DriverFactory.getDriver().
				findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));			
		
		Assert.assertEquals(0, elementosEncontrados.size());
	}
	
	
}
