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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Factory.DriverFactory;
import br.com.rsinet.hub.ProjetoAppium.Screens.BuscaScreen;
import br.com.rsinet.hub.ProjetoAppium.Screens.HomeScreen;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.android.AndroidDriver;

public class BuscaClique {
	/**
	 * Classe de teste da funcionalidade de busca por cliques
	 */
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	private BuscaScreen busca;
	private HomeScreen home;
	private ExtentReports relatorio;
	private ExtentTest buscaPositiva;
	private ExtentTest buscaNegativa;
	private String nomeDoTeste;

//Inicia o reporte
	@BeforeTest
	public void iniciaReport() {
		relatorio = ExtentReport.iniciaRelatorio();
	}

//Instancia o driver, as paginas, as ações de toque  e configura o arquivo de excel
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverFactory.iniciaDriver();
		DriverFactory.configExcel();
		busca = new BuscaScreen(driver);
		home = new HomeScreen(driver);
	}

	@Test
	public void BuscaValida() throws Exception {
		nomeDoTeste = "Busca valida";
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		buscaPositiva = ExtentReport.createTest("Cenario: Busca por clique valida");
		buscaPositiva.createNode("Teste inicializado com sucesso ");
		home.clickHeadphones();
		busca.selecionaFone();
		buscaPositiva.createNode("A categoria Headphones e o primeiro resultado recebeu um clique ");
		AssertJUnit.assertTrue(busca.resultadoClique());
		buscaPositiva.createNode("O produto aberto corresponde ao produto que foi selecionado ");
		buscaPositiva.createNode("O teste foi encerrado ");

	}

	@Test
	public void BuscaInvalida() throws Exception {
		nomeDoTeste = "Busca invalida";
		buscaNegativa = ExtentReport.createTest("Cenario: Busca por clique Invalida");
		buscaNegativa.createNode("Teste inicializado com sucesso ");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.clickHeadphones();
		buscaNegativa.createNode("A categoria selecionada foi HeadPhone");
		busca.clicaNoFiltro();
		busca.selecionaFiltros();
		busca.aplicaFiltro();
		buscaNegativa.createNode("Foi aplicado um filtro de connector e compatibilidade ");
		assertTrue(busca.resultadoEsperado());
		buscaNegativa.createNode("A busca nao retornou nenhum resultado ");
		buscaNegativa.createNode("O teste foi encerrado ");
	}

	@AfterMethod
	public void encerraTest(ITestResult result) throws Exception {
		if (nomeDoTeste == "Busca valida") {
			ExtentReport.tearDown(result, buscaPositiva, driver);
		} else if (nomeDoTeste == "Busca invalida") {
			ExtentReport.tearDown(result, buscaNegativa, driver);
		}
		DriverFactory.encerra();
	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.encerraReport(relatorio);

	}
}
