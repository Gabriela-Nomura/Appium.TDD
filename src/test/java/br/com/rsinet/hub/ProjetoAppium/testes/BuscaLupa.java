package br.com.rsinet.hub.ProjetoAppium.testes;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Factory.DriverFactory;
import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomeScreen;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class BuscaLupa {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private BuscaScreen busca;
	private HomeScreen home;
	private ExtentReports relatorio;
	private ExtentTest buscaValida;
	private ExtentTest buscaInvalida;
	private String nomeDoTeste;

	// Inicia o reporte
	@BeforeTest
	public void iniciaReport() {
		relatorio = ExtentReport.iniciaRelatorio();
	}

	// Instancia o driver, as paginas e configura o arquivo do excel
	@BeforeMethod
	public void inicioTeste() throws Exception {
		driver = DriverFactory.iniciaDriver();
		DriverFactory.configExcel();
		busca = new BuscaScreen(driver);
		home = new HomeScreen(driver);
	}

	@Test
	public void BuscaInvalida() throws Exception {
		nomeDoTeste = "Busca invalida";
		buscaInvalida = ExtentReport.createTest("Cenario: Busca pela lupa invalida");
		buscaInvalida.createNode("Teste inicializado com sucesso ");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.insereValorLupaInvalido();
		buscaInvalida.createNode("O campo de busca recebeu os parametros enviados ");
		home.processaBusca();
		AssertJUnit.assertTrue(busca.semResultado());
		buscaInvalida.createNode("A busca nao retornou nenhum resultado, conforme esperado");
		buscaInvalida.createNode("O teste foi encerrado ");

	}

	@Test
	public void BuscaValida() throws Exception {
		nomeDoTeste = "Busca valida";
		buscaValida = ExtentReport.createTest("Cenario: Busca pela lupa valida");
		buscaValida.createNode("Teste inicializado com sucesso ");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.insereValorLupaValido();
		buscaValida.createNode("O campo de busca recebeu os parametros enviados ");
		home.processaBusca();
		AssertJUnit.assertTrue(busca.contemResultado());
		buscaValida.createNode("A busca retornou o resultado esperado ");
		buscaValida.createNode("O teste foi encerrado ");

	}

	@AfterMethod
	public void finalizaTeste(ITestResult result) throws Exception {
		if (nomeDoTeste == "Busca valida") {
			ExtentReport.tearDown(result, buscaValida, driver);
		} else if (nomeDoTeste == "Busca invalida") {
			ExtentReport.tearDown(result, buscaInvalida, driver);
		}
		DriverFactory.encerra();

	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.encerraReport(relatorio);

	}
}