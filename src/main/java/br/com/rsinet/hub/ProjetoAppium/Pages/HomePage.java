package br.com.rsinet.hub.ProjetoAppium.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	/**
	 * Classe de manipulacao de webElements da pagina inicial da aplicacao
	 */
	final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	// Metodo para aguardar visibilidade do elemento passado como parametro
	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//ícone menu da tela inicial recebe um clique
	private WebElement menuIcone() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu"));
	}

	public void clicaNoMenu() {
		menuIcone().click();
	}

//acessa o login de usuarios
	private WebElement loginIcone() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
	}

	public void clicaNoLogin() {
		waitUntil(loginIcone());
		loginIcone().click();
	}

//acessa a criacao de um novo user
	private WebElement novaConta() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewSingUpToday"));

	}

	public void clicaNaNovaConta() {
		waitUntil(novaConta());
		novaConta().click();
//		novaConta.sendKeys(Keys.ENTER);
	}
}
//
//	public void seleciona() {
//		produtoSeleciona.click();
//	}
//
//	public boolean logadoNomeUser() throws Exception {
//
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, 15);
//			wait.until(ExpectedConditions.textToBePresentInElement(userText, constantes.userName(3)));
//		} catch (Exception e) {
//
//			return userText.isDisplayed();
//		}
//		return userText.isDisplayed();
//	}
//
//	public void clickOn_HeadPhone() {
//		waitUntil(HeadPhones);
//		HeadPhones.click();
//		Log.info("A categoria de Headphones recebeu um clique");
//	}
//
//	public void clickOn_produtos() {
//		waitUntil(produto);
//		produto.click();
//		Log.info("O produto selecionado recebeu um clique");
//	}
//
//	public void clickOn_busca() {
//		waitUntil(busca);
//		busca.click();
//		Log.info("O �cone de busca recebeu um clique");
//	}
//
//	public void sendText_buscaFalha() throws Exception {
//		waitUntil(buscaBox);
//		buscaBox.sendKeys(constantes.buscaLupaFalha());
//		Log.info("O �cone de busca recebeu um clique");
//		buscaBox.sendKeys(Keys.ENTER);
//	}
//
//	public void sendText_busca() throws Exception {
//		waitUntil(buscaBox);
//		buscaBox.sendKeys(constantes.buscaLupa());
//		Log.info("O �cone de busca recebeu um clique");
//		buscaBox.sendKeys(Keys.ENTER);
//	}
//}
