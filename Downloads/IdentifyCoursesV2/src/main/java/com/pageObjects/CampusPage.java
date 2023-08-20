package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CampusPage {

	WebDriver driver;
	public CampusPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver,this);
	}
	
	// WebElements
	
	@FindBy(id="FirstName")
	WebElement fname;
	
	@FindBy(id="LastName")
	WebElement lname;

	@FindBy(id="Title")
	WebElement jobTitle;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Phone")
	WebElement phone;
	
	@FindBy(id="Company")
	WebElement institution;
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	WebElement comments;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement submit;
	
	// Select dropdowns
	
	@FindBy(id="C4C_Job_Title__c")
	WebElement jobFunction;
	
	@FindBy(id="Institution_Type__c")
	WebElement instituteType;
	
	@FindBy(id="Primary_Discipline__c")
	WebElement discipline;
	
	@FindBy(id="Country")
	WebElement country;
	
	
	// Methods
	
	public void selectJobFunction(String job)
	{
		Select select = new Select(jobFunction);
		select.selectByVisibleText(job);
	}
	
	public void selectInstitutionType(String institute)
	{
		Select select = new Select(instituteType);
		select.selectByVisibleText(institute);
	}
	
	public void selectDiscipline(String primaryDiscipline)
	{
		Select select = new Select(discipline);
		select.selectByVisibleText(primaryDiscipline);
	}
	
	public void selectCountry(String countryname)
	{
		Select select = new Select(country);
		select.selectByVisibleText(countryname);
	}
	
	public void setFirstName(String firstname)
	{
		fname.sendKeys(firstname);
	}
	
	public void setLastName(String lastname)
	{
		lname.sendKeys(lastname);
	}
	
	public void setEmail(String emailadd)
	{
		email.sendKeys(emailadd);
	}
	
	public void setPhone(String phoneno)
	{
		phone.sendKeys(phoneno);
	}
	
	public void setJobTitle(String jTitle)
	{
		jobTitle.sendKeys(jTitle);
	}
	
	public void setInstitution(String institutionname)
	{
		institution.sendKeys(institutionname);
	}
	
	public void setComments(String comment)
	{
		comments.sendKeys(comment);
	}
	
	public void submitForm()
	{
		submit.click();
	}

}
