package com.sai.java.features.dateTimeAPI;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeDemo
{
	public static void main(String[] args)
	{
		/*Java 8 has introduced new classed for date and time*/
		/*Local simply refers to system time zone*/
		/*Zoned simply refers specific to time zone*/
		
		/*LocalDate is just date*/
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		
		/*LocalTime is just time*/
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);
		
		/*LocalDateTime is date with time stamp*/
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime);
		
		currentDate = null;
		/*Getting local date from local date time*/
		currentDate = currentDateTime.toLocalDate();
		System.out.println(currentDate);
		
		/*others*/
		System.out.println(currentDate.getMonth());
		System.out.println(currentDate.getYear());
		System.out.println(currentDate.getDayOfMonth());
		System.out.println(currentDate.getDayOfYear());
		/*Same in local date time as well*/
		System.out.println(currentDateTime.getMonth());
		System.out.println(currentDateTime.getYear());
		System.out.println(currentDateTime.getDayOfMonth());
		System.out.println(currentDateTime.getDayOfYear());
		/*Extra will also be there for time*/
		System.out.println(currentDateTime.getHour());
		System.out.println(currentDateTime.getMinute());
		System.out.println(currentDateTime.getSecond());
		
		/*of is used to create a local date object for custom date*/
	    LocalDate oldDate = LocalDate.of(2014, Month.DECEMBER, 12);
	    System.out.println("oldDate " + oldDate);
	    
	    /*with method is used to change the object once created*/
	    oldDate = oldDate.withMonth(11);
	    System.out.println(oldDate);
	    
	    /*parse is used to parse the given string*/
	    LocalDate parsedDate = LocalDate.parse("2014-12-12");
	    System.out.println("parsedDate " + parsedDate);
	    
	    /*these method will be in similar fashion to all the classes in java.time*/
	    
	    /*uses the system time zone by default*/
	    ZonedDateTime zonedDateTime = ZonedDateTime.now();
	    System.out.println(zonedDateTime);
	    
	    /*uses the time zone passed by selecting from existing in the first case followed by custom*/
	    zonedDateTime = ZonedDateTime.now(ZoneId.of(ZoneId.getAvailableZoneIds().iterator().next()));
	    System.out.println(zonedDateTime);
	    
	    zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
	    System.out.println(zonedDateTime);
	    
	    /*ChronoUnit enum was introduced in java 8 it will be used as below*/
	    currentDate = null;
	    currentDate = LocalDate.now();
	    System.out.println(currentDate);
	    /*adding one day to current date using plus method and ChronoUnit enum*/
	    currentDate = currentDate.plus(1, ChronoUnit.DAYS);
	    System.out.println(currentDate);
	    /*adding 1 month,1 day,1 year using ChronoUnit enum*/
	    currentDate = currentDate.plus(1, ChronoUnit.WEEKS);
	    System.out.println(currentDate);
	    currentDate = currentDate.plus(1, ChronoUnit.MONTHS);
	    System.out.println(currentDate);
	    currentDate = currentDate.plus(1, ChronoUnit.YEARS);
	    System.out.println(currentDate);
	    
	    /*To find the difference between 2 dates we can use Period class where as if between 2 times we can use Duration class*/
	    currentDate = LocalDate.now();
	    LocalDate futureDate = currentDate.plus(1,ChronoUnit.MONTHS);
	    System.out.println(currentDate);
	    System.out.println(futureDate);
	    
	    Period period = Period.between(futureDate, currentDate);
	    System.out.println(period);
	    
	    currentTime = LocalTime.now();
	    LocalTime futureTime = currentTime.plus(5,ChronoUnit.HOURS);
	    Duration duration = Duration.between(futureTime, currentTime);
	    System.out.println(duration);
	    
	    /*Java 8 has introduced Temporal Adjustors which are used for date calculations like get the day of certain week etc..*/
	    /*TemporalAdjustors class will give us the specific temporal adjuster which needs to be passed to the with method*/
	    /*DayOfWeek is an enum representing the days of a week*/
	    currentDate = LocalDate.now();
	    futureDate = currentDate.with(TemporalAdjusters.lastDayOfYear());
	    System.out.println("Lastdate of the current year is " + futureDate);
	    futureDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
	    System.out.println("Date of the next wednesday is " + futureDate);
	    
	    /*Like the above, temporal adjustors can be used for various calculations*/
	    
	    /*Java already has date,time, now how does they can be converted to the latest date,time objects allowing backward compatibility*/
	    /*Instant class is introduced in java 8 for backward compatibility for date and time using ofInstant method in respective class*/
	    Date utilDate = new Date();
	    System.out.println(utilDate);
	    /*Date uses date with time stamp so we can only convert them to LocalDateTime object but not LocalDate since it only supports date not time*/
	    Instant oldDateInstant = utilDate.toInstant();
	    LocalDateTime dateTime = LocalDateTime.ofInstant(oldDateInstant, ZoneId.systemDefault());
	    System.out.println(dateTime);
	    zonedDateTime = ZonedDateTime.ofInstant(oldDateInstant, ZoneId.systemDefault());
	    System.out.println(zonedDateTime);
	}
}
