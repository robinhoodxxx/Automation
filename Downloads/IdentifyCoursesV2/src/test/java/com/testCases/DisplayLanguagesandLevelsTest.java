package com.testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.TopCoursesPage;
import com.utilities.XLUtils;

public class DisplayLanguagesandLevelsTest extends BaseClass{
	
	@Test(dataProvider="langdata")
	public void displayLanguagesandLevelsTest15(String searchValue) {
		try {
			openURL(baseURL);
			addImplicitWait(10);
			
			HomePage hp = new HomePage(driver);
			hp.enterValInSearchBox(searchValue);
			hp.submitSearchBox();
			Assert.assertEquals(hp.getPageTitle().toLowerCase().contains(searchValue),true);
			TopCoursesPage tcp = new TopCoursesPage(driver);
			tcp.clickLanguage();
			tcp.clickShowAll();
			HashMap<String,String> langdict = tcp.getAllLanguages();
		    for(Map.Entry<String,String> item : langdict.entrySet())
		    {
		    	logger.info(item.getKey() +" +:+ "+ item.getValue());
		    }
		    tcp.closeLangPopup();
			tcp.clickLevel();
			logger.info(tcp.getAllLevels());
			
			Assert.assertTrue(true);
			logger.info("displayLanguagesandLevelsTest15 testcase passed");
			
		}catch(Exception e) {
			Assert.assertTrue(false);
			logger.warn("displayLanguagesandLevelsTest15 testcase failed");
		}
	}
	
	
	@DataProvider(name="langdata")
	public String [][] getLanguageData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/testData/CourseraTestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "TS_langdata");
		int colcount=XLUtils.getCellCount(path,"TS_langdata",1);
		
		String langdata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				langdata[i-1][j] = XLUtils.getCellData(path,"TS_langdata",i, j);
				
			}
		}
		
		return langdata;
	}

}
