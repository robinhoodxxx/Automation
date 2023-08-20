package com.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver,this);
	}
	
	// WebElements
	
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement searchBox;
	
	@FindBy(xpath="//a[@id='enterprise-link']")
	WebElement forEnterprise;
	
	@FindBy(xpath="//a[@href='https://www.coursera.org/business/products']")
	WebElement products;
	
	@FindBy(xpath="//a[@target='_blank'][normalize-space()='For Campus']")
	WebElement courseCampus;
	
	@FindBy(id="//div[@id='react-autowhatever-1']")
	WebElement dropDownForSearch;
	
	@FindBy(xpath ="//div[@class='react-autosuggest__section-container']//ul[@role='listbox']//li[@role='option']")
	List<WebElement> dropDownForSearchLinks;
	
	
	// methods
	
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public Boolean searchBoxEnable()
	{
		boolean op = searchBox.isEnabled();
		return op;
	}
	
	public void enterValInSearchBox(String course)
	{
		searchBox.clear();
		searchBox.sendKeys(course);
	}
	
	public void submitSearchBox()
	{
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public void checkDropDownVisibleOrNot()
	{
		Actions action = new Actions(driver);
		action.moveToElement(dropDownForSearch);
	}
	
	public void clickEnterpriselink()
	{
		forEnterprise.click();
	}
	
	public void HoverOnProducts()
	{
		Actions action = new Actions(driver);
		action.moveToElement(products);
	}
	
	public void clickCourseCampus()
	{
		Actions action = new Actions(driver);
		action.moveToElement(products).moveToElement(courseCampus).click().perform();
	}

}
