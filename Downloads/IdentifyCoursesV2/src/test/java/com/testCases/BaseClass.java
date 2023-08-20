package com.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;



public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String edgeversion = readconfig.getEdgeVersion();
	public String chromeversion = readconfig.getChromeVersion();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{	
		logger = Logger.getLogger("IdentifyCourses");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
//			WebDriverManager.chromedriver().browserVersion(chromeversion).setup();
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("msedge"))
		{
//			WebDriverManager.edgedriver().browserVersion(edgeversion).setup();
			System.setProperty("webdriver.edge.driver",readconfig.getMSEdgePath());
			driver = new EdgeDriver();
		}
			
		driver.manage().window().maximize();
	}

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public void openURL(String url) {
		driver.get(url);
	}
	
	public void addImplicitWait(long sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
}
