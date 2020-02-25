package br.com.vinicius.pages;

import br.com.vinicius.core.BasePage;
import br.com.vinicius.core.DriverFactory;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		
		DriverFactory.getDriver().get("http://srbarriga.herokuapp.com");
	}
	
	public void setEmail( String email ) {
		escreve("email", email);
	}
	
	public void setSenha( String senha ) {
		escreve("senha", senha);
	}
	
	public void acessar() {
		clicarBotaoText("Entrar");
	}
	
	// Modo Alternativo
//	public void logar( String email, String senha ) {
//		setEmail(email);
//		setSenha(senha);
//		acessar();
//	}
}
