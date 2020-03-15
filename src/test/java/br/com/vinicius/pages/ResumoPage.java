package br.com.vinicius.pages;

import org.openqa.selenium.By;

import br.com.vinicius.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao() {
		
		clickButton(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucesso() {
		return getXPath(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void selecionarAno( String ano ) {
		selectCombobox("ano", ano);
	}
	
	public void buscar() {
		clickButton(By.xpath("//input[@value='Buscar']"));
	}
}
