package com.testCases;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.CourseLandingPage;
import com.pageObjects.HomePage;
import com.pageObjects.TopCoursesPage;
import com.utilities.XLUtils;

public class DisplayCourseDetailsTest extends BaseClass{

	
	@Test(dataProvider="2WdData")
	public void displayCourseDetailsTest11(String searchValue, String language, String level)
	{
		try {
			openURL(baseURL);
			addImplicitWait(10);
		    
			HomePage hp = new HomePage(driver);
			
			hp.enterValInSearchBox(searchValue);
			hp.submitSearchBox();
			Assert.assertEquals(hp.getPageTitle().toLowerCase().contains(searchValue),true);
			TopCoursesPage tcp = new TopCoursesPage(driver);
			
			tcp.clickLanguage();
			tcp.selectLanguageFromDropdown(language);
			
			tcp.clickLevel();
			tcp.selectLevelFromDropdown(level);
			tcp.clickCourse1();
			tcp.clickCourse2();
			
			Set<String> windows = driver.getWindowHandles();
		    Iterator<String> it = windows.iterator();
		    String parentwindow = it.next();
		    String childwindow1 = it.next();
		    String childwindow2 = it.next();
		    
		    logger.info("Parent WindowID: "+parentwindow);
		    logger.info("First Child WindowID: "+childwindow1);
		    logger.info("Second Child WindowID: "+childwindow2);
		
		    driver.switchTo().window(childwindow1);
		    CourseLandingPage clp = new CourseLandingPage(driver);
//		    Assert.assertEquals(clp.getPageTitle().toLowerCase().contains("web"), true);
		    String h1 = clp.getHrs1();
		    driver.switchTo().window(childwindow2);
//		    Assert.assertEquals(clp.getPageTitle().toLowerCase().contains("web"), true);
			String h2 = clp.getHrs2();
			driver.close();
			driver.switchTo().window(parentwindow);
			
			logger.info("First course Details:\nTitle"+tcp.getCourse1Name()+"\nRating: "+tcp.getRating1()+"\nDuration: "+h1);
			logger.info("First course Details:\nTitle"+tcp.getCourse2Name()+"\nRating: "+tcp.getRating2()+"\nDuration: "+h2);
			logger.info("Test case TC_011 passed");
			Assert.assertTrue(true);
			
		}catch(Exception e)
		{
			logger.info("Test case TC11 failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	@DataProvider(name="2WdData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/testData/CourseraTestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "TC_2WD");
		int colcount=XLUtils.getCellCount(path,"TC_2WD",1);
		
		String wddata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				wddata[i-1][j] = XLUtils.getCellData(path,"TC_2WD",i, j);
				
			}
		}
		
		return wddata;
	}
	
}
