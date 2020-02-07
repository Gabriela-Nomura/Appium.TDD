package br.com.rsinet.hub.ProjetoAppium.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscaScreen {
	/**
	 * Classe de manipulacao de elementos das paginas de buscas
	 */
	final WebDriver driver;
	
//Configura o driver que sera utilizado na instancia dos objetos da classe
	
	public BuscaScreen(WebDriver driver) {
		this.driver = driver;
	}
//Metodo de espera para aguardar visibilidade de elemento a interagir
	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean semResultado() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")).isDisplayed();
	}

	private WebElement resultado() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/RelativeLayoutProductControl"));
	}

	public boolean contemResultado() {
		
		waitUntil(resultado());
		return resultado().isDisplayed();
	}

	private WebElement fone() {
		return driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc=\"Headphones\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.ImageView"));

	}

	public void selecionaFone() {
		waitUntil(fone());
		fone().click();
	}

	public boolean resultadoClique() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).isDisplayed();
	}

	private WebElement filtro() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewFilter"));
	}
	
	public void clicaNoFiltro() {
		waitUntil(fone());
		filtro().click();
	}
	private WebElement byCompability() {
		return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
	}
	private WebElement compability() {
		return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView"));
	}

	private WebElement byConnector() {
	return 	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView"));
	}
	private WebElement connector(){
	return  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView"));
	}

	
	public void selecionaFiltros() {
		byCompability().click();
		compability().click();
		byConnector().click();
		connector().click();
	}

	private WebElement selecionaFiltro() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewApply"));
	}
	public void aplicaFiltro() {
		selecionaFiltro().click();
	}
	public boolean resultadoEsperado() {
	return	driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")).isDisplayed();
	}
}
