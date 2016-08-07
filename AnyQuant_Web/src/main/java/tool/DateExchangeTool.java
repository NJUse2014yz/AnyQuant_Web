package tool;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateExchangeTool {
	private static final SimpleDateFormat simpleDateFormat_date1=new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat simpleDateFormat_time=new SimpleDateFormat("HH:mm:ss");
	private static final SimpleDateFormat simpleDateFormat_dateAndTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat simpleDateFormat_date2=new SimpleDateFormat("yyyyMMdd");
	
	public static Date stringToSqlDate(String string)
	{
		Date date=null;
		try {
			date=new Date(simpleDateFormat_date1.parse(string).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  date;
	}
	public static Time stringToSqlTime(String string)
	{
		Time time=null;
		try {
			time=new Time(simpleDateFormat_time.parse(string).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
	
	public static Date stringToSqlDateAndTime(String string)
	{
		Date date=null;
		try {
			date=new Date(simpleDateFormat_dateAndTime.parse(string).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  date;
	}
	public static String dateToString2(java.util.Date date)
	{
		if(date==null)
		{
			return null;
		}
		String result=null;
		result=simpleDateFormat_date2.format(date);
		return result;
	}
	public static String dateToString1(Date date)
	{
		if(date==null)
		{
			return null;
		}
		String result=null;
		result=simpleDateFormat_date1.format(date);
		return result;
	}
	public static String dateTimeToString(java.util.Date date)
	{
		if(date==null)
		{
			return null;
		}
		String result=null;
		result=simpleDateFormat_dateAndTime.format(date);
		return result;
	}
	public static String timeToString(Time time)
	{
		if(time==null)
		{
			return null;
		}
		String result=null;
		result=simpleDateFormat_time.format(time);
		return result;
	}
}
