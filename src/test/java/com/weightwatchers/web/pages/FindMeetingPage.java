package com.weightwatchers.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.weightwatchers.web.testdata.TestData;
import com.weightwatchers.web.util.Helper;

/**
 * 
 * @author shilpakodali
 *
 */
public class FindMeetingPage {

	private WebDriver driver;
	public static final Logger LOGGER = Logger.getLogger(FindMeetingPage.class.getName());

	public FindMeetingPage(WebDriver driver) {
		this.driver = driver;
		Helper.waitUntilVisible(driver, zipCodeSearch);
	}

	// Elements
	private By zipCodeSearch = By.cssSelector("#meetingSearch");

	private By searchButton = By.cssSelector(".btn.btn-default.form-blue-pill__btn");

	private By firstSearchResultsTitle = By.cssSelector(".location__name:nth-child(1) > span");

	private By firstSearchResultsDistance = By.cssSelector(".location__distance");

	// Getters
	public WebElement getZipCodeSearch() {
		return driver.findElement(zipCodeSearch);
	}

	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement getFirstSearchResultsTitle() {
		return driver.findElement(firstSearchResultsTitle);
	}

	public WebElement getFirstSearchResultsDistance() {
		return driver.findElement(firstSearchResultsDistance);
	}

	// Functions
	public boolean verifyPageTitleContains(String pageTitle) {
		LOGGER.info(String.format("Verify 'Find Meeting' page title matches with %s", pageTitle));
		String title = driver.getTitle();
		if (title.contains(pageTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public void enterZipCodeAndClickSearch(String zipCode) {
		LOGGER.info(String.format("Enter zip code %s", TestData.ZIP_CODE));
		this.getZipCodeSearch().sendKeys(zipCode);
		LOGGER.info("Click on Search Button");
		this.getSearchButton().click();
	}

	public void printFirstSearchResult() {
		Helper.waitUntilVisible(driver, firstSearchResultsTitle);
		String title = this.getFirstSearchResultsTitle().getText();
		String distance = this.getFirstSearchResultsDistance().getText();
		Helper.printLine();
		LOGGER.info("Printing first search results on to console");
		Helper.printBold("First Search Result Title: " + title);
		Helper.printBold("First Search Result Distance: " + distance);
		Helper.printLine();
	}

	public String getSearchResultTitleText() {
		LOGGER.info("Get text of search result title");
		Helper.waitUntilVisible(driver, firstSearchResultsTitle);
		return this.getFirstSearchResultsTitle().getText();
	}

	public MeetingLocationPage clickOnSearchResult() {
		LOGGER.info("Click on First search result");
		this.getFirstSearchResultsTitle().click();
		return new MeetingLocationPage(driver);
	}
}
