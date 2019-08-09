package com.tce.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tce.qa.base.TestBase;
import com.tce.qa.util.TestUtil;

public class WhiteboardPage extends TestBase {
	WebElement element;
	@FindBy(xpath = "//div[@class='ebook-box']")
	WebElement eBooksBox;
	@FindBy(xpath = "//div[@class='content-box']//div[1]")
	WebElement contentsBox;
	@FindBy(xpath = "//span[@class='class-details']")
	WebElement classDetails;
	@FindBy(xpath = "//a[contains(text(),'All My Classes')]")
	WebElement allClasses;
	@FindBy(xpath = "//a[contains(text(),'Recent Classes')]")
	WebElement recentClasses;
	@FindBy(xpath = "//p[contains(text(),'Choose a Grade')]")
	WebElement chooseAGrade;
	@FindBy(xpath = "//p[contains(text(),'Choose a Division')]")
	WebElement chooseADivision;
	@FindBy(xpath = "//p[contains(text(),'Choose a Subject')]")
	WebElement chooseASubject;
	@FindBy(xpath = "//div[@class='grade-selection'][1]")
	WebElement gradeSelection;
	@FindBy(xpath = "//div[@class='grade-selection'][2]")
	WebElement divisionSelection;
	@FindBy(xpath = "//div[@class='grade-selection'][3]")
	WebElement subjectSelection;
	@FindBy(xpath = "//body//img[2]")
	WebElement profile;
	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	WebElement signout;

	public WhiteboardPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyWhiteboardPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyEBookBox() {
		TestBase.driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		return eBooksBox.isDisplayed();
	}

	public boolean verifyContentsBox() {
		return contentsBox.isEnabled();
	}

	public void clickOnClassDetail() {
		classDetails.click();
	}

	public void clickOnAllMyClasses() {
		allClasses.click();
	}

	public void verifyAllClassesSections() {
		chooseAGrade.isDisplayed();
		chooseADivision.isDisplayed();
		chooseASubject.isDisplayed();
	}

	public void VerifySelectionOfGDS() throws InterruptedException {
		Actions action=new Actions(driver);
		// get all grade options from dropdown
		List<WebElement> gradeOptions = driver.findElements(By.xpath("//div[@class='grade-selection'][1]"));

		for (WebElement option1 : gradeOptions) {
			if (option1.getText().equals(prop.getProperty("grade"))) {
				option1.click();
			}
		}
		// get all division options from dropdown
		List<WebElement> divisionOptions = driver.findElements(By.xpath("//div[@class='grade-selection'][2]"));

		for (WebElement option2 : divisionOptions) {
			if (option2.getText().equals(prop.getProperty("division"))) {
				option2.click();
			}
		}
		// get all subject options from dropdown
		List<WebElement> subjectOptions = driver.findElements(By.xpath("//div[@class='grade-selection'][2]"));

		for (WebElement option3 : subjectOptions) {
			if (option3.getText().equals(prop.getProperty("subject"))) {
				Thread.sleep(20000);
				option3.click();
			}
		}
		
	}

	public void clickOnProfileIcon() {
		profile.click();
	}

	public LoginWithUserIDPasswordPage clickOnSignout() {
		signout.click();
		return new LoginWithUserIDPasswordPage();
	}
}
