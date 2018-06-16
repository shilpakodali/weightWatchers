package com.weightwatchers.web.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.weightwatchers.web.pages.FindMeetingPage;
import com.weightwatchers.web.pages.HomePage;
import com.weightwatchers.web.testdata.TestData;

public class HoursOfOperationTest extends BaseWebTest {

	@Test()
	public void hoursOfOperation() {

		LOGGER.info("Test : Hours Of Operation");
		LOGGER.info("Navigate to " + TestData.URL);
		driver.get(TestData.URL);
		HomePage homePage = new HomePage(driver);
		LOGGER.info(String.format("Verify 'Landing' page title matches with %s", TestData.PAGE_TITLE));
		assertTrue(homePage.verifyPageTitleMatchesTo(TestData.PAGE_TITLE),
				String.format("%s does not match title", TestData.PAGE_TITLE));
		FindMeetingPage findMeetingPage = homePage.clickOnMeeting();
		LOGGER.info(String.format("Verify 'Find Meeting' page title matches with %s", TestData.FIND_MEETING_TITLE));
		assertTrue(findMeetingPage.verifyPageTitleContains(TestData.FIND_MEETING_TITLE),
				String.format("%s does not match title", TestData.FIND_MEETING_TITLE));
		findMeetingPage.enterZipCode(TestData.ZIP_CODE);

	}

}
