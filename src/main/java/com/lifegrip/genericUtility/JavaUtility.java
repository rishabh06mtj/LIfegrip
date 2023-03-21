 
package com.lifegrip.genericUtility;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * this class contains java reusable method
 * @author 91958
 *
 */
public class JavaUtility {
	/**
	 * this method is used to convert from string to any datatype
	 * @param s
	 * @param strategy
	 * @return
	 */
	public Object stringToAnyDataType(String s,String strategy)
	{
		Object convertedData=null;
		if(strategy.equals("int"))
		{
			convertedData=Integer.parseInt(s);
		}
		else if(strategy.equals("long"))
		{
			convertedData=Long.parseLong(s);
		}

		return	convertedData;
	}
	/**
	 * this method is used to generate random Number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit)
	{
		int randomNumber=new Random().nextInt(limit);
		return randomNumber;
	}
	/**
	 * this method is used to split the string 
	 * @param s
	 * @param stratagy
	 * @return
	 */
	public String[] splitString(String s,String stratagy)
	{
		return s.split(stratagy);
	}
	/**
	 * this method is used to get the month in number format
	 * @param s
	 * @return
	 */
	public int getMonthInMMFormat(String s)
	{
		int value=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(s).get(ChronoField.MONTH_OF_YEAR);
		return value;
	}
	/**
	 * this method will return the date and type of system
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		Date date=new Date();
		return date.toString();

	}
	/**
	 * this method is used to get system date with proper format
	 * @return
	 */
	public  String getSystemDateWithFormat()
	{ 
		Date date=new Date();
		String dateAndTime=date.toString();
		String yyyy=dateAndTime.split(" ")[5];
		String dd=dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
		String finalFormat=yyyy+"-"+MM+"-"+dd;
		return finalFormat;
	}
	public  String getDateAndTime()
	{ 
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String d=sdf.format(date);
		return d;
	}


}
