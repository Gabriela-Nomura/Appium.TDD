package br.com.rsinet.hub.ProjetoAppium.testes;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Pages.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BuscaClique {
	/**
	 * Classe de teste da funcionalidade de busca por cliques
	 */
	public static AndroidDriver driver;
	private BuscaPage busca;
	private HomePage home;
	private TouchAction toque;
	ExtentTest test;

//Inicia o reporte
	@BeforeTest
	public void report() {
		ExtentReport.setExtent();
	}

//Instancia o driver, as paginas, as ações de toque  e configura o arquivo de excel
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverManager.configDriver();
		DriverManager.configExcel();
		busca = new BuscaPage(driver);
		home = new HomePage(driver);
		toque = new TouchAction(driver);
	}

	@Test
	public void BuscaValida() throws Exception {

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		test = ExtentReport.createTest("Buscaporcliquevalida");
		home.clickHeadphones();
		busca.selecionaFone();
		AssertJUnit.assertTrue(busca.resultadoClique());
	}

	@AfterMethod
	public void finalizaReporta(ITestResult result) throws Exception {
		ExtentReport.tearDown(result, test, driver);
//		DriverManager.encerra(driver);
	}

	@AfterTest
	public void encerraReport() {
		ExtentReport.endReport();

	}
}
