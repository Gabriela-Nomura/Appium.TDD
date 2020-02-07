package br.com.rsinet.hub.ProjetoAppium.testes;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomeScreen;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class BuscaLupa {
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private BuscaScreen busca;
	private HomeScreen home;
	private ExtentTest test;

	// Inicia o reporte
	@BeforeTest
	public void iniciaReport() {
		ExtentReport.setExtent();
	}

	// Instancia o driver, as paginas e configura o arquivo do excel
	@BeforeMethod
	public void inicioTeste() throws Exception {
		driver = DriverManager.configDriver();
		DriverManager.configExcel();
		busca = new BuscaScreen(driver);
		home = new HomeScreen(driver);
	}

	@Test
	public void BuscaInvalida() throws Exception {
		test = ExtentReport.createTest("Buscapelalupainvalida");
		test.createNode("Teste inicializado com sucesso ");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.insereValorLupaInvalido();
		test.createNode("O campo de busca recebeu os parametros enviados ");
		home.processaBusca();
		AssertJUnit.assertTrue(busca.semResultado());
		test.createNode("A busca nao retornou nenhum resultado, conforme esperado");
		test.createNode("O teste foi encerrado ");

	}

	@Test
	public void BuscaValida() throws Exception {
		test = ExtentReport.createTest("Buscapelalupavalida");
		test.createNode("Teste inicializado com sucesso ");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.insereValorLupaValido();
		test.createNode("O campo de busca recebeu os parametros enviados ");
		home.processaBusca();
		AssertJUnit.assertTrue(busca.contemResultado());
		test.createNode("A busca retornou o resultado esperado ");
		test.createNode("O teste foi encerrado ");

	}

	@AfterMethod
	public void finalizaTeste(ITestResult result) throws Exception {
		ExtentReport.tearDown(result, test, driver);
		DriverManager.configDriver().resetApp();

	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.endReport();
		DriverManager.encerra();

	}
}