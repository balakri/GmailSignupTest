package com.gmail.pagestest;

import static org.junit.Assert.*;
import junit.framework.AssertionFailedError;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import javax.sound.midi.MidiDevice.Info;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.gmail.pages.CreateAccount;
import com.gmail.pages.GmailHome;

public class CreateAccountTest {

	static WebDriver chromeDriver;
	static String chromeDriverPath = "D:\\venki\\Selenium\\chromedriver_win32\\chromedriver.exe";
	static String gmailCreateAccountPage = "https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default";
	static String gHomePage = "http://www.gmail.com";
	static GmailHome gmailHomePage;
	static CreateAccount createAccount;

	@BeforeClass
	public static void createChromeDriver() {
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}


	@Before
	public  void gotoGmailHomePage() {
		gmailHomePage = new GmailHome(chromeDriver, gHomePage);
		gmailHomePage.clickCreateAccountButton();
	}

	@Test
	public void testSignupPassScenario() {
		String createAccountPageURl = chromeDriver.getCurrentUrl();
		createAccount = new CreateAccount(
				chromeDriver, createAccountPageURl);
		setSignupParameters("1987");
		String mobileAuthPageUrl = chromeDriver.getCurrentUrl();
		assertFalse(checkCondition(mobileAuthPageUrl,createAccountPageURl));
	}
	
	@Test
	public void testSignupAgeLessThan18() {
		String childSafetyDetailsPageText = null;
		String createAccountPageURl = chromeDriver.getCurrentUrl();
		createAccount = new CreateAccount(
				chromeDriver, createAccountPageURl);
		setSignupParameters("2010");
		WebElement childSafetyDetailsPage = chromeDriver.findElement(By.linkText("visit the Federal Trade Commission's website."));
		childSafetyDetailsPageText = childSafetyDetailsPage.getText();
		assertFalse(checkCondition(childSafetyDetailsPageText,createAccountPageURl));
	}


	private boolean checkCondition(String mobileAuthPageUrl,
			String createAccountPageURl) {
		if(mobileAuthPageUrl.equals(createAccountPageURl)){
			System.out.println("They are same");
			return true;
		}
		return false;
	}


	private void setSignupParameters(String yearofBirth) {
		createAccount.setfirstName("Larry");
		createAccount.setlastName("Page");
		createAccount.setgmailAddress("Larry.1Page.123456");
		createAccount.setpasswd("1234abc678");
		createAccount.setpasswdAgain("1234abc678");
		createAccount.setbirthDay("12");
		createAccount.setbMonth("6");
		createAccount.setbYear(yearofBirth);
		createAccount.setrecoveryPhoneNumber("1234567890");
		createAccount.setgender("g");
		createAccount.setrecoveryEmailAddress("SergeyBrin@gmail.com");
		createAccount.selectSkipVerification();
		createAccount.acceptTerms();
		createAccount.clickSubmit();
	}
}
