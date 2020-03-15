package br.com.vinicius.core;

/**
 * Classe Propriedades que contem constantes.
 * @author Vinicius-PC
 */
public class Propriedades {

	public static final boolean CLOSE_BROWSER = true; 
	
	public static final Browsers BROWSER = Browsers.CHROME;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
	
	public enum TipoExecucao {
		LOCAL,
		GRID
	}
}
