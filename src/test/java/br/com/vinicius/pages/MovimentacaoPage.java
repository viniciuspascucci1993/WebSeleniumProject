package br.com.vinicius.pages;

import static br.com.vinicius.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.vinicius.core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void setDataMovimentacao( String data ) {
		escreve("data_transacao", data);
	}
	
	public void setDataPagamento( String pag ) {
		escreve("data_pagamento", pag);
	}
	
	public void setDescricao( String desc) {
		escreve("descricao", desc);
	}
	
	public void setNomeInteressado( String nome ) {
		escreve("interessado", nome);
	}
	
	public void setValor( String valor ) {
		escreve("valor", valor);
	}
	
	public void setConta( String conta ) {
		selectCombobox("conta", conta); 
	}
	
	public void setStatusPago() {
		clickRadioButton("status_pago");
	}
	
	public void salvar() {
		clicarBotaoText("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return getXPath(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public List<String> obterErros() {	
		List<WebElement> errors = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		
		List<String> retorno = new ArrayList<String>();
		for (WebElement erro : errors) {
			
			retorno.add(erro.getText());
		}
		return retorno;
	}
}
