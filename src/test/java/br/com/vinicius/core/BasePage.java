package br.com.vinicius.core;

import static br.com.vinicius.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Classe BasePage respons�vel por utilizar o construtor para a DSL.
 * @author Vinicius-PC
 */
public class BasePage {

	/********* TextField e TextArea ( INICIO ) ************/

	public void escreveById(By by, String text) {

		getDriver().findElement(by).clear();

		getDriver().findElement(by).sendKeys(text);
	}

	public void escreve(String idCampo, String text) {
		escreveById(By.id(idCampo), text);
	}

	public String getValueFromTextField(String idCampo) {
		return getDriver().findElement(By.id(idCampo)).getAttribute("value");
	}

	/********* TextField e TextArea ( FIM ) ************/

	/********* Radio e Check ( INICIO ) ************/

	public void clickRadioButtonBy(By by) {
		getDriver().findElement(by).click();
	}

	public void clickRadioButton(String idRadio) {
		clickRadioButtonBy(By.id(idRadio));
	}

	public void clickCheckBox(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public boolean isCheckBoxSelected(String id) {
		return getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).isSelected();
	}

	public boolean isRadioButtonSelected(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	/********* Radio e Check ( FIM ) ************/

	/********* Select combo box ( INICIO ) ************/

	public void selectCombobox(String id, String value) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}

	public void deselecionarCombo(String id, String valor) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String getValueCombobox(String id) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> getValuesCombobox(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	public int getQuantidadesCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean checkCombo(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}

	public void selecionarComboPrimeFaces(String radical, String valor) {

		clickRadioButtonBy(By.xpath("//*[@id='" + radical + "_input']/../..//span"));
		clickRadioButtonBy(By.xpath("//*[@id='" + radical + "_items']//li[.='" + valor + "']"));
	}

	/********* Select combo box ( FIM ) ************/

	/********* Button ( INICIO ) ************/

	public void clickButton(By by) {

		getDriver().findElement(by).click();
	}
	
	public void clickButton(String idButton) {

		clickButton(By.id(idButton));
	}
	
	public void clicarBotaoText( String text ) {
		clickButton(By.xpath("//button[.='"+text+"']"));
	}

	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}

	/********* Button ( FIM ) ************/

	/********* Link ( INICIO ) ************/

	public void clickLink(String link) {

		getDriver().findElement(By.linkText(link)).click();
	}

	/********* Link ( FIM ) ************/

	/********* Textos ( INICIO ) ************/

	public String getXPath(By by) {

		return getDriver().findElement(by).getText();
	}

	public String getText(String id) {

		return getXPath(By.id(id));
	}

	/********* Textos ( FIM ) ************/

	/********* Alert ( INICIO ) ************/

	public String alertaObterText() {

		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}

	public String obterTextAlertAndAccept() {

		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();

		return valor;
	}

	public String obterTextAlertAndDenied() {

		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();

		return valor;
	}

	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}

	/********* Alert ( FIM ) ************/

	/********* Frames e Janelas ( INICIO ) ************/

	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}

	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}

	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}

	/********* Frames e Janelas ( FIM ) ************/

	/********* Manipulando e iterando elementos com JS ***********/
	public Object executarJavaScript(String comando, Object... param) {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(comando, param);

	}

	/*************** Tabela *********************/

	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {

		// procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// em que coluna esta o bot�o para clicar
		int idColunaButton = obterIndiceColuna(colunaBotao, tabela);

		// clicar no bot�o da celular encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaButton + "]"));
		return celula;
	}
	
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {

		// clicar no bot�o da celular encontrada
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
	}

	private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {

				idLinha = i + 1;
				break;
			}
		}

		return idLinha;
	}

	private int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));

		int idColuna = -1;

		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {

				idColuna = i + 1;
				break;
			}
		}

		return idColuna;
	}
}
