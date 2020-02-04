package br.com.rsinet.hub.ProjetoAppium.Utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	/**
	 * Classe de configura��o do driver a executar os testes. Inicializa��o do
	 * navegador, defini��o da url, arquivo do excel e 
	 */
	static AndroidDriver driver;
	
	public static DesiredCapabilities capabilities = new DesiredCapabilities();

	public static AndroidDriver configDriver() throws Exception {
		
		capabilities.setCapability("deviceName", "CelularDaGabi");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.Advantage.aShopping");
		capabilities.setCapability("appActivity", ".SplashActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver driver = null;
		if (driver == null) {
		driver = new AndroidDriver<MobileElement>(url, capabilities);
		
		}
		return driver;
	}

	public static void configExcel() throws Exception {
		ConfigExcel.setExcelFile(Dados.Path_TestData, "Teste");
	}

	public static void encerra(WebDriver driver) {
		if (driver != null) {
			driver.close();
		}
	}
}
