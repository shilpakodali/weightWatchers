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
public class MeetingLocationPage {

	private WebDriver driver;
	public static final Logger LOGGER = Logger.getLogger(MeetingLocationPage.class.getName());

	public MeetingLocationPage(WebDriver driver) {
		this.driver = driver;
		WebHelper.waitUntilVisible(driver, joinMeeting);
	}

	// Elements
	private By locationTitle = By.cssSelector(".location__name>span");
	private By joinMeeting = By.cssSelector(".btn.meeting-information__link.spice-translated");
	private By currentDay = By.cssSelector(".hours-list-item-wrapper.hours-list--currentday > .hours-list-item-day");
	private By currentDayHours = By
			.cssSelector(".hours-list-item-wrapper.hours-list--currentday > .hours-list-item-hours >div");

	// Getters
	public WebElement getJoinMeetingButton() {
		return driver.findElement(joinMeeting);
	}

	public WebElement getLocationTitle() {
		return driver.findElement(locationTitle);
	}

	public WebElement getCurrentDay() {
		return driver.findElement(currentDay);
	}

	public WebElement getCurrentDayHours() {
		return driver.findElement(currentDayHours);
	}

	// Functions
	public boolean verifyLocationTitleMatches(String titleText) {
		LOGGER.info(String.format("Verify Location title matches with %s", titleText));
		String title = this.getLocationTitle().getText();
		if (title.equals(titleText)) {
			return true;
		} else {
			return false;
		}
	}

	public void printCurrentDayAndHours() {
		WebHelper.printLine();
		LOGGER.info("Printing Current Day and Working Hours");
		System.out.println("Current Day: " + this.getCurrentDay().getText());
		System.out.println("Current Day Working Hours: " + this.getCurrentDayHours().getText());
		WebHelper.printLine();
	}
}
