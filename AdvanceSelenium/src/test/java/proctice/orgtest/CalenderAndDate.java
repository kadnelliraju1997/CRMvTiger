package proctice.orgtest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderAndDate {
	public static void main(String[] args) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String actDate = sdf.format(date);
		System.out.println(actDate);
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateRequires = sdf.format(cal.getTime());
		System.out.println(dateRequires);
		
		
	
	}

}
