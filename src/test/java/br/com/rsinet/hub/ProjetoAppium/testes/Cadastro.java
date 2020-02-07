package br.com.rsinet.hub.ProjetoAppium.testes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Screens.CadastraScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomeScreen;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class Cadastro {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private CadastraScreen cadastra;
	private HomeScreen home;
	private ExtentTest test;

	// Inicia o reporte
	@BeforeTest
	public void iniciaReport() {
		ExtentReport.setExtent();
	}

	// Instancia o driver, as paginas, as ações de toque e configura o arquivo de
	// excel
	@BeforeMethod
	public void inicioTeste() throws Exception {
		driver = DriverManager.configDriver();
		DriverManager.configExcel();
		cadastra = new CadastraScreen(driver);
		home = new HomeScreen(driver);
	}

	@Test
//@CadastroValido
	public void CadastroValido() throws Exception {
//Interacoes na tela inicial
		test = ExtentReport.createTest("CadastroValido ");
		test.createNode("Teste inicializado com sucesso ");
		home.clicaNoMenu();
		home.clicaNoLogin();
		home.clicaNaNovaConta();
//Pagina Cadastra - Dados da conta
		cadastra.insereNomeUsuario();
		cadastra.insereEmail();
		cadastra.insereSenha();
		cadastra.insereSenhaConfirmacao();
		cadastra.inserePrimeiroNome();
		cadastra.insereUltimoNome();
		cadastra.insereTelefone();
		cadastra.ajustaTela(driver, "REGISTER");
		cadastra.preencheEndereco();
		cadastra.autorizaLocalizacao();
		cadastra.clicaNoRegistro();
		test.createNode("As informacoes foram inseridas com sucesso ");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.clicaNoMenu();
		String nomeUsuarioCadastrado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"))
				.getText();
		Assert.assertTrue(nomeUsuarioCadastrado != null);
		test.createNode("O cadastro foi concluído, e um novo usuario foi registrado com sucesso ");
		test.createNode("O teste foi encerrado ");

	}

	@Test
	// @CadastroInvalido
	public void CadastroInvalido() throws Exception {
		// Interacoes na tela inicial
		test = ExtentReport.createTest("CadastroFalha");
		test.createNode("Teste inicializado com sucesso ");
		home.clicaNoMenu();
		home.clicaNoLogin();
		home.clicaNaNovaConta();
		// Pagina Cadastra - Dados da conta
		cadastra.insereNomeInvalido(1);
		cadastra.insereEmail();
		cadastra.insereSenha();
		cadastra.insereSenhaConfirmacao();
		cadastra.ajustaTela(driver, "REGISTER");
		cadastra.clicaNoRegistro();
		test.createNode("As informacoes foram inseridas com sucesso ");
		Assert.assertTrue(cadastra.botaoRegistraAtivo());
		test.createNode("O cadastro foi concluído, e um novo usuario nao foi registrado  ");
		test.createNode("O teste foi encerrado ");

	}

	@AfterMethod
	public void finalizaTeste(ITestResult result) throws Exception {
		ExtentReport.tearDown(result, test, driver);
//		DriverManager.configDriver().resetApp();
		DriverManager.encerra();
	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.endReport();

	}
}