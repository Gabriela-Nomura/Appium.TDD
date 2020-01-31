package br.com.rsinet.hub.ProjetoAppium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver = null;		
	public WebDriver getDriver() {				
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver.exe");
		driver = new ChromeDriver();

		return driver;
	}
}
