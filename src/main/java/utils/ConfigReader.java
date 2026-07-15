package utils;

import java.util.ResourceBundle;

public class ConfigReader {
	
	private static ResourceBundle resource;
	
	static {
	 resource = ResourceBundle.getBundle("config");
	}
	
	public static String get(String property)
	{
		return resource.getString(property);
	}
	
}
