package com.qkart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUserName() {
		String userName = pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath() {
		String path = pro.getProperty("chromepath");
		return path;
	}
}
