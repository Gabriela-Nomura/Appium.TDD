package br.com.rsinet.hub.ProjetoAppium.Screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;
import br.com.rsinet.hub.ProjetoAppium.Utils.UserName;
import io.appium.java_client.android.AndroidDriver;

public class CadastraScreen {
	/**
	 * Classe de manipulacao de webElements da pagina de cadastro
	 */
	final WebDriver driver;

	// Configura o driver que sera utilizado na instancia dos objetos da classe
	public CadastraScreen(WebDriver driver) {
		this.driver = driver;

	}

	// Metodo de espera para aguardar visibilidade de elemento a interagir
	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Encontra o campo de nome de usuario
	private WebElement nomeUsuarioBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText\r\n"));
	}

//Insere o nome de usuario de acordo com a geracao de nome feita aleatoriamente com 10 carac
	public void insereNomeUsuario() {
		nomeUsuarioBox().sendKeys(UserName.getNomeUsuario(10));
	}

	// Insere o nome de usuario de acordo com a massa de dados o parametro i se
	// refere a linha que sera lida
	public void insereNomeInvalido(int i) throws Exception {
		waitUntil(nomeUsuarioBox());
		nomeUsuarioBox().sendKeys(MassaDeDados.userName(i));
	}

	private WebElement emailBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereEmail() throws Exception {
		emailBox().sendKeys(MassaDeDados.userEmail());
	}

	private WebElement senhaBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereSenha() throws Exception {
		senhaBox().sendKeys(MassaDeDados.userSenha());
	}
	private WebElement menuIcone() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu"));
	}

	public void clicaNoMenu() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		menuIcone().click();
	}
	private WebElement confirmaSenhaBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void ajustaTela(AndroidDriver driver, String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}

	public void insereSenhaConfirmacao() throws Exception {
		confirmaSenhaBox().sendKeys(MassaDeDados.userSenhaConfirmacao());
	}

	private WebElement primeiroNomeBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
	}

	public void inserePrimeiroNome() throws Exception {
		primeiroNomeBox().sendKeys(MassaDeDados.userPrimeiroNome());
	}

	private WebElement ultimoNomeBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
	}

	public void insereUltimoNome() throws Exception {
		ultimoNomeBox().sendKeys(MassaDeDados.userUltimoNome());
	}

	private WebElement telefoneBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereTelefone() throws Exception {
		telefoneBox().sendKeys(MassaDeDados.userTelefone());
	}

	private WebElement localizacao() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/switchLocation"));
	}

	public void preencheEndereco() {
		localizacao().click();
	}

	private WebElement registraBotao() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister"));
	}

	public boolean botaoRegistraAtivo() {
		return registraBotao().isEnabled();

	}

	public void clicaNoRegistro() {
		registraBotao().click();
	}

	private WebElement autorizacao() {
		return driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
	}

	public void autorizaLocalizacao() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		autorizacao().click();
	}
}