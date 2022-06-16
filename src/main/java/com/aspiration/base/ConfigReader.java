package com.aspiration.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties pros;

	public static void readProperties(String filePath) {
		pros = new Properties();
		try {
			FileInputStream file = new FileInputStream(filePath);
			pros.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {

		return pros.getProperty(key);
	}

	public static Object setProperty(String key, String value) {
		return pros.setProperty(key, value);
	}
}