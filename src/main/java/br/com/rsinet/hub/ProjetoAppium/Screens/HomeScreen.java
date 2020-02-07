package br.com.rsinet.hub.ProjetoAppium.Screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;

public class HomeScreen {
	/**
	 * Classe de manipulacao de webElements da pagina inicial da aplicacao
	 */
	final WebDriver driver;
	// Configura o driver que sera utilizado na instancia dos objetos da classe

	public HomeScreen(WebDriver driver) {
		this.driver = driver;

	}

	// Metodo para aguardar visibilidade do elemento passado como parametro
	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//ícone menu da tela inicial recebe um clique
	private WebElement menuIcone() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu"));
	}

	public void clicaNoMenu() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
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

	private WebElement campoBusca() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/editTextSearch"));
	}

	public void insereValorLupaInvalido() throws Exception {
		waitUntil(campoBusca());
		campoBusca().sendKeys(MassaDeDados.buscaLupaFalha());
	}

	public void insereValorLupaValido() throws Exception {
		waitUntil(campoBusca());
		campoBusca().sendKeys(MassaDeDados.buscaLupa());
	}

	private WebElement lupaIcone() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewSearch"));
	}

	public void processaBusca() {
		lupaIcone().click();
	}

	public void clicaNaNovaConta() {
		waitUntil(novaConta());
		novaConta().click();
	}

	private WebElement  HeadPhone() {
		return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView"));
	}														

	public void clickHeadphones() {
		waitUntil(HeadPhone());
		HeadPhone().click();
	}

	private WebElement laptops() {
		return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView"));
	}
	public void clicaLaptop() {
		waitUntil(laptops());
		laptops().click();
	}
	
}
