package com.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopCoursesPage {

WebDriver driver;
	
	public TopCoursesPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver,this);
	}
	
	// WebElements 
	
	
	@FindBy(xpath="//body/div[@id='rendered-content']/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement language;
	
	@FindBy(xpath="//div[@class='filters-modal-content horizontal-box']//div[@class='rc-SearchFilterOption']//div[@class='checkboxText']")
	List<WebElement> languages;
	
	@FindBy(xpath="//div[@class='filters-modal-content horizontal-box']//div[@class='rc-SearchFilterOption']//div[@class='filter-count']")
	List<WebElement> languagesCount;

	@FindBy(xpath="//div[contains(text(),'Level')]")
	WebElement level;

	@FindBy(xpath="//div[@class='Select-menu-outer']//div[@class='Select-menu']//div[@class='Select-option']//div[@class='rc-SearchFilterOption']//div[@class='checkboxText']")
	List<WebElement> levels;
	
	@FindBy(xpath="//div[@class='Select-menu-outer']//div[@class='Select-menu']//div[@class='Select-option']//div[@class='rc-SearchFilterOption']//div[@class='filter-count']")
	List<WebElement> levelCount;
	
	@FindBy(xpath="//body/div[@id='rendered-content']/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/a[1]/div[1]/div[2]/h2[1]")
	WebElement course1;
	
	@FindBy(xpath="//body/div[@id='rendered-content']/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/a[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/span[1]")
	WebElement rating1;
	
	@FindBy(xpath="//body/div[@id='rendered-content']/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/a[1]/div[1]/div[2]/h2[1]")
	WebElement course2;
	
	@FindBy(xpath="//body/div[@id='rendered-content']/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/a[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/span[1]")
	WebElement rating2;
	
	@FindBy(xpath="//button[contains(text(),'Show All')]")
	WebElement showAll;
	
	@FindBy(xpath="//a[contains(text(),'✕')]")
	WebElement closelangpopup;

	
	// methods
	
	
	public void clickLanguage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(language).click().perform();
	}
	
	public void selectLanguageFromDropdown(String language)
	{
		driver.findElement(By.xpath("//div[@id='react-select-2--list']//input[@type='checkbox' and @value='"+language+"']")).click();
	}
	
	public void clickLevel()
	{
		Actions action = new Actions(driver);
		action.moveToElement(level).click().perform();
	}
	
	public void selectLevelFromDropdown(String level)
	{
		driver.findElement(By.xpath("//div[@id='react-select-3--list']//input[@type='checkbox' and @value='"+level+"']")).click();
	}
	
	public void clickCourse1()
	{
		course1.click();
	}
	
	public String getCourse1Name()
	{
		return course1.getText();
	}
	
	public void clickCourse2()
	{
		course2.click();
	}
	
	public String getCourse2Name()
	{
		return course2.getText();
	}
	
	public String getRating1()
	{
		return rating1.getText();
	}


	public String getRating2()
	{
		return rating2.getText();
	}
	
	public void clickShowAll()
	{
		showAll.click();
	}

	public HashMap<String, String> getAllLanguages()
	{
		HashMap<String, String> langdict = new HashMap<>();
		ArrayList<String> langlist = new ArrayList<>();
		ArrayList<String> langcountlist = new ArrayList<>();
		
		for(WebElement language : languages)
		{
			langlist.add(language.getText());
		}
		
		for(WebElement count : languagesCount)
		{
			langcountlist.add(count.getText());
		}
		
		Iterator<String> it1 = langlist.iterator();
		Iterator<String> it2 = langcountlist.iterator();
		while(it1.hasNext() && it2.hasNext())
		{
		    langdict.put(it1.next(),it2.next());
		}
		
		return langdict;
	}
	
	public void closeLangPopup()
	{
		closelangpopup.click();
	}

	
	public HashMap<String, String> getAllLevels()
	{
		HashMap<String, String> levdict = new HashMap<>();
		ArrayList<String> levlist = new ArrayList<>();
		ArrayList<String> levcountlist = new ArrayList<>();
		
		for(WebElement level : levels)
		{
			levlist.add(level.getText());
		}
		
		for(WebElement count : levelCount)
		{
			levcountlist.add(count.getText());
		}
		
		Iterator<String> it1 = levlist.iterator();
		Iterator<String> it2 = levcountlist.iterator();
		while(it1.hasNext() && it2.hasNext())
		{
		    levdict.put(it1.next(),it2.next());
		}
		
		return levdict;
	}
}
