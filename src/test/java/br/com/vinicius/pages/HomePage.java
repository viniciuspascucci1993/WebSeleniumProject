package br.com.vinicius.pages;

import br.com.vinicius.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta( String nome ) {
			
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();	
	}
}
