package br.com.vinicius.tests.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe Utilitária responsavel por tratamento de data.
 * @author Vinicius-PC
 */
public class DataUtils {

	// retorna data com diferença de dias
	public static Date getDateDiffDias( int dias ) {
		
		Calendar calendarioAtual = Calendar.getInstance();
		
		calendarioAtual.add(Calendar.DAY_OF_MONTH, dias);
		return calendarioAtual.getTime();
	}
	
	// Obtem data formatada
	public static String getDateFormatter( Date data ) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data);
	}
	
}
