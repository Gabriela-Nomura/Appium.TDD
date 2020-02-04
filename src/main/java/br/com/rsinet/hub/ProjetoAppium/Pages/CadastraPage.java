package br.com.rsinet.hub.ProjetoAppium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub.ProjetoAppium.Utils.Dados;

public class CadastraPage {
	/**
	 * Classe de manipulacao de webElements da pagina de cadastro
	 */
	final WebDriver driver;

	public CadastraPage(WebDriver driver) {
		this.driver = driver;
	}

	// Metodo que aguarda até que o elemento esteja disponivel para receber o clique
	private void waitUntil(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Encontra o campo de nome de usuario
	private WebElement nomeUsuarioBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText\r\n"));
	}

//Insere o nome de usuario de acordo com o valor lido pelo excel. i= linha a ser lida
	public void insereNomeUsuario(int i) throws Exception {
		waitUntil(nomeUsuarioBox());
		nomeUsuarioBox().sendKeys(Dados.userName(i));
	}

	private WebElement emailBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereEmail() throws Exception {
		emailBox().sendKeys(Dados.userEmail());
	}

	private WebElement senhaBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereSenha() throws Exception {
		senhaBox().sendKeys(Dados.userSenha());
	}

	private WebElement confirmaSenhaBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"));
	}

	public void insereSenhaConfirmacao() throws Exception {
		confirmaSenhaBox().sendKeys(Dados.userSenhaConfirmacao());
	}

	private WebElement primeiroNomeBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
	}

	public void inserePrimeiroNome() throws Exception {
		primeiroNomeBox().sendKeys(Dados.userPrimeiroNome());
	}

	private WebElement ultimoNomeBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
	}

	public void insereUltimoNome() throws Exception {
		ultimoNomeBox().sendKeys(Dados.userUltimoNome());
	}

	private WebElement telefoneBox() {
		return driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
	}
	public void insereTelefone() throws Exception {
		telefoneBox().sendKeys(Dados.userTelefone());
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
	public void clicaNoRegistro() {
		registraBotao().click();
	}
	
	private WebElement autorizacao() {
		return driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
	}
	public void autorizaLocalizacao() {
		autorizacao().click();
	}
	
//
//	public void clickOn_pais() {
//		paisUsuario.click();
//		Log.info("Seleciona a lista de pa�ses");
//	}
//
//	public void seleciona_pais() {
//		Select paisBox = new Select(CadastraPage.paisUsuario);
//		Log.info("Instancia um objeto select para manipula��o da lista");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Log.info("Driver recebeu um comando de espera implicito por 10 segundos");
//		paisBox.selectByVisibleText("Brazil");
//		Log.info("O pa�s Brazil foi selecionado");
//	}
//
//	public void sendUserCidade() throws Exception {
//		cidadeUsuario.sendKeys(constantes.userCidade());
//		Log.info("Insere a cidade do usu�rio");
//	}
//
//	public void sendUserEndereco() throws Exception {
//		enderecoUsuario.sendKeys(constantes.userEndereco());
//		Log.info("Insere o endere�o do usu�rio");

//	}
//
//	public void sendUserEstado() throws Exception {
//		estadoUsuario.sendKeys(constantes.userEstado());
//		Log.info("Insere o estado do usu�rio");
//	}
//
//	public void sendUserCep() throws Exception {
//		cepUsuario.sendKeys(constantes.userCep());
//		Log.info("Insere o CEP do usu�rio");
//	}
//
//	public void aceitaTermos() {
//		if (aceitaTermos.isSelected() == false)
//			aceitaTermos.click();
//		Log.info("A op��o de aceita��o dos termos de privacidade foi selecionada");
//	}
//
//	public void registaUser() {
//		registraUsuario.click();
//		Log.info("O link para registrar um novo usu�rio recebeu um clique");
//	}

}