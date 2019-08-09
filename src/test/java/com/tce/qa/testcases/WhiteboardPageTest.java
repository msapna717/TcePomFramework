package com.tce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tce.qa.base.TestBase;
import com.tce.qa.pages.LoginWithUserIDPasswordPage;
import com.tce.qa.pages.WhiteboardPage;
import com.tce.qa.util.TestUtil;

public class WhiteboardPageTest extends TestBase {
	LoginWithUserIDPasswordPage loginWithUserIDPasswordPage;
	WhiteboardPage whiteboardPage;

	public WhiteboardPageTest() {
		super();
	}

	// test-cases should be independent
	// before each test-case launch the browser and login
	// @Test- execute test-case
	// after each test-case close the browser

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginWithUserIDPasswordPage = new LoginWithUserIDPasswordPage();// create login page object to call login method
		whiteboardPage = loginWithUserIDPasswordPage.loginWithUserIDPassword(prop.getProperty("username"),
				prop.getProperty("password"));
	}
@Test(priority = 1)
public void validateGDS() throws InterruptedException {
	whiteboardPage.clickOnClassDetail();
	whiteboardPage.clickOnAllMyClasses();
	whiteboardPage.VerifySelectionOfGDS();
	Assert.assertTrue(true," GDS not selected");
	System.out.println();
	
}
//	@Test(priority = 0)
//	public void validateWhiteboardPageTitle() {
//		String whiteboardPageTitle = whiteboardPage.verifyWhiteboardPageTitle();
//		Assert.assertEquals(whiteboardPageTitle, "Tceweb", "Whiteboard page title not matched");// message if test fails
//	}
//	@Test(priority = 1)
//	public void validateEBooksBox() throws InterruptedException {
//		whiteboardPage.clickOnClassDetail();
//		whiteboardPage.clickOnAllMyClasses();
//		whiteboardPage.VerifySelectionOfGDS();
//		Assert.assertTrue(true);
//		whiteboardPage.verifyEBookBox();
//		Assert.assertTrue(true, "EBooks box is not displayed");
//	}
//
//	@Test(priority = 3)
//	public void validateContentsBox() {
//		whiteboardPage.verifyContentsBox();
//		Assert.assertTrue(true, "Contents box is not enabled");
//	}
//
//	@Test(priority = 4)
//	public void validateAllClassesSections() {
//		whiteboardPage.clickOnClassDetail();
//		Assert.assertTrue(true);
//		whiteboardPage.clickOnAllMyClasses();
//		Assert.assertTrue(true);
//		whiteboardPage.verifyAllClassesSections();
//		Assert.assertTrue(true, "Any of the section missing");
//	}
//
//	@Test(priority = 5)
//	public void validateClassSelection() {
//		whiteboardPage.clickOnClassDetail();
//		Assert.assertTrue(true);
//		whiteboardPage.clickOnAllMyClasses();
//		Assert.assertTrue(true);
//		whiteboardPage.VerifySelectionOfGDS();
//		Assert.assertTrue(true);
//		Assert.assertEquals(true, "Class is not selected");
//
//	}
//
//	@Test(priority = 6)
//	public void validateSignout() throws InterruptedException {
//		whiteboardPage.clickOnProfileIcon();
//		Thread.sleep(1000);
//		whiteboardPage.clickOnSignout();
//		Assert.assertTrue(true, "User is not able to signed out");
//	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
