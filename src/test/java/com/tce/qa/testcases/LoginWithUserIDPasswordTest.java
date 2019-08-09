package com.tce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tce.qa.base.TestBase;
import com.tce.qa.pages.LoginWithUserIDPasswordPage;
import com.tce.qa.pages.WhiteboardPage;

public class LoginWithUserIDPasswordTest extends TestBase{
	LoginWithUserIDPasswordPage loginWithUserIDPassword;
	WhiteboardPage whiteboardPage;
	public LoginWithUserIDPasswordTest(){
		super();//1st call super class
	}
	@BeforeMethod
	public void setup() {
		initialization();//2nd call initialize method of base class
	 loginWithUserIDPassword=new LoginWithUserIDPasswordPage();
	}
	@Test(priority = 1)
	public void loginWithUserIDPasswordPageTitle() {
		String title=loginWithUserIDPassword.validatePageTitle();
		Assert.assertEquals(title, "Tceweb", "Login page not matched");
		System.out.println("------Title verified------");
	}
	@Test(priority = 2)
	public void loginWithUserIDPasswordPageLogo() {
		boolean flag=loginWithUserIDPassword.validateLogo();
		Assert.assertTrue(flag,"Logo not matched");
		System.out.println("------Logo verified------");
	}
	@Test(priority = 3)
	public void loginWithUserIDPassword() throws InterruptedException {
		whiteboardPage=loginWithUserIDPassword.loginWithUserIDPassword(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000);
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
 
}
