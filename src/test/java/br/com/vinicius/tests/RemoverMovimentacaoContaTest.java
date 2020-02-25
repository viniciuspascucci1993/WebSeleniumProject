package br.com.vinicius.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.vinicius.core.BaseTest;
import br.com.vinicius.core.Propriedades;
import br.com.vinicius.pages.ContasPage;
import br.com.vinicius.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Test
	public void excluirContaComMovimentacaoTest() {
		
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
