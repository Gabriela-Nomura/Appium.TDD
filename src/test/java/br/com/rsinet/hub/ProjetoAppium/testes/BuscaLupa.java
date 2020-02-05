package br.com.rsinet.hub.ProjetoAppium.testes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.ProjetoAppium.Manager.DriverManager;
import br.com.rsinet.hub.ProjetoAppium.Pages.BuscaPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.ExtentReport;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BuscaLupa {
	public static AndroidDriver driver;
	BuscaPage busca;
	HomePage home;
	TouchAction toque;
	private ExtentTest test;
	
	@BeforeMethod
	public void inicio() throws Exception {
		driver = DriverManager.configDriver();
		DriverManager.configExcel();
		busca = new BuscaPage(driver);
		home = new HomePage(driver);
		toque = new TouchAction(driver);
		ExtentReport.setExtent();
	
	}

	@Test
	public void BuscaInvalida() throws Exception {

		home.insereValorLupaInvalido();
		home.processaBusca();
		AssertJUnit.assertTrue(busca.semResultado());
	}

	@Test
	public void BuscaValida() throws Exception {
		home.insereValorLupaValido();
		home.processaBusca();
		AssertJUnit.assertTrue(busca.contemResultado());
		ExtentReport.endReport();
	}

	
	
	@AfterMethod
	public void finalizaReporta(ITestResult  result) throws Exception {
		ExtentReport.tearDown(result, test, driver);
		DriverManager.encerra(driver);
	}
}