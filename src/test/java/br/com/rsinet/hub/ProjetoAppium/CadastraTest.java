package br.com.rsinet.hub.ProjetoAppium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub.ProjetoAppium.Pages.CadastraPage;
import br.com.rsinet.hub.ProjetoAppium.Pages.HomePage;
import br.com.rsinet.hub.ProjetoAppium.Utils.DriverManager;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CadastraTest {

	public static AndroidDriver driver;
	CadastraPage cadastra;
	HomePage home;
	TouchAction toque;
	ExtentReports extent;
	ExtentTest logger;

	@Before
	public void inicio() throws Exception {
		driver = DriverManager.configDriver();
		DriverManager.configExcel();
		cadastra = new CadastraPage(driver);
		home = new HomePage(driver);
		toque = new TouchAction(driver);
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Environment", "Teste automatizado");
		extent.addSystemInfo("User Name", "Gabriela Nomura");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@Test
 
	public void TestInicio() throws Exception {
//Interacoes na tela inicial
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		home.clicaNoMenu();
		home.clicaNoLogin();
		home.clicaNaNovaConta();

//Pagina Cadastra - Dados da conta
		cadastra.insereNomeUsuario(4);
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

		logger = extent.startTest("Cadastro de usuario valido");
		logger.log(LogStatus.PASS, "Um novo usuario foi cadastrado com sucesso");
	}

//
	@After
// Sera necesario
	
	public void encerra() {
//		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//		DriverManager.encerra(driver);
//	}
}
}