package br.com.rsinet.hub.ProjetoAppium.testes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Pages.CadastraPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Cadastro {

	public static AndroidDriver driver;
	CadastraPage cadastra;
	HomePage home;
	TouchAction toque;
	private ExtentTest test;

	
	@BeforeSuite
	public void inicio() throws Exception {
		ExtentReport.setExtent();
		driver = DriverManager.configDriver();
		DriverManager.configExcel();
		cadastra = new CadastraPage(driver);
		home = new HomePage(driver);
		toque = new TouchAction(driver);
	}

	@Test
//@CadastroValido
	public void CadastroValido() throws Exception {
//Interacoes na tela inicial
		test = ExtentReport.createTest("CadastroSucesso");

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
		toque.press(PointOption.point(860, 1400)).moveTo(PointOption.point(814, 300)).release().perform();
		cadastra.preencheEndereco();
		cadastra.autorizaLocalizacao();
		cadastra.clicaNoRegistro();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.clicaNoMenu();
		String nomeUsuarioCadastrado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"))
				.getText();
		Assert.assertTrue(nomeUsuarioCadastrado != null);

	}

	@Test
	public void CadastroInvalido() throws Exception {
		// Interacoes na tela inicial
		test = ExtentReport.createTest("CadastroFalha");
		home.clicaNoMenu();
		home.clicaNoLogin();
		home.clicaNaNovaConta();
		// Pagina Cadastra - Dados da conta
		cadastra.insereNomeInvalido(1);
		cadastra.insereEmail();
		cadastra.insereSenha();
		cadastra.insereSenhaConfirmacao();
		toque.press(PointOption.point(860, 1400)).moveTo(PointOption.point(814, 300)).release().perform();
		cadastra.clicaNoRegistro();

		Assert.assertTrue(cadastra.botaoRegistraAtivo());
	}

	@AfterMethod
	public void encerraReport(ITestResult result)  throws Exception{
        ExtentReport.tearDown(result, test, driver);
        ExtentReport.endReport();
        DriverManager.encerra(driver);
	}
}