package com.weightwatchers.web.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weightwatchers.web.testdata.TestData;

/**
 * 
 * @author shilpakodali
 *
 */
public class Helper {
	public static final Logger LOGGER = Logger.getLogger(Helper.class.getName());

	/**
	 * Wait until element is visible
	 * 
	 * @param driver
	 * @param element
	 */
	public static void waitUntilVisible(WebDriver driver, By element) {
		LOGGER.info(String.format("Wait until %s is visible", element.toString()));
		WebDriverWait wait = new WebDriverWait(driver, TestData.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	/**
	 * Prints Line
	 */
	public static void printLine() {
		System.out.println("===================================================================");
	}

	/**
	 * Prints text in BOLD on console
	 * 
	 * @param text
	 */
	public static void printBold(String text) {
		System.out.println("\033[1m" + text + "\033[0m");
	}
}
