package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getMSEdgePath()
	{
		String msedgepath=pro.getProperty("msedgepath");
		return msedgepath;
	}
	
	public String getChromeVersion()
	{
		return pro.getProperty("edgeversion");
	}
	
	public String getEdgeVersion()
	{
		return pro.getProperty("chromeversion");
	}

	
}

