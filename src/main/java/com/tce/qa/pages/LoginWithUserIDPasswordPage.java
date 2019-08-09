package com.tce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tce.qa.base.TestBase;

public class LoginWithUserIDPasswordPage extends TestBase {
//Page Factory: OR(Page objects):
	@FindBy(xpath = "//p[contains(text(),'Please sign in using your account details ')]")
	WebElement loginWithCredText;
	@FindBy(id = "mat-input-0")
	WebElement username;
	@FindBy(id = "mat-input-1")
	WebElement password;
	@FindBy(xpath = "//span[@class='mat-button-wrapper']//p[contains(text(),'Sign In')]")
	WebElement signInBtn;
	@FindBy(xpath = "//span[contains(text(),'Sign in with PIN')]")
	WebElement SignInWithPinLink;
	@FindBy(linkText = " Terms & Privacy Policy")
	WebElement TermsPolicyLink;
	@FindBy(xpath = "//i[@class='material-icons']")
	WebElement XIcon;
	@FindBy(xpath = "//img[@src='assets/images/img.Logo.Colour@3x.png']")
	WebElement tcelogo;

	// Initializing page objects:
	public LoginWithUserIDPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validatePageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return tcelogo.isDisplayed();

	}

	public WhiteboardPage loginWithUserIDPassword(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		return new WhiteboardPage();
	}

	public GuestPage clickOnXicon() {
		XIcon.click();
		return new GuestPage();
	}

	public LoginWithPinPage clickOnSignInWithPinLink() {
		SignInWithPinLink.click();
		return new LoginWithPinPage();
	}
}
