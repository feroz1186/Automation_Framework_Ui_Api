package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

public class LocalTime {
	
	private static LocalDateTime dateTime;
	private static DateTimeFormatter formatter;
	
	public static String getTime()
	{
		dateTime = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:MM:SS");
		
		return dateTime.format(formatter);
		
	}

}
