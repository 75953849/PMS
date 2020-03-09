package com.tyut.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {
	
	String datePattern = "yyyy-MM-dd HH:mm:ss";
	String datePattern2 = "yyyy-MM-dd";
	private SimpleDateFormat simpleDateFormat;
	private SimpleDateFormat simpleDateFormat2;
	@Override
	public String print(Date date, Locale arg1) {
		// TODO Auto-generated method stub
		return new SimpleDateFormat().format(date);
	}

	@Override
	public Date parse(String source, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		simpleDateFormat = new SimpleDateFormat(datePattern);
		simpleDateFormat2 = new SimpleDateFormat(datePattern2);
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return simpleDateFormat2.parse(source);
		}
	}

}
