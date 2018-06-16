package com.weightwatchers.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.weightwatchers.web.util.WebHelper;

/**
 * 
 * @author shilpakodali
 *
 */
public class HomePage {

	public static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());
	private WebDriver driver;

	// Elements
	private By findAMeeting = By.cssSelector(".find-a-meeting");
	private By login = By.cssSelector("#ela-nav_profile_login");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		WebHelper.waitUntilVisible(driver, findAMeeting);

	}

	// Getters
	public WebElement getFindAMeeting() {
		return driver.findElement(findAMeeting);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	// Functions

	/**
	 * Click on 'Find A Meeting'
	 */
	public FindMeetingPage clickOnMeeting() {
		LOGGER.info("Click on Find a Meeting");
		this.getFindAMeeting().click();
		return new FindMeetingPage(driver);
	}

	/**
	 * Verify page title
	 * 
	 * @param titleText
	 * @return
	 */
	public boolean verifyPageTitleMatchesTo(String titleText) {
		LOGGER.info(String.format("Verify 'Landing' page title matches with %s", titleText));

		String title = driver.getTitle();
		if (title.equals(titleText)) {
			return true;
		} else {
			return false;
		}
	}
}
