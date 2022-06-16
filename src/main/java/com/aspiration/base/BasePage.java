package com.aspiration.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties pros;

	public WebDriver init_Driver() {
//		pros = init_Properties();
		ConfigReader.readProperties("./src/main/java/com/aspiration/config/config.properties");
		String browser = ConfigReader.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser name not found !");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.manage().deleteAllCookies();

		driver.get(ConfigReader.getProperty("url"));

		return driver;

	}
//
//	public Properties init_Properties() {
//		pros = new Properties();
//		String configPath = "./src/main/java/com/aspiration/config/config.properties";
//		try {
//			FileInputStream file = new FileInputStream(configPath);
//			pros.load(file);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return pros;
//	}

	public void tearDown() {
		driver.quit();
	}
}