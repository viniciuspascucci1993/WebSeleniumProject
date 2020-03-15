package br.com.vinicius.tests;

import static br.com.vinicius.tests.DataUtils.getDateFormatter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.vinicius.core.BaseTest;
import br.com.vinicius.pages.MenuPage;
import br.com.vinicius.pages.MovimentacaoPage;
import br.com.vinicius.tests.DataUtils;

public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();

	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	@Test
	public void teste_1InserirMovimentacao() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		movimentacaoPage.setDataMovimentacao(getDateFormatter(new Date()));
		movimentacaoPage.setDataPagamento(getDateFormatter(new Date()));
		movimentacaoPage.setDescricao("Contas para pagamento");
		movimentacaoPage.setNomeInteressado("Vinicius Pascucci");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setStatusPago();
		
		movimentacaoPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
	}
	
	@Test
	public void teste_2CamposObrigatorios() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		movimentacaoPage.salvar();
		List<String> errors = movimentacaoPage.obterErros();
		
//		Assert.assertEquals("Data da Movimentação é obrigatório", errors.get(0));
//		Assert.assertTrue(errors.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número")));
		}
	
	@Test
	public void teste_3InserirMovimentacaoFutura() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.getDateDiffDias(5);
		
		movimentacaoPage.setDataMovimentacao(getDateFormatter(dataFutura));
		movimentacaoPage.setDataPagamento(getDateFormatter(dataFutura));
		movimentacaoPage.setDescricao("Contas para pagamento");
		movimentacaoPage.setNomeInteressado("Vinicius Pascucci");
		movimentacaoPage.setValor("500");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setStatusPago();
		
		movimentacaoPage.salvar();
		
//		Assert.assertEquals("Data da Movimentação é obrigatório", errors.get(0));
//		Assert.assertTrue(errors.contains("Data da Movimentação é obrigatório"));
		List<String> errors = movimentacaoPage.obterErros();
		Assert.assertTrue(errors.contains(
				"Data da Movimentação deve ser menor ou igual à data atual"));
	}
}
