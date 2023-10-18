package co.com.demobvc.infrastructure.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static DateUtil dateUtil;
	
	private DateUtil() {}
	
	public static DateUtil getInstance() {
		if (dateUtil == null)
			dateUtil = new DateUtil();
		return dateUtil;
	}
	
	public static Date dateFromString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(date);
	}

}
