package com.weightwatchers.web.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weightwatchers.web.testdata.TestData;

public class WebHelper {
	public static final Logger LOGGER = Logger.getLogger(WebHelper.class.getName());

	/**
	 * Wait until element is visible
	 * @param driver
	 * @param element
	 */
	public static void waitUntilVisible(WebDriver driver, By element) {
		LOGGER.info(String.format("Wait until %s is visible", element.toString()));
		WebDriverWait wait = new WebDriverWait(driver, TestData.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void printLine() {
		System.out.println("===================================================================");
	}
}
