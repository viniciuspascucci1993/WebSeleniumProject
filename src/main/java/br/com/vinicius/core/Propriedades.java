package br.com.vinicius.core;

/**
 * Classe Propriedades que contem constantes.
 * @author Vinicius-PC
 */
public class Propriedades {

	public static final boolean CLOSE_BROWSER = false; 
	
	public static final Browsers brroser = Browsers.CHROME;
	
	public static String NOME_CONTA_ALTERADA = "Conta do Test [Alterada]" + System.nanoTime();
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
}
