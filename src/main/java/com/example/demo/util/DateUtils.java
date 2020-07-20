package com.example.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtils {

	private static final Logger LOGGER = Logger.getLogger(DateUtils.class.getName());

	public static Date parseDate(String dateStr) {
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df1.setTimeZone(TimeZone.getTimeZone("UTC")); 
		try {
			return df1.parse(dateStr);
		} catch (ParseException e) {
			LOGGER.log(Level.SEVERE, "Cannot parse date", e);
		}
		return null;
	}

}
