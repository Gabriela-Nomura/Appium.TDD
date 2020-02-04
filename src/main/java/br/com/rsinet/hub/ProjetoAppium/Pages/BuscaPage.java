package br.com.rsinet.hub.ProjetoAppium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;

public class BuscaPage {
	/**
	 * Classe de manipulacao de webElements das paginas de buscas
	 */
	final WebDriver driver;

	public BuscaPage(WebDriver driver) {
		this.driver = driver;
	}

	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean semResultado() {
		return  driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")).isDisplayed();
	}

	public boolean contemResultado() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/RelativeLayoutProductControl")).isDisplayed();
	}

	private WebElement fone() {
	return driver.findElement(By.xpath("/android.widget.RelativeLayout[@content-desc=\"Headphones\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.TextView[1]"));
	}
	
	public void selecionaFone() {
		waitUntil(fone());
		fone().click();
	}
	
	public boolean resultadoClique() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).isDisplayed();
	}
	
	
	
	
}
