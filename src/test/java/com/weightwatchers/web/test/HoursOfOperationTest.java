package com.weightwatchers.web.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.weightwatchers.web.pages.FindMeetingPage;
import com.weightwatchers.web.pages.HomePage;
import com.weightwatchers.web.pages.MeetingLocationPage;
import com.weightwatchers.web.testdata.TestData;

/**
 * 
 * @author shilpakodali
 *
 */
public class HoursOfOperationTest extends BaseWebTest {

	@Test()
	public void hoursOfOperation() {
		LOGGER.info("Test : Hours Of Operation");
		LOGGER.info("Navigate to " + TestData.URL);
		driver.get(TestData.URL);
		HomePage homePage = new HomePage(driver);
		
		assertTrue(homePage.verifyPageTitleMatchesTo(TestData.PAGE_TITLE),
				String.format("%s does not match title", TestData.PAGE_TITLE));
		
		FindMeetingPage findMeetingPage = homePage.clickOnMeeting();
		
		assertTrue(findMeetingPage.verifyPageTitleContains(TestData.FIND_MEETING_TITLE),
				String.format("%s does not match title", TestData.FIND_MEETING_TITLE));
		
		findMeetingPage.enterZipCodeAndClickSearch(TestData.ZIP_CODE);
		
		String searchResultTitle = findMeetingPage.getSearchResultTitleText();
		
		findMeetingPage.printFirstSearchResult();
		
		MeetingLocationPage meetingLocationPage = findMeetingPage.clickOnSearchResult();
		
		assertTrue(meetingLocationPage.verifyLocationTitleMatches(searchResultTitle),
				String.format("%s does not match location title", searchResultTitle));
		
		meetingLocationPage.printCurrentDayAndHours();
	}

}
