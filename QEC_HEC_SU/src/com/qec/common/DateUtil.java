package com.qec.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.codehaus.groovy.runtime.metaclass.MethodMetaProperty.GetMethodMetaProperty;

public class DateUtil {
	
	private static String pattern = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	static Integer HOURS;
	static Integer MINUTES;
	public static String getCurrenntDateInString() 
	{
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String[] compareTime(String userEnterTime, String systemTime, String timeType) 
	{
		
		String userEnterFullTimeData[] = userEnterTime.split(" ");
		String userTimeData[] = userEnterFullTimeData[0].split(":");
		
		
		String systemEnterFullTimeData[] = systemTime.split(" ");
		String systemTimeData[] = systemEnterFullTimeData[0].split(":");
		
		System.out.println(Integer.parseInt(userTimeData[1].trim()) == 0);
		if(timeType.equalsIgnoreCase("intime"))
		{
			if(Integer.parseInt(userTimeData[0].trim()) <= 9 && Integer.parseInt(userTimeData[1].trim()) <= 30)
			{
				if(Integer.parseInt(systemTimeData[0].trim()) <= 9 && Integer.parseInt(systemTimeData[1].trim()) <= 30 && systemTimeData[1].trim().equals("AM")) 
				{
					HOURS = 9 - Integer.parseInt(userTimeData[0].trim());
					MINUTES = 30 - Integer.parseInt(systemTimeData[1].trim());
					String s[] = {"earlier",String.valueOf(HOURS),String.valueOf(MINUTES)};
					return s;
				}
				else
				{
					HOURS = Integer.parseInt(systemTimeData[0].trim()) - 9;
					MINUTES = Integer.parseInt(systemTimeData[1].trim()) - 30;
					String s[] = {"late",String.valueOf(HOURS),String.valueOf(MINUTES)};
					return s;
				}
			}
			else  
			{
				HOURS = Integer.parseInt(userTimeData[0].trim()) - 9;
				MINUTES = Integer.parseInt(userTimeData[1].trim());
				String s[] = {"late",String.valueOf(HOURS),String.valueOf(MINUTES)};
				return s;
			}	
		}
		else
		{
			if((Integer.parseInt(userTimeData[0].trim()) == 5 && Integer.parseInt(userTimeData[1].trim()) >= 30) || (Integer.parseInt(userTimeData[0].trim()) > 5 && Integer.parseInt(userTimeData[1].trim())>=0 && Integer.parseInt(userTimeData[1].trim())<=59))
			{
				if((Integer.parseInt(systemTimeData[0].trim()) == 5 && Integer.parseInt(systemTimeData[1].trim()) >= 30) || (Integer.parseInt(systemTimeData[0].trim()) > 5 && Integer.parseInt(systemTimeData[1].trim())>=0 && Integer.parseInt(systemTimeData[1].trim())<=59))
				{
					HOURS = Integer.parseInt(systemTimeData[0].trim()) - 5;
					if(Integer.parseInt(systemTimeData[0].trim()) == 5 && Integer.parseInt(systemTimeData[1].trim()) >= 30)
					{
						MINUTES = Integer.parseInt(systemTimeData[1].trim()) - 30;
					} else 
					{
						MINUTES = Integer.parseInt(systemTimeData[1].trim());
					}
					
					String s[] = {"onTime",String.valueOf(HOURS),String.valueOf(MINUTES)};
					return s;
				}
				else
				{
					HOURS = 5 - Integer.parseInt(systemTimeData[0].trim());
					if(Integer.parseInt(systemTimeData[0].trim()) == 5 && Integer.parseInt(systemTimeData[1].trim()) < 30)
					{
						MINUTES = 30 - Integer.parseInt(systemTimeData[1].trim()) ;
					} else 
					{
						MINUTES = Integer.parseInt(systemTimeData[1].trim());
					}
					
					String s[] = {"earlier",String.valueOf(HOURS),String.valueOf(MINUTES)};
					return s;
				}
			}
			else 
			{
				HOURS = 5 - Integer.parseInt(systemTimeData[0].trim());
				if(Integer.parseInt(systemTimeData[0].trim()) == 5 && Integer.parseInt(systemTimeData[1].trim()) < 30)
				{
					MINUTES = 30 - Integer.parseInt(systemTimeData[1].trim()) ;
				} else 
				{
					MINUTES = Integer.parseInt(systemTimeData[1].trim());
				}
				
				String s[] = {"earlier",String.valueOf(HOURS),String.valueOf(MINUTES)};
				return s;
			}
		}
		
	}
	
	public static String stringToTimeStampWithTime(String strTime) 
	{
		String tempTimestamp = null;
		String date = "";
		if (strTime != null && !strTime.equals(""))
		{
			//SimpleDateFormat dateFormat = new SimpleDateFormat(
				//	"dd-MMM-yy hh:mm:ss");
			Date parsedTimeStamp = null;
			try {
				parsedTimeStamp=new SimpleDateFormat("dd/MM/yyyy").parse(strTime);  
				date = simpleDateFormat.format(parsedTimeStamp);
				System.out.println(date);
				//parsedTimeStamp = simpleDateFormat.parse(date);  
				//parsedTimeStamp = simpleDateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//tempTimestamp =  Timestamp.valueOf(date);

		}
		return date;
	}
	
	public static Date stringToDate(String date)
	{
		 SimpleDateFormat formatter =new SimpleDateFormat("y-M-dd");
		 Date date1 = null;
		try {
			date1 = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return date1 ;
	}
	
	public static Timestamp stringToTimeStampWithTime2(String strTime){
		Timestamp tempTimestamp = null;
		if(strTime!=null && !strTime.equals(""))
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(
		            "dd-MMM-yy hh:mm:ss");

		    Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());
		}
		return tempTimestamp;
    }
	
	public static String timeStampToString(Timestamp timeStamp){
    	String timeStampToStr=null;
    	if(timeStamp!=null)
			timeStampToStr = new SimpleDateFormat("dd-MMM-yy").format(timeStamp);
		return timeStampToStr;
    }

	public static Timestamp stringToTimeStamp(String strTime){

		Timestamp tempTimestamp = null;
		if(strTime!=null && !strTime.equals(""))
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(
		            "dd-MMM-yy");

		    Date parsedTimeStamp = null;
			try {
				parsedTimeStamp = dateFormat.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			tempTimestamp = new Timestamp(parsedTimeStamp.getTime());
			
			
		}
		return tempTimestamp;
    }
	
	public static int getTotalDaysByMonthAndYear(int year, int month)
	{
		int iYear = year;
		//int iMonth = Calendar.JUNE; // 1 (months begin with 0)
		int iDay = 1;
		// Create a calendar object and set year and month
		Calendar mycal = new GregorianCalendar(iYear, month, iDay);
		// Get the number of days in that month
		int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
		System.out.println(">>>>>>>>>>>>>>>>>"+daysInMonth);
		return daysInMonth;
	}
	
	public static int getHolyDaysByMonthAndYear(int year, int month)
	{
		int iYear = year;
		int iMonth = getMonth(month); // 1 (months begin with 0)
		int iDay = 1;
		int holydays = 0;
		
		System.out.println(iYear);
		System.out.println(iMonth);
		
		Calendar cal = new GregorianCalendar(iYear, iMonth, iDay);
		do {
		    // get the day of the week for the current day
		    int day = cal.get(Calendar.DAY_OF_WEEK);
		    // check if it is a Saturday or Sunday
		    if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
		        // print the day - but you could add them to a list or whatever
		        ++holydays;
		        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		    }
		    // advance to the next day
		    cal.add(Calendar.DAY_OF_YEAR, 1);
		}  while (cal.get(Calendar.MONTH) == iMonth);
		return holydays;
	}
	
	private static int getMonth(int month)
	{
		switch(month)
		{
		case 1:
			return Calendar.JANUARY;
		case 2:
			return Calendar.FEBRUARY;
		case 3:
			return Calendar.MARCH;
		case 4:
			return Calendar.APRIL;
		case 5:
			return Calendar.MAY;
		case 6:
			return Calendar.JUNE;
		case 7:
			return Calendar.JULY;
		case 8:
			return Calendar.AUGUST;
		case 9:
			return Calendar.SEPTEMBER;
		case 10:
			return Calendar.OCTOBER;
		case 11:
			return Calendar.NOVEMBER;
		case 12:
			return Calendar.DECEMBER;
		}
		
		return 0;
	}
}
