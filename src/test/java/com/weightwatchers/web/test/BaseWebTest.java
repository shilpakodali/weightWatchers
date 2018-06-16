package com.weightwatchers.web.test;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseWebTest {

	public static WebDriver driver;
	public static final Logger LOGGER = Logger.getLogger(BaseWebTest.class.getName());

	@Parameters({ "browserName" })
	@BeforeTest
	public void initializeDriver(String browserName) {
		DOMConfigurator.configure("log4j.xml");
		LOGGER.info("====================================");
		LOGGER.info("===========Starting Test============");

		LOGGER.info("Launching " + browserName + " browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/java/resources/chromedriver");
			driver = new ChromeDriver();
		}

	}

	@AfterTest
	public void clean() {
		LOGGER.info("==================================");
		LOGGER.info("===========Ending Test============");
		driver.quit();
	}

}
