package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailHome {

	private WebDriver driver;
	
	By createAccountButton = By.linkText("Create account");

	public GmailHome(WebDriver driver, String url){
		this.driver = driver;
		driver.get(url);
	}

	public void clickCreateAccountButton(){
		driver.findElement(createAccountButton).click();
	}
}
