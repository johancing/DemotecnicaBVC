package co.com.demobvc.infrastructure.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private DateUtil() {
		throw new IllegalAccessError();
	}
	
	public static Date dateFromString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(date);
	}
	
	public static String actualDateString() {
		SimpleDateFormat sdf =  new SimpleDateFormat("dd_MM_yyyy");
		return sdf.format(new Date());
	}

}
