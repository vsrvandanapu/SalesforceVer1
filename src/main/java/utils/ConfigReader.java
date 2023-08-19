package utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;

public class ConfigReader {
	
	public Properties initializeProperties() {
		Properties pro = new Properties();
		File proFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(proFile);
		pro.load(fis);
		}catch(Throwable e) {
			e.getStackTrace();
		}
		return pro;
	}
	/*
	 public static Properties initializeProperties() {
		Properties pro = new Properties();
		File proFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(proFile);
		pro.load(fis);
		}catch(Throwable e) {
			e.getStackTrace();
		}
		return pro;
	}
	 */

}
