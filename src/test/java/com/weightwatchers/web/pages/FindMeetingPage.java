package com.weightwatchers.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.weightwatchers.web.testdata.TestData;
import com.weightwatchers.web.util.WebHelper;

public class FindMeetingPage {

	private WebDriver driver;
	public static final Logger LOGGER = Logger.getLogger(FindMeetingPage.class.getName());

	public FindMeetingPage(WebDriver driver) {
		this.driver = driver;
		WebHelper.waitUntilVisible(driver, zipCodeSearch);
	}

	private By zipCodeSearch = By.cssSelector("#meetingSearch");

	public WebElement getZipCodeSearch() {
		return driver.findElement(zipCodeSearch);
	}

	// Functions
	public boolean verifyPageTitleContains(String pageTitle) {
		String title = driver.getTitle();
		if (title.contains(pageTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public void enterZipCode(String zipCode) {
		LOGGER.info(String.format("Enter zip code %s", TestData.ZIP_CODE));
		this.getZipCodeSearch().sendKeys(zipCode);
	}
}
