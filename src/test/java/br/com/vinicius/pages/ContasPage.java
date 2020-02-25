package br.com.vinicius.pages;

import org.openqa.selenium.By;

import br.com.vinicius.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome( String nome ) {
		escreve("nome", nome);
	}
	
	public void salvar() {
		clicarBotaoText("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return getXPath(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro() {
		return getXPath(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clicarAlterarConta(String conta) {
		
		obterCelula("Conta", conta, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();		
	}
	
	public void clicarExcluirConta(String conta) {
		
		obterCelula("Conta", conta, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();		
	}
}
