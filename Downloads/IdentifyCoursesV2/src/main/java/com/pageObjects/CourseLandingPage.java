package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseLandingPage {
	WebDriver driver;
	
	public CourseLandingPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver,this);
	}
	
	// Web Elements
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/span[1]")
	WebElement hrs1;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/span[1]")
	WebElement hrs2;
	
	
	// methods
	
	public String getHrs1()
	{
		return hrs1.getText();
	}
	
	public String getHrs2()
	{
		return hrs2.getText();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}
