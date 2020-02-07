package br.com.rsinet.hub.ProjetoAppium.testes;

import static org.testng.Assert.assertTrue;

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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class BuscaClique {
	/**
	 * Classe de teste da funcionalidade de busca por cliques
	 */
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private BuscaScreen busca;
	private HomeScreen home;
	ExtentTest test;
	TouchAction toque;

//Inicia o reporte
	@BeforeTest
	public void report() {
		ExtentReport.setExtent();
	}

//Instancia o driver, as paginas, as ações de toque  e configura o arquivo de excel
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverManager.configDriver();
		DriverManager.configExcel();
		busca = new BuscaScreen(driver);
		home = new HomeScreen(driver);
		toque = new TouchAction(driver);
	}

	@Test
	public void BuscaValida() throws Exception {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		test = ExtentReport.createTest("Busca por clique valida");
		test.createNode("Teste inicializado com sucesso ");
		home.clickHeadphones();
		busca.selecionaFone();
		test.createNode("A categoria Headphones e o primeiro resultado recebeu um clique ");
		AssertJUnit.assertTrue(busca.resultadoClique());
		test.createNode("O produto aberto corresponde ao produto que foi selecionado ");
		test.createNode("O teste foi encerrado ");

	}

	@Test
	public void BuscaInvalida() throws Exception {
		test = ExtentReport.createTest("Busca por clique Invalida");
		test.createNode("Teste inicializado com sucesso ");
		home.clickHeadphones();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		test.createNode("A categoria selecionada foi HeadPhone");
		busca.clicaNoFiltro();
		busca.selecionaFiltros();
		busca.aplicaFiltro();
		test.createNode("Foi aplicado um filtro de connector e compatibilidade ");
		assertTrue(busca.resultadoEsperado());
		test.createNode("A busca nao retornou nenhum resultado ");
		test.createNode("O teste foi encerrado ");
	}

	@AfterMethod
	public void encerraTest(ITestResult result) throws Exception {
		ExtentReport.tearDown(result, test, driver);
		DriverManager.configDriver().resetApp();

	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.endReport();
		DriverManager.encerra();

	}
}
