package com.tce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tce.qa.base.TestBase;
import com.tce.qa.pages.LoginWithPinPage;

public class LoginWithPinTest extends TestBase{
	LoginWithPinPage loginWithPin;
public LoginWithPinTest() {
	super();
}
@BeforeMethod
public void setup() {
	initialization();
	 loginWithPin=new LoginWithPinPage();
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
