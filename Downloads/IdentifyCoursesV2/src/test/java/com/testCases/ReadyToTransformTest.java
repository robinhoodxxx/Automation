package com.testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.CampusPage;
import com.pageObjects.HomePage;
import com.utilities.XLUtils;

import org.testng.Assert;

public class ReadyToTransformTest extends BaseClass{

	@Test(dataProvider="formData")
	public void readyToTransformFormTest21(String fname,String lname,String job,String jtitle,String email,String phone,String institutiontype,String institutionname,String discipline,String country,String comments) throws IOException
	{
		openURL(baseURL);
		addImplicitWait(10);
		
		HomePage hp = new HomePage(driver);
		hp.clickEnterpriselink();
		hp.HoverOnProducts();
		hp.clickCourseCampus();
		
		Set<String> windows = driver.getWindowHandles();
	    Iterator<String> it = windows.iterator();
	    String parentwindow = it.next();
	    String childwindow = it.next();
	    
	    logger.info("Parent WindowID: "+parentwindow);
	    logger.info("Child WindowID: "+childwindow);
	    
	    driver.switchTo().window(childwindow);
	    String title = driver.getTitle();
	    Assert.assertEquals(driver.getWindowHandle(),childwindow);
	    CampusPage cp = new CampusPage(driver);
		
		cp.setFirstName(fname);
		cp.setLastName(lname);
		cp.selectJobFunction(job);
		cp.setJobTitle(jtitle);
		cp.setEmail(email);
		cp.setPhone(phone);
		cp.selectInstitutionType(institutiontype);
		cp.setInstitution(institutionname);
		cp.selectDiscipline(discipline);
		cp.selectCountry(country);
		cp.setComments(comments);

		cp.submitForm();
		
		if(!title.equals(driver.getTitle())) {
		 	Assert.assertTrue(true);
		 	logger.info("readyToTransformTest21 Passed");
		}
		else {
			captureScreen(driver,"readyToTransformFormTest21");
			Assert.assertTrue(false);
			logger.warn("readyToTransformTest21 failed");
		}
	}
	
	
	@DataProvider(name="formData")
	public String[][] getFormData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/testData/CourseraTestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "TS_FORMDATA");
		int colcount=XLUtils.getCellCount(path,"TS_FORMDATA",1);
		
		String formdata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				formdata[i-1][j] = XLUtils.getCellData(path,"TS_FORMDATA",i, j);
				
			}
		}
		
		return formdata;
	}
}
