 	package br.com.rsinet.hub.ProjetoAppium.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;

public class ExtentReport {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static ExtentReports extent;

	
	public static ExtentReports iniciaRelatorio() {
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/target/Relatorio.html");

		htmlReporter.config().setDocumentTitle("Relatorio de teste automatizados");// Titulo do documento
		htmlReporter.config().setReportName("Aplicacao mobie -TDD");// Nome do reporte
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Gabriela Nomura");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		return extent;
	}

	public static void encerraReport(ExtentReports extent) {
		extent.flush();
	}

	public static ExtentTest createTest(String testName) {
		return extent.createTest(testName);
	}

	public static void tearDown(ITestResult result, ExtentTest test, AndroidDriver driver) throws Exception {
		String caminho = Prints.tirarPrints(driver, result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "O teste falhou " + result.getName()); 
			
			test.log(Status.FAIL, "O teste falhou " + result.getThrowable()); 
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "O caso de teste foi pulado " + result.getName());
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "O de teste passou " + result.getName());
			
		}
		test.addScreenCaptureFromPath(caminho);
	}
}
