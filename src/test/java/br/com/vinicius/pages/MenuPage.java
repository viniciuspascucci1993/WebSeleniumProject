package br.com.vinicius.pages;

import br.com.vinicius.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		
		clickLink("Contas");
		clickLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		
		clickLink("Contas");
		clickLink("Listar");
	}
	
	public void acessarTelaInserirMovimentacao() {
		
		clickLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo() {
		
		clickLink("Resumo Mensal");
	}
	
	public void acessarTelaHome() {
		
		clickLink("Home");
	}
}
