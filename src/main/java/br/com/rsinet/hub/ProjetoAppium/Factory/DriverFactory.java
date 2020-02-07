package br.com.rsinet.hub.ProjetoAppium.Factory;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.rsinet.hub.ProjetoAppium.Utils.MassaDeDados;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	/**
	 * Classe de configura��o do driver a executar os testes. Inicializa��o do
	 * navegador, defini��o da url, arquivo do excel e
	 */
	@SuppressWarnings("rawtypes")
	static AndroidDriver driver;

	public static DesiredCapabilities capabilities = new DesiredCapabilities();

	public static AndroidDriver iniciaDriver() throws Exception {

		capabilities.setCapability("deviceName", "CelularDaGabi");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.Advantage.aShopping");
		capabilities.setCapability("appActivity", ".SplashActivity");
		capabilities.setCapability("newCommandTimeout", "120");
		URL url = new URL("http://127.0.0.1:4724/wd/hub");

		AndroidDriver driver = null;
		if (driver == null) {
			driver = new AndroidDriver<MobileElement>(url, capabilities);

		}
		return driver;
	}

	public static void configExcel() throws Exception {
		MassaDeDados.setExcelFile(MassaDeDados.Path_TestData, "Teste");
	}

	public static WebDriver encerra() {
		if (driver != null) {
			driver.quit();
		}
		return driver = null;
	}
}
