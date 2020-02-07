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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Factory.DriverFactory;
import br.com.rsinet.hub.ProjetoAppium.Screens.CadastraScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomeScreen;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class Cadastro {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private CadastraScreen cadastra;
	private HomeScreen home;
	private ExtentReports relatorio;
	private ExtentTest cadastroValido;
	private ExtentTest cadastroInvalido;
	private String nomeDoTeste;

	// Inicia o reporte
	@BeforeTest
	public void iniciaReport() {
		relatorio = ExtentReport.iniciaRelatorio();
	}

	// Instancia o driver, as paginas, as ações de toque e configura o arquivo de
	// excel
	@BeforeMethod
	public void inicioTeste() throws Exception {
		driver = DriverFactory.iniciaDriver();
		DriverFactory.configExcel();
		cadastra = new CadastraScreen(driver);
		home = new HomeScreen(driver);
	}

	@Test
//@CadastroValido
	public void CadastroValido() throws Exception {
//Interacoes na tela inicial
		nomeDoTeste = "Cadastro Valido";
		cadastroValido = ExtentReport.createTest("Cenario: Cadastro valido ");
		cadastroValido.createNode("Teste inicializado com sucesso ");
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
		cadastroValido.createNode("As informacoes foram inseridas com sucesso ");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.clicaNoMenu();
		String nomeUsuarioCadastrado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"))
				.getText();
		Assert.assertTrue(nomeUsuarioCadastrado != null);
		cadastroValido.createNode("O cadastro foi concluído, e um novo usuario foi registrado com sucesso ");
		cadastroValido.createNode("O teste foi encerrado ");

	}

	@Test
	// @CadastroInvalido
	public void CadastroInvalido() throws Exception {
		// Interacoes na tela inicial
		nomeDoTeste = "Cadastro Invalido";
		cadastroInvalido = ExtentReport.createTest("Cenario: Cadastro invalido");
		cadastroInvalido.createNode("Teste inicializado com sucesso ");
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
		cadastroInvalido.createNode("As informacoes foram inseridas com sucesso ");
		Assert.assertTrue(cadastra.botaoRegistraAtivo());
		cadastroInvalido.createNode("O cadastro foi concluído, e um novo usuario nao foi registrado  ");
		cadastroInvalido.createNode("O teste foi encerrado ");

	}

	@AfterMethod
	public void encerraTest(ITestResult result) throws Exception {
		if (nomeDoTeste == "Cadastro Valido") {
			ExtentReport.tearDown(result, cadastroValido, driver);
		} else if (nomeDoTeste == "Cadastro Invalido") {
			ExtentReport.tearDown(result, cadastroInvalido, driver);
		}
DriverFactory.encerra();
//		DriverFactory.iniciaDriver().resetApp();
	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.encerraReport(relatorio);

	}
}