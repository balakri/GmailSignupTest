package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	WebDriver driver;

	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By gmailAddress = By.id("GmailAddress");
	By passwd = By.id("Passwd");
	By passwdAgain = By.id("PasswdAgain");
	By birthDay = By.id("BirthDay");
	By birthMonthLabel = By.xpath("//*[@id=\"BirthMonth\"]/div");
	By birthMonthLabelChoose = By
			.xpath("//label[@id='month-label']/span/div[2]/div[@id=':5']");
	By birthYear = By.id("BirthYear");
	By gender = By.xpath("//*[@id=\"Gender\"]/div");
	By isdCode = By
			.xpath("//*[@id=\"phone-form-element\"]/table/tbody/tr/th/div");
	By recoveryPhoneNumber = By.id("RecoveryPhoneNumber");
	By recoveryEmailAddress = By.id("RecoveryEmailAddress");
	By skipCaptcha = By.id("SkipCaptcha");
	By location = By.id("Location");
	By termsOfService = By.id("TermsOfService");
	By submitbutton = By.id("submitbutton");

	public CreateAccount(WebDriver driver, String url) {
		this.driver = driver;
		driver.get(url);
	}

	public void setfirstName(String userName) {
		driver.findElement(firstName).sendKeys(userName);
	}

	public void setlastName(String userLastName) {
		driver.findElement(lastName).sendKeys(userLastName);
	}

	public void setgmailAddress(String mailAddress) {
		driver.findElement(gmailAddress).sendKeys(mailAddress);
	}

	public void setpasswd(String password) {
		driver.findElement(passwd).sendKeys(password);
	}

	public void setpasswdAgain(String passwordAgain) {
		driver.findElement(passwdAgain).sendKeys(passwordAgain);
	}

	public void setbirthDay(String bDay) {
		driver.findElement(birthDay).sendKeys(bDay);
	}

	public void setbMonth(String monthIndex) {
		driver.findElement(birthMonthLabel).click();
		driver.findElement(
				By.xpath("//label[@id='month-label']/span/div[2]/div[@id=':"
						+ monthIndex + "']")).click();
	}

	public void setbYear(String bYear) {
		driver.findElement(birthYear).sendKeys(bYear);
	}

	public void setgender(String genderIndex) {
		driver.findElement(gender).click();
		driver.findElement(By.xpath("//*[@id=\":" + genderIndex + "\"]"))
				.click();
	}

	public void setIsdCode(String isdCodeCountry) {
		Select isdCodeSelect = new Select(driver.findElement(isdCode));
		isdCodeSelect.selectByVisibleText(isdCodeCountry);
	}

	public void setrecoveryPhoneNumber(String phoneNumber) {
		driver.findElement(recoveryPhoneNumber).sendKeys(phoneNumber);
	}

	public void setrecoveryEmailAddress(String altEmailAddress) {
		driver.findElement(recoveryEmailAddress).sendKeys(altEmailAddress);
	}

	public void setlocation(String place) {
		driver.findElement(location).sendKeys(place);
	}

	public void selectSkipVerification() {
		driver.findElement(skipCaptcha).click();
	}

	public void acceptTerms() {
		driver.findElement(termsOfService).click();
	}

	public void clickSubmit() {
		driver.findElement(submitbutton).click();

	}

}
